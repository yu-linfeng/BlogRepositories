import com.coderbuff.bean.Cloth;
import com.coderbuff.factory.ColorFactoryBean;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cdyulinfeng
 * @date 2019/9/3
 **/
public class FactoryBeanTest {
    private ClassPathXmlApplicationContext ctx;

    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext("spring-bean.xml");
    }

    /**
     * 测试静态工厂方法注入依赖的对象实例
     */
    @Test
    public void testStaticFactoryMethod() {
        Cloth cloth = ctx.getBean(Cloth.class);
        cloth.getColor().print();   //能成功打印出"红色"，说明通过静态工厂方法成功注入Red实例
    }

    /**
     * 测试非静态工厂方法注入依赖的对象实例
     */
    @Test
    public void testFactoryMethod() {
        Cloth cloth = ctx.getBean(Cloth.class);
        cloth.getColor().print();   //能成功打印出"红色"，说明通过静态工厂方法成功注入Red实例
    }

    /**
     * 测试实现FactoryBean注入依赖的对象实例
     */
    @Test
    public void testFactoryBean() {
        Cloth cloth = ctx.getBean(Cloth.class);
        cloth.getColor().print();   //能成功打印出"红色"，说明通过静态工厂方法成功注入Red实例
        ColorFactoryBean colorFactoryBean = (ColorFactoryBean) ctx.getBean("&red");
        System.out.println(colorFactoryBean);   //加上"&"前缀获取的就是ColorFactoryBean本身
    }
}
