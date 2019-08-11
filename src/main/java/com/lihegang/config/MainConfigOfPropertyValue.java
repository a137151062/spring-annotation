package com.lihegang.config;

import com.lihegang.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by dong-er on 2019-08-08.
 */
// 使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量
    // 加载完成后用${}取出配置文件的值
@PropertySource(value={"classpath:application.properties"})
@Configuration
public class MainConfigOfPropertyValue {

    @Bean
    public Person person(){
        return new Person();
    }

}
