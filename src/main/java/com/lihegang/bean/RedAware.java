package com.lihegang.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * 测试实现Aware各接口，显示不同功能
 */
@Component
public class RedAware implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {

    private ApplicationContext applicationContext;

    private StringValueResolver stringValueResolver;

    // 注入容器
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("传入的ioc容器= " + applicationContext);
        this.applicationContext = applicationContext;
    }

    // 查看设置bean名称
    @Override
    public void setBeanName(String name) {
        System.out.println("当前bean的名字 = " + name);
    }

    // 解析占位符
    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.stringValueResolver = resolver;
    }

    public String getValueFromResolver(String key) {
        String value = stringValueResolver.resolveStringValue("你好${os.name},我来自${" + key + "},尾号#{1747 +1}");
        System.out.println("解析的字符串..." + value);
        return value;
    }
}
