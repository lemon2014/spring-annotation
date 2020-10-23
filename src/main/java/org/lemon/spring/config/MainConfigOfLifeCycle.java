package org.lemon.spring.config;

import org.springframework.context.annotation.Configuration;


/**
 * 构造对象（对象的创建）
 * 单实例：在容器启动的时候创建对象
 * 多实例：在每次获取的时候创建对象
 * <p>
 * postProcessBeforeInitialization
 * <p>
 * 初始化：
 * 对象创建完成，并赋值好，调用初始化方法 。。。。
 * <p>
 * postProcessAfterInitialization
 * <p>
 * 销毁：
 * 单实例：容器关闭的时候
 * 多实例：容器不会管理这个bean，容器也不会调用销毁的方法
 * <p>
 * 具体的可以直接看代码
 * <p>
 * spring底层对BeanPostProcessor的使用
 * bean赋值、注入其他组件、@Autowired、生命周期注解功能、@Aysnc 等都是通过BeanPostProcessor来实现的
 *
 * 具体可以看AutowiredAnnotationBeanPostProcessor类的实现
 *
 */
@Configuration
public class MainConfigOfLifeCycle {

    /**
     * 1）、指定初始化和销毁方法 @Bean 指定init-method,destroy-method
     *
     * 2）、通过让bean实现InitializingBean,DisposableBean （定义初始化逻辑和销毁逻辑）
     *
     * 3）、使用jsR250 @PostConstruct 在bean创建完成并且属性赋值完成来执行初始化方法
     *                @PreDestroy 在容器销毁bean之前通知我们进行清理工作
     *
     * 4）、BeanPostProcessor： bean的后置处理器，在bean初始化前后进行一些处理
     *      postProcessBeforeInitialization 在初始化之前工作
     *      postProcessAfterInitialization 在初始化之后调用
     *
     *
     *  要重点关注的是这个几个方法的具体执行时机
     *
     *  先实例化，主动使用，触发类的初始化
     *
     */

}
