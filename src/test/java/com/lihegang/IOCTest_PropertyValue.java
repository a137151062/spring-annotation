package com.lihegang;

import com.lihegang.bean.Person;
import com.lihegang.config.MainConfigOfPropertyValue;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by dong-er on 2019-08-08.
 */
public class IOCTest_PropertyValue {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);

    @Test
    public void test01(){
        printBeans(applicationContext);

        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person.toString());
        // 关闭容器
        applicationContext.close();
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] definationNames = applicationContext.getBeanDefinitionNames();
        for (String name : definationNames){
            System.out.println("===" + name);
        }
    }
}
