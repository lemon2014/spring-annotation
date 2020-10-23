package org.lemon.spring.config;

import org.springframework.context.annotation.Configuration;

/**
 * 自动装配 spring利用依赖注入(DI),完成容器IOC中各个组件的依赖关系赋值   重点
 *
 * 1、@Autowired 自动注入
 *  1)默认优先级按照类型去容器中找对应的组件applicationContext.getBean(BookDao.class);
 *  2)如果找到多个相同类型的组件、再将属性的名称做为组件的id去容器中查找
 *   applicationContext.getBean("bookDao");
 *  3)@Qualifier("bookDao")使用@Qualifier指定需要装配的组件id，而不是使用属性名
 *  4）自动装配默认一定要将属性赋值好，没有就会报错
 *  可以使用@Autowired（required=false）
 *  5）@Primary 让spring进制自动装配的时候默认使用首选的bean
 *  也可以继续使用@Qualifier指定需要装配的bean的名字
 *
 *  2、@Resource 可以和Autowired一样实现装配功能，默认是按名称装配的，不支持其他功能
 *      1）@Inject 需要导入 javax.inject 和 autowired一样 没有required = false
 *
 *  AutowiredAnnotationBeanPostProcessor 来实现上面的功能
 *
 * 3、构造器、方法、属性上面都可以使用该注解
 *      1）标注在方法位置
 *      2）标在构造器上
 *      3）放在参数位置上  public void set(@Autowired Person person){}
 *
 *  ********只要一个有参构造器的时候，不需要标注@Autowired，也会自动从容器中去拿对应的bean对象
 *
 *
 * 下面这种方式@Autowired也是可以省去不写的，这里的car也是直接从容器中获取然后注入进来
 * 但是这种写法只针对于一个参数的情况，如果是有多个参数，还是需要去指定
 * @Bean
 * public Person getPerson(Car car){
 * }
 *
 * 4、自定义组件如果想要使用spring自身的组件，ApplicationContext、BeanFactory、xxxxxxx
 * 自定义组件要实现XXXAware,在创建对象的时候，会调用接口规定的方法注入相关的组件，
 *  xxxxAware 功能使用 xxxxProcessor 来实现对应的功能
 *
 */
@Configuration
public class MainConfigOfAutowired {

}
