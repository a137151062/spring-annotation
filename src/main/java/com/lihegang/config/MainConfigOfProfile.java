package com.lihegang.config;

import com.lihegang.bean.Yellow;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Profile：
 *      Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能
 *
 *  开发环境、测试环境、生产环境
 *  数据源：A、B、C等数据源  或 组件
 *
 *  @Profile ： 指定组件在哪个环境中才能被注册到容器中
 *      1. 加了环境标识的bean，只有这个环境被激活的时候才能注册到容器中。默认default环境
 *      2. 写在配置类上，只有指定的环境的时候，配置类中所有配置才能生效
 *      3. 没有标注环境标识的bean，在任何环境下都会加载
 */
@PropertySource("classpath:application.properties")
@Configuration
public class MainConfigOfProfile {

    @Profile("test")
    @Bean
    public Yellow yellow(){
        return new Yellow();
    }

    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("ijsu49sm");
        dataSource.setJdbcUrl("jdbc://118.25.94.8:3306/db1");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("ijsu49sm");
        dataSource.setJdbcUrl("jdbc://118.25.94.8:3306/db2");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource dataSourceProd() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("ijsu49sm");
        dataSource.setJdbcUrl("jdbc://118.25.94.8:3306/db3");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        return dataSource;
    }
}
