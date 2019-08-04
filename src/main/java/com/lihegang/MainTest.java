package com.lihegang;

import com.lihegang.bean.Person;
import com.lihegang.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by dong-er on 2019-08-04.
 */
public class MainTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = (Person) context.getBean("person");
        System.out.println("容器中bean=" + person);
        String[] definationNames = context.getBeanDefinitionNames();
        for (String name : definationNames){
            System.out.println(name);
        }
    }
}
