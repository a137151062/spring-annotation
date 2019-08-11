package com.lihegang.config;

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
 */
public class MainConfigOfAutowired {
}
