package org.lemon.spring.config;

import org.lemon.spring.bean.Color;
import org.lemon.spring.bean.Person;
import org.springframework.context.annotation.*;

@Configuration
// 这里可以设置不同的过滤规则
@ComponentScan(basePackages = "org.lemon.spring")
//@Conditional(LinuxConditional.class) //作用在这里,windows环境下面的所有的@Bean都不会加载到ioc容器中
@Import({Color.class, ColorImportSelector.class, MyBeanRegister.class})
public class MainConfig {

    /**
     * @Bean 默认使用方法名做为ioc容器中的name, 使用value来设置name
     */
    @Bean(value = "person")
    public Person getPerson() {
        System.out.println("===============执行person初始化操作");
        Person person = new Person();
        person.setAge(19);
        person.setName("zhangsan");
        return person;
    }

    /**
     * @Conditional 控制bean是否加载, 放在类上面表示控制该类里面的所有bean是否加载，放在方法
     * 上面，表示控制该方法返回的bean是否加载
     */
    @Bean(value = "personWindows")
    @Primary
    @Conditional(WindowsConditional.class)
    public Person person1() {
        return new Person("bill", 56);
    }

    @Bean(value = "personLinus")
    @Conditional(LinuxConditional.class)
    public Person person2() {
        return new Person("linus", 66);
    }

    /**
     * 给容器中注册组件
     * 1、包扫描+组件注解(@Controller/@Service、@Repository/@Component)
     * 2、@Bean 导入第三方的包里面的组件
     * 3、@Import 快速的给容器中导入组件
     *      1）@Import(要导入容器中的组件)
     *      2）ImportSelector: 返回需要导入到容器中的全类名数组
     *      3）ImportBeanDefinitionRegister：手动注册bean到容器中
     *  4、使用spring提供的FactoryBean（工厂bean）  BeanFactory和FactoryBean的区别？？
     *      1）默认获取到的是工厂Bean调用getObject创建的对象
     *      2）要获取工厂bean的本身，我们需要给id前面加上一个&
     *      3）这种方式是延时初始化的
     */
    @Bean
    public MyFactoryBean myFactoryBean(){
        return new MyFactoryBean();
    }
}
