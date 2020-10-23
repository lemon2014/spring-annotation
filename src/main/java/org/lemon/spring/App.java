package org.lemon.spring;

import org.lemon.spring.bean.Person;
import org.lemon.spring.config.MainConfig;
import org.lemon.spring.config.MainConfigOfAOP;
import org.lemon.spring.config.MyMethod;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @ComponentScan 默认的包扫描路径
 */

public class App {
    public static void main(String[] args) {

        //这种是通过xml配置文件来加载bean以及配置
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        String[] beans = context.getBeanDefinitionNames();
//        Arrays.asList(beans).forEach(a -> System.out.println(a));

        //使用@Configuration和@Bean来代替上面的功能
//        ApplicationContext context1 = new AnnotationConfigApplicationContext(MainConfig.class);
//        String[] beans1 = context1.getBeanDefinitionNames();
//        Arrays.asList(beans1).forEach(a -> System.out.println(a));
//
//        // 默认容器中的bean对象都是单例的, 可以使用@Scope来改变bean的作用域
//        Person person1 = context1.getBean(Person.class);
//        Person person2 = context1.getBean(Person.class);
//        System.out.println(person1 == person2);
//
//        Object obj = context1.getBean("myFactoryBean");
//        System.out.println(obj);


        ApplicationContext context1 = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        MyMethod method = context1.getBean(MyMethod.class);
        System.out.println("================" + method.div(9, 4));
    }
}
