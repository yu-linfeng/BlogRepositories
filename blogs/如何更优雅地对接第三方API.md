**本文所有示例完整代码地址：https://github.com/yu-linfeng/BlogRepositories/tree/master/repositories/third**

我们在日常开发过程中，有不少场景会对接第三方的API，例如第三方账号登录，第三方服务等等。第三方服务会提供API或者SDK，我依稀记得早些年Maven还没那么广泛使用，通常要对接第三方服务的时候会去下载第三方服务的SDK开发包，也就是jar包，拷贝到自己的工程中进行开发。但现如今，几乎所有的大中小企业都使用Maven进行依赖管理，第三方服务通过提供SDK包的情况越来越少，有的SDK也早已处于不再更新的状态。并且现在流行的微服务以及轻量级的RESTful通信方式，使得第三方服务主要提供API接口。

API接口，指的是通过HTTP的方式提供服务对接，也就需要对接方发起HTTP请求，解析第三方服务返回的数据；而SDK开发包，指的是对接方直接调用第三方服务提供的Java方法进行调用，不再对第三方服务发起HTTP请求。从便利性上讲，以SDK的方式对接第三方服务，的确能更加方便地进行开发对接工作。而从目前的趋势看，以RESTful通信的微服务正逐渐成为主流，服务的提供方也不再对外提供SDK开发包，因为这涉及开发量以及包的依赖问题。

我仍记得在第一家公司对接第三方API时的场景，业务要求能通过**微信发起WiFi连接**，这自然需要对接微信提供的API接口。那时我用了“最低级”的对接方式，也就是使用原生JDK发起HTTP请求，以及对HTTP响应的JSON数据进行解析获取我想要的数据。这其中的坑不胜其数，手写的HTTP请求客户端本身的不健壮，解析响应数据时经常抛出空指针，其中的苦恼不尽其数。

直到现在，SpringBoot为我们封装了```RestTemplate```，再到SpringCloud可以通过```Feign```让我们调用API就好像在调用接口一般顺滑。

```Feign```诠释了什么是面向对象，什么是一切皆为对象，我甚至认为，它可以作为面向对象编程实践的典型。

所以本文将以下4个示例讲述如何优雅地对接第三方API。

- 原生JDK构造HTTP请求客户端，调用API
- 在SpringBoot下使用```RestTemplate```，以及抽取配置的方式调用API
- 使用```OpenFeign```以及抽取配置的方式调用API

