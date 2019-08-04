package com.lihegang.config;

import com.lihegang.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Created by dong-er on 2019-08-04.
 */
@Configuration
@ComponentScan(value="com.lihegang",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
        //  @ComponentScan.Filter(type= FilterType.CUSTOM,value= {MyTypeFilter.class})
})
//@ComponentScan value:指定要扫描的包
//excludeFilters = Filter[] : 指定扫描的时候按照什么规则排除哪些组件
// includeFilters =Filter[] : 指定扫描的时候需要包含哪些组件
//FilterType.ANNOTATION 按照注解
//FilterType.ASSIGNABLE_TYPEl: 按照给定的类型
//FilterType.ASPECTJ: 使用ASPECTJ
//FilterType.REGEX : 使用正则表达式
//FilterType.CUSTOM : 自定义规则
public class MainConfig {


    @Bean(name="person")
    public Person person01(){
        return new Person("29","lihegang");
    }
}
