package org.lemon.spring.config;

import org.lemon.spring.bean.YellowBlue;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyBeanRegister implements ImportBeanDefinitionRegistrar {

    /**
     * @param importingClassMetadata 该类使用import注解导入，这个参数可以获取到使用import注解对应类上面的所有注解
     * @param registry               获取所有的bean定义信息
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        String blue = registry.getBeanDefinition("org.lemon.spring.bean.Blue").getBeanClassName();
        String yellow = registry.getBeanDefinition("org.lemon.spring.bean.Yellow").getBeanClassName();
        System.out.println(blue);
        System.out.println(yellow);

        // 如果存在blue和yellow类,就加载yellowBlue到容器中
        if (null != blue && null != yellow) {
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(YellowBlue.class);
            registry.registerBeanDefinition("yellowBlue", rootBeanDefinition);
        }
    }
}
