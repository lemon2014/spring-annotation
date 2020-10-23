package org.lemon.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP[动态代理]
 * 在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式
 *
 * 1、导入AOP模块
 *
 *
 *
 *
 */
@ComponentScan(basePackages = "org.lemon.spring.config")
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {

//    @Bean
//    public MyMethod myMethod(){
//       return new MyMethod();
//    }
//
//    @Bean
//    public MyAspect myAspect(){
//        return new MyAspect();
//    }
}
