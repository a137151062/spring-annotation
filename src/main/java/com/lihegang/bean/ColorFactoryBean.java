package com.lihegang.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 创建一个Spring定义的FactoryBean
 * Created by dong-er on 2019-08-05.
 */
public class ColorFactoryBean implements FactoryBean{

    // 返回一个Color对象，这个对象会添加到容器中
    @Override
    public Object getObject() throws Exception {
        System.out.println("ColorFactoryBean...getObject()...");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    // 控制是单例
    // true：单例   false：多实例
    @Override
    public boolean isSingleton() {
        return true ;
    }
}
