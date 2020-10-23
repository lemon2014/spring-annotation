package org.lemon.spring.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class ColorImportSelector implements ImportSelector {

    /**
     * importingClassMetadata 可以拿到该注解对应的类上面的所有注解信息
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
       String[] classes = new String[]{"org.lemon.spring.bean.Blue","org.lemon.spring.bean.Yellow"};
       return classes;
    }
}
