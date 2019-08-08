package com.lihegang.bean;

/**
 *  bean的生命周期测试类
 * Created by dong-er on 2019-08-06.
 */
public class LifeCar {
    public LifeCar() {
        System.out.println("lifeCar constructor...");
    }

    public void init(){
        System.out.println("lifeCar init...");
    }

    public void detory(){
        System.out.println("lifeCar detory...");
    }

}