> **准备工作**
>
> 第三方API提供方，聚合数据：[www.juhe.cn](www.juhe.cn)
>
> API接口详情：[https://www.juhe.cn/docs/api/id/21](https://www.juhe.cn/docs/api/id/21)
>
> appKey（建议注册账号免费申请）：71e065a2cdf2753a5d6261b5002498b7
>
> 实现的功能：根据股票代码获取股票名称

### 原生JDK构造HTTP请求客户端，调用API

这种方式需要手动去创建HTTP连接，并将数据写入流中，再将数据转换为JSON对象进行解析。

存在以下几个问题：

1. 配置未抽取，以硬编码方式注入不利于维护
2. 返回的数据是字符串，将它转换为JSON对象极其不直观
3. 原生JDK构造HTTP客户端不能保证健壮性

**第一个问题**，首先是不可取的，必须将它抽取为```properties```或者```yml```配置。将appId或者appKey以硬编码的方式注入，不是一个合格的工程师。

**第二个问题**，转换为JSON对象获取数据：

```java
//本文所有示例完整代码地址：https://github.com/yu-linfeng/BlogRepositories/tree/master/repositories/third
String data = getResponse(code);		//获取API返回数据
JSONObject jsonObject = JSONObject.parseObject(data);		//将数据转换为JSON对象
if (jsonObject.getInteger("error_code") != 0) {		//判断API接口是否调用成功
  return ;
}
//解析数据，获取股票名称
JSONArray resultArray = JSONArray.parseArray(jsonObject.getString("result"));
JSONObject result = JSONObject.parseObject(resultArray.getString(0));
JSONObject stockObject = JSONObject.parseObject(result.getString("data"));
String stockName = stockObject.getString("name");
```

你写完后，还能回忆起这个API接口所返回的数据格式吗？

**第三个问题**，也就是上面代码片段中的```getResponse```方法：

```java
//本文所有示例完整代码地址：https://github.com/yu-linfeng/BlogRepositories/tree/master/repositories/third
String strUrl = String.format(URL, code, APPKEY);
StringBuffer sb = new StringBuffer();
URL url = new URL(strUrl);
HttpURLConnection conn = (HttpURLConnection) url.openConnection();		//创建一个HTTP连接
//构造HTTP请求数据
conn.setRequestMethod("GET");
conn.setRequestProperty("User-agent", USER_AGENT);
conn.connect();		//打开连接
InputStream is = conn.getInputStream();
BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//将API接口的返回数据写入
String strRead = null;
while ((strRead = reader.readLine()) != null) {
  sb.append(strRead);
}
return sb.toString();
```

这种“教科书”式的实现方式，其代码的复杂度，健壮性都值得商榷，有的工程中将HTTP请求客户端封装成一个公共类，有的使用现有的一些HTTP请求客户端。但我认为这都不是好的方式。就算例如Okhttp有很好的稳定性，但也解决不了第二个接口返回数据解析的问题。

### 在SpringBoot下使用```RestTemplate```，以及抽取配置的方式调用API

前面我们使用最“古老”的方式发现了3个问题，在SpringBoot大行其道的今天，将一些配置抽取出来，不同的环境运行不同的配置文件是常见的做法。例如我们可以将上面的appKey放到```application.yml```配置文件中。

```yaml
juhe-stock:
  appKey: 71e065a2cdf2753a5d6261b5002498b7
```

同时定义第三方服务的配置类。

```java
package com.coderbuff.third2resttemplateprop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置
 * @author yulinfeng
 * @date 2019/12/26
 */
@Data
@Component
@ConfigurationProperties("juhe-stock")
public class JuheConfig {
  
    /**
     * appkey
     */
    private String appKey;
}
```

这样当Spring容器启动时，appKey就被注入到了```JuheConfig```类的```appKey```字段中。

第一个问题被完美解决了，接下来我们来看如何通过```RestTemplate```解决第二、第三个问题。

```RestTemplate```简化了我们发起HTTP请求，它内部默认使用JDK构造HTTP客户端，它发起HTTP请求获取响应数据通过```getForObject```和```getForEntity```，前者能直接将响应数据封装成一个对象，后者则将封装HTTP调用的一些响应状态，在我们使用```getForObject```。

```getForObject```能将响应数据直接转换为一个对象供我们使用，这意味着我们不再依靠繁琐的JSON格式转换获取我们想要的数据，但同时也意味着我们需要定义返回对象。我们先看示例中，返回的JSON是怎么的格式。

```json
{
    "resultcode":"200",
    "reason":"SUCCESSED!",
    "result":[
        {
            //省略
            "dapandata":{
                "name":"贵州茅台"
              	//省略
            }
        }
    ],
    "error_code":0
}
```

因为篇幅原因，我省略了一些字段信息。观察JSON数据格式，我们只需要拿到股票名称，股票名称处于比较底层的位置，我们定义一个叫做```JuheStockResultDapanData```的类，字段和JSON中的key相同。

```java
package com.coderbuff.third2resttemplateprop.entity;

import lombok.Data;

/**
 * @author yulinfeng
 * @date 2019/12/26
 */
@Data
public class JuheStockResultDapanData {
    private String name;
}
```

它的外层key是一个数组，对应的也就是```List```，其中的一个对象就是我们定义的```JuheStockResultDapanData```，所以我们定义一个```JuheStockResult```类，对应JSON中key=result的数据。

```java
package com.coderbuff.third2resttemplateprop.entity;

import lombok.Data;

/**
 * @author yulinfeng
 * @date 2019/12/26
 */
@Data
public class JuheStockResult {
    private JuheStockResultDapanData dapandata;
}
```

在最外层是一些调用信息和错误码，所以我们继续定义一个响应类```JuheStockResponse```。

```java
package com.coderbuff.third2resttemplateprop.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author yulinfeng
 * @date 2019/12/26
 */
@Data
public class JuheStockResponse {

    /**
     * 响应码
     */
    private String resultcode;

    /**
     * 错误信息
     */
    private String reason;

    /**
     * 错误码
     */
    private String error_code;

    /**
     * 数据
     */
    private List<JuheStockResult> result;
}
```

注意字段名要和API接口返回的JSON数据key值保持一致。这样我们就定义好了整个JSON对象所对应的Java对象，其中我省略了很多字段，Java对象中没有JSON中对应的字段，数据自然也不会映射到Java对象中。接下来就是使用```RestTemplate#getForObject```方法调用API接口。

```java
//本文所有示例完整代码地址：https://github.com/yu-linfeng/BlogRepositories/tree/master/repositories/third
String url = String.format(URL, code, juheConfig.getAppKey());	//拼接URL
RestTemplate restTemplate = new RestTemplate();
restTemplate.setMessageConverters(parseContentType());	//设置ContentType支持的类型
JuheStockResponse response = restTemplate.getForObject(url, JuheStockResponse.class);
JuheStockResultDapanData juheStockResultDapanData = 
  response.getResult().get(0).getDapandata();
String name = juheStockResultDapanData.getName();
```

可以看到这种方式相比较于第一种“教科书”式调用HTTP接口，无论从易用性和健壮性都要略胜一筹，特别是不再去解析JSON对象，```RestTemplate```已经为我们做好了转换，这样的代码，即使换了一个人维护，也同样能明白是什么含义。

这种对接第三方API的方式，我想也是常年使用SpringBoot所采用的方式，因为它都解决了我们在开头提到几个问题，似乎想不到还能有什么更优雅地方式，直到遇到了下面的方式。

### 使用```OpenFeign```以及抽取配置的方式调用API

在使用这种方式调用第三方API时，我简直想要大呼一声**Amazing！**，简直太完美太优雅了。它不但解决了上面的3个问题，它同时把**面向对象**的思想发挥到了极致。

上面的思路不过是封装再封装，封装完HTTP客户端后又封装了JSON数据转换，实际上的思路仍然是传递一个URL->请求->响应的思路，但接下来的这种方式，真真正正地诠释了什么是**面向对象**，什么是**一切皆为对象**。

**它将API调用变得更加像调用普通接口一样方便。**

使用过SpringCloud的同学对```Feign```并不陌生，甚至觉得我孤陋寡闻。原版的```OpenFeign```可不依赖Spring独立使用（[ https://github.com/OpenFeign/feign]( https://github.com/OpenFeign/feign)），SpringCloud整合了```OpenFeign```，在SpringCloud2.x，Feign甚至成为了SpringCloud的一级项目（[ https://cloud.spring.io/spring-cloud-openfeign/]( https://cloud.spring.io/spring-cloud-openfeign/)）这足以体现它的地位。

在SpringCloud中，```OpenFeign```的功能很强大，它为微服务架构下服务之间的调用提供了解决方案，同时它可以结合其它组件可以实现负载均衡的HTTP客户端。

接下来我们将展示使用原版的```OpenFeign```优雅地调用第三方API服务。

我们同样需要定义```JuheStockResponse```、```JuheStockResult```、```JuheStockResultDapanData```类，因为在```OpenFeign```中，也自动的将JSON数据转换为了Java对象。但我们需要定义一个**接口**——```JuheClient```。

```java
package com.coderbuff.third3feignprop;

import com.coderbuff.third3feignprop.entity.JuheStockResponse;
import feign.Param;
import feign.RequestLine;

/**
 * @author yulinfeng
 * @date 2019/12/26
 */
public interface JuheClient {

    /**
     * 根据股票代码查询股票信息
     * @param code 股票代码
     * @return 接口返回
     */
    @RequestLine("GET /finance/stock/hs?gid={gid}&key={key}")
    JuheStockResponse queryStock(@Param("gid") String code, @Param("key") String appKey);
}
```

这简直就是**面向对象**思想的最佳实践，接下来的工作基本上就是直接调用这个方法，就能调用我们想要调用的API。

```java
//本文所有示例完整代码地址：https://github.com/yu-linfeng/BlogRepositories/tree/master/repositories/third
JuheClient client = Feign.builder().encoder(new JacksonEncoder()).decoder(new JacksonDecoder()).target(JuheClient.class, juheConfig.getUrl());
JuheStockResponse response = client.queryStock(code, juheConfig.getAppKey());
JuheStockResultDapanData juheStockResultDapanData = 
  response.getResult().get(0).getDapandata();
String name = juheStockResultDapanData.getName();
```

这看起来似乎和直接使用```RestTemplate```并无大异，但我仍然想表达我的激动，我仍然认为这其中的奥秘不在于编码的具体实现，而在于将API接口调用上升到了**面向对象**的最佳实践。没有了URL的拼接，像调用普通接口一样方便地调用第三方API。

**本文所有示例完整代码地址：https://github.com/yu-linfeng/BlogRepositories/tree/master/repositories/third**