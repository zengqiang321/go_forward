package com.jack.design.create.build.build2;

/**
 * Created by manchong on 2020/4/7.
 */
public class T {

    public static void main(String[] args) {
        Car.builder builder  = new Car.builder();
        Car ben = builder.setMoney("100").setName("ben").build();
        System.out.println(ben);
    }

}
