package com.lihegang.condition;

import com.lihegang.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 组件注册
 * Created by dong-er on 2019-08-05.
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{

    /**
     *
     * @param annotationMetadata 当前类的注解信息
     * @param registry BeanDefinition注册类，
     *          把所有需要添加到容器的bean,调用
     *          BeanDefinitionRegistry.registerBeanDefinition()方法手动注册
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
        boolean definition = registry.containsBeanDefinition("com.lihegang.bean.Blue");
        boolean definition2 = registry.containsBeanDefinition("com.lihegang.bean.Yellow");
        if(definition && definition2){
            // 指定bean定义：（Bean的类型）
         RootBeanDefinition beanDefinition =  new RootBeanDefinition(RainBow.class);
            // 注册一个bean，指定bean名
            registry.registerBeanDefinition("rainBow",beanDefinition);
        }

    }
}
