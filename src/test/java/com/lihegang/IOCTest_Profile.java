package com.lihegang;

import com.lihegang.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * Created by dong-er on 2019-08-11.
 */
public class IOCTest_Profile {

    // 1. 使用命令行动态参数：在虚拟机参数位置：-Dspring.profile.active=test
    // 2. 代码的方式激活某种环境
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);

        System.out.println("容器创建完成...");

        String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String string : namesForType){
            System.out.println("数据源是：" + string);
        }
        // 关闭容器
       // applicationContext.close();
    }

    @Test
    public void test02(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        System.out.println("容器创建完成...");

        //1. 创建一个无参applicationContext
        //2. 设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("test","dev");
        //3. 注册主配置类
        applicationContext.register(MainConfigOfProfile.class);
        //4.启动刷新容器
        applicationContext.refresh();

        String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String string : namesForType){
            System.out.println("数据源是：" + string);
        }

        // 关闭容器
        // applicationContext.close();
    }
}
