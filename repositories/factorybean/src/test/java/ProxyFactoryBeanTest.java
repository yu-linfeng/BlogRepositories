import com.coderbuff.bean.Red;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cdyulinfeng
 * @date 2019/9/3
 **/
public class ProxyFactoryBeanTest {
    private ClassPathXmlApplicationContext ctx;

    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext("spring-proxyfactorybean.xml");
    }

    @Test
    public void testProxyFactory() {
        Red proxyRed = (Red) ctx.getBean("proxyRed");
        proxyRed.print();
        Red red = (Red) ctx.getBean("red");
        red.print();
    }
}
