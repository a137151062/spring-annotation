package com.lihegang;

import com.lihegang.bean.Person;
import com.lihegang.config.MainConfig;
import com.lihegang.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * Created by dong-er on 2019-08-04.
 */
public class IocTest {

    /**
     * 判断condition
     */
    @Test
    public void test3(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        ConfigurableEnvironment environment = context.getEnvironment();
        // 动态获取环境变量的值
        String systemName = environment.getProperty("os.name");
        System.out.println(systemName);

        // 查看容器几个人
        String[] namesForType = context.getBeanNamesForType(Person.class);
        for (String name : namesForType){
            System.out.println("现在的人：" + name);
        }

        // 对象和id都在map里面
        Map<String, Person> persons= context.getBeansOfType(Person.class);
        System.out.println(persons);
    }

    @Test
    public void test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        // 容器中的bean
        String[] definationNames = context.getBeanDefinitionNames();
        for (String name : definationNames){
            System.out.println("===" + name);
        }
    }

    @Test
    public void test2(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        // 容器中的bean
        String[] definationNames = context.getBeanDefinitionNames();
        for (String name : definationNames){
            System.out.println("===" + name);
        }

        //默认是单实例
        Object bean = context.getBean("person");
        Object bean2 = context.getBean("person");
        System.out.println(bean == bean2);
    }
}
