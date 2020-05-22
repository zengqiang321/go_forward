package com.jack.design.create.build.build3;

/**
 * Created by manchong on 2020/4/7.
 */
public class T {

    public static void main(String[] args) {
        Car ben = CarBuilder.create().setMoney("100").setName("ben").build();
        System.out.println(ben);
    }

}
