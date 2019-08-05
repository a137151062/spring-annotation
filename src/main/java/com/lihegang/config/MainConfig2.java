package com.lihegang.config;

import com.lihegang.bean.Color;
import com.lihegang.bean.ColorFactoryBean;
import com.lihegang.bean.Person;
import com.lihegang.condition.LinuxCondition;
import com.lihegang.condition.MyImportBeanDefinitionRegistrar;
import com.lihegang.condition.MyImportSelector;
import com.lihegang.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * Created by dong-er on 2019-08-04.
 */
@Configuration
@Import({Color.class,MyImportSelector.class, MyImportBeanDefinitionRegistrar.class}) // id默认是组件的全类名
public class MainConfig2 {

    /**
     *  singleton：单例，IOC容器启动会调用方法创建实例放入容器中
     *              以后获取直接从容器中拿
     *  prototype：多例，IOC容器启动不会创建对象，而是在每次获取的时候才会创建对象
     *              每次获取都会创建
     *  request: 同一次请求创建一个实例 web环境
     *  session:同一个session创建一个实例 web环境
     * @return
     */
    @Lazy // 容器启动不创建bean，第一次使用的时候创建bean并进行初始化
    @Bean("person")
 //   @Scope("prototype")
    public Person person(){
        System.out.println("给容器中添加Person...");
        return new Person("28","zhangleilei");
    }

    /**
     * @Condition,按照一定的条件进行判断，满足条件给容器中注入bean
     *
     * windows系统，注册 bill
     * linux 系统，注册linux
     * @return
     */
    @Conditional(WindowsCondition.class)
    @Bean("mayun")
    public Person person01(){
        return new Person("ma yun","55");
    }

    @Conditional(LinuxCondition.class)
    @Bean("linux")
    public Person person02(){
        return new Person("linux","20");
    }

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
