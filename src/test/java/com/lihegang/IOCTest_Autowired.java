package com.lihegang;

import com.lihegang.bean.RedAware;
import com.lihegang.config.MainConfigOfAutowired;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by dong-er on 2019-08-11.
 */
public class IOCTest_Autowired {
    @Test
    public void test01() {
        //1. 创建ioc容器，会调用对象的构造器。创建---初始化--销毁
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

        System.out.println("容器创建完成...");

/*        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println("boss=" + boss);
        AutowiredCar car = applicationContext.getBean(AutowiredCar.class);
        System.out.println("car=" + car);*/
        RedAware redAware = applicationContext.getBean(RedAware.class);
        String value = redAware.getValueFromResolver("person.from");
        System.out.println("value===" + value);
        // 关闭容器
        applicationContext.close();
    }
}
