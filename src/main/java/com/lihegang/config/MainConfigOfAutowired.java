package com.lihegang.config;

import com.lihegang.bean.AutowiredCar;
import com.lihegang.bean.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动装配：
 *      Spring利用依赖注入，完成对IOC容器中各个组件的关系赋值
 *  1. Autowired：自动注入
 *      1.1 默认优先按照类型去容器中找对应的组件，找到赋值
 *      1.2 如果找到多个相同类型的组件，再将注入的实体属性名称作为id查找
 *          @Autowired
 *          BookDao bookDao 如果存在多个BookDao，则按bookDao进行查找
 *      1.3 @Autowired和@Qualifier("bookDao") 可以指定注入组件的id，而不是属性名
 *      1.4 自动装配一定要将属性赋值好，否则报错，要想没找到不报错
 *          @Autowired(required=false) 即可
 *      1.5. @Primary：Spring自动装配的时候，默认使用首选的bean
 *      如在@Bean的注解上加 @Primary。 @Qualifer优先于@Primary
 *  2. Spring支持@Resource(JSR250)和@Inject(JSR330) -- JAVA规范注解
 *      @Resource：
 *          可以和@Autowired一样实现自动装配，默认按照组件名称进行装配
 *          可以指定 @Resource(name="bookDao2"),不支持@Primary和required=false属性
 *      @Inject：需要导入javax.inject包
 *  3. @Autowired：构造器、参数、属性、方法：都是从容器中获取参数组件的值
 *      3.1 标注在方法位置：@Bean + 方法参数，参数从容器中获取，默认不写@Autowired
 *      3.2 标注在构造器上
 *      3.3 放在参数位置
 *  4. 自定义组件使用Spring底层的组件（ApplicationContext,BeanFactory...XXX）
 *      自定义组件实现 xxxAware: 再创建对象d时候，会调用接口规定的方法注入相关组件 Aware
 *      把Spring底层一些组件注入到自定义Bean中
 *      xxxAware：功能使用xxxProcessor,如：ApplicationContextAware==>ApplicationContextAwareProcessor
 */
@Configuration
@ComponentScan({"com.lihegang.controller","com.lihegang.service",
        "com.lihegang.dao","com.lihegang.bean"})
public class MainConfigOfAutowired {

    /**
     * @Bean标注的方法创建对象的时候，方法参数的值从容器获取
     * @param car
     * @return
     */
    @Bean
    public Color color(AutowiredCar car){
        Color color = new Color();
        // color.setCar(car);
        return color;
    }
}
