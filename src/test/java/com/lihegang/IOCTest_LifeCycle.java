package com.lihegang;

import com.lihegang.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by dong-er on 2019-08-06.
 */
public class IOCTest_LifeCycle {

    @Test
    public void test01(){
        //1. 创建ioc容器，会调用对象的构造器。创建---初始化--销毁
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);

        System.out.println("容器创建完成...");

        // 关闭容器
        applicationContext.close();
    }
}
