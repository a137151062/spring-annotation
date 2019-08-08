package com.lihegang.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Created by dong-er on 2019-08-06.
 */
@Component
public class LifeCat implements InitializingBean,DisposableBean {

    public  LifeCat(){
        System.out.println("LifeCat constructor...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("LifeCat...destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("LifeCat...afterPropertiesSet...bean创建完成属性赋值后...");
    }
}
