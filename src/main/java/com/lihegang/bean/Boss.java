package com.lihegang.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 默认加在ioc容器中的组件，容器启动会调用无参构造器创建对象，再进行初始化赋值操作
 */
@Component
public class Boss {

    private AutowiredCar car;

    public AutowiredCar getCar() {
        return car;
    }

    // 构造器用的组件，也都是从容器中获取
    @Autowired
    public Boss(AutowiredCar car) {
        this.car = car;
        System.out.println("Boss...的有参构造器...");
    }

    // 标注在方法上，spring容器创建当前对象就会调用方法，完成赋值
    // 方法是用的参数：自定义类型的值从IOC容器中获取
  //  @Autowired
    public void setCar(AutowiredCar car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "AutowiredCar=" + car +
                '}';
    }
}
