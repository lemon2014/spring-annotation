package org.lemon.spring.config;

import org.lemon.spring.bean.Black;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Black> {

    //返回一个black对象，这个对象会添加到容器中
    @Override
    public Black getObject() throws Exception {
        return new Black();
    }

    @Override
    public Class<?> getObjectType() {
        return Black.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
