package org.lemon.spring.config;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class LinuxConditional implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 拿到bean工厂
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 获取到类加载器
        ClassLoader classLoader = context.getClassLoader();
        // 获取到bean定义注册对象
        BeanDefinitionRegistry registry = context.getRegistry();
        // 获取到环境变量对象
        Environment environment = context.getEnvironment();
        String osName = environment.getProperty("os.name");

        // 获取到该对象上面的元注解信息, 这里需要使用全路径名称
        Map<String, Object> map = metadata.getAnnotationAttributes("org.springframework.context.annotation.Bean");
        System.out.println("当前系统环境:" + osName);
        if (osName.contains("Linux")) {
            return true;
        }
        return false;
    }
}
