package com.lihegang.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by dong-er on 2019-08-06.
 */
@Component
public class LifeDog implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public LifeDog(){
        System.out.println("LifeDog...constructor...");
    }

    // 对象依赖注入创建完成并赋值之后调用
    @PostConstruct
    public void init(){
        System.out.println("LifeDog...@PostConstruct...");
    }

    // 容器移除对象之前调用
    @PreDestroy
    public void detory(){
        System.out.println("LifeDog...@PreDestroy...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
