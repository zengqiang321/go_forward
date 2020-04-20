package com.jack.design.create.build;

/**
 * Created by manchong on 2020/4/7.
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder =builder;
    }


    public Car createCar(){
        Car car = builder.build();

        return car;
    }

}
