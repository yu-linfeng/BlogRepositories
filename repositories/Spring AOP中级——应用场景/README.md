# <center>用户管理示例</center>
> 博客地址：[http://www.cnblogs.com/yulinfeng/p/7764600.html](http://www.cnblogs.com/yulinfeng/p/7764600.html)

## 简介
该示例是为了展示在较为真实的环境中模拟Spring AOP是如何使用的，实际的环境可能比此示例更复杂。该示例定义了**日志切面**。

## 环境
```
OS: macOS Sierra V10.12.6
Java: 1.8.0_144
MySQL: 5.7.19 
IDE: IDEA 2017.2.5
```
## 文档
**RESTful API**

|请求类型|请求路径|请求参数|返回参数|功能|
|----|----|----|----|----|----|
|GET|/users||{"users": [{"id": "1", "name": "kevin", "age": "23"}, {"id": "2", "name":"steve", "age": "24"},	{"id": "3", "name": "tony", "age": "235"}]}|查找用户|
|POST|/users|{user: {id: "1", name: "kevin", age: "23"}}|{user: {id: "1", name: "kevin", age: "23"}}|新增用户|
|GET|/users/id|{id: "1"}|{user: {id: "1", name: "kevin", age: "23"}}|根据用户id查询用户|
|PUT|/users/id|user: {id: "1", name: "kevin", age: "23"}|通过用户id修改用户|
|DELETE|/users/id|{id: "1"}|通过用户id删除用户|
**注：此RESTful API设计可能不规范，只做参考，有误的地方希望能给出指正。*

## 项目结构
```
manager
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── manager
    │   │           ├── aspect
    │   │           │   └── LogAspect.java
    │   │           └── user
    │   │               ├── controller
    │   │               │   └── UserController.java
    │   │               ├── dao
    │   │               │   ├── IUserDao.java
    │   │               │   └── IUserMapper.xml
    │   │               ├── pojo
    │   │               │   └── User.java
    │   │               └── service
    │   │                   ├── IUserService.java
    │   │                   └── impl
    │   │                       └── UserServiceImpl.java
    │   ├── resources
    │   │   ├── applicationContext.xml
    │   │   ├── db.properties
    │   │   ├── log4j.properties
    │   │   └── spring-servlet.xml
    │   └── webapp
    │       ├── WEB-INF
    │       │   └── web.xml
    │       └── index.jsp
    └── test
        └── java
            └── com
                └── manager
                    └── user
                        └── controller
                            └── UserControllerTest.java

``` 
