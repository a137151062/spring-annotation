package com.lihegang.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by dong-er on 2019-08-04.
 * 判断是否Linux系统
 */
public class LinuxCondition implements Condition{

    /**
     * @param conditionContext 能使用的上下文环境
     * @param annotatedTypeMetadata 注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        // 是否linux系统
        // 1.获取到ioc使用的beanfactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        // 2. 获取类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        // 3. 获取环境变量
        Environment environment = conditionContext.getEnvironment();
        // 4. 获取到bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();
        String property = environment.getProperty("os.name");

        // 可以判断容器中的bean注册情况，也可以给容器中注册bean
        boolean definition = registry.containsBeanDefinition("person");
        if(property.contains("linux")){
            return true;
        }
        return false;
    }
}
