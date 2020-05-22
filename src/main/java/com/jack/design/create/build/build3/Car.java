package com.jack.design.create.build.build3;

/**
 * Created by manchong on 2020/4/21.
 */
public class Car {

    private final String name;
    private final String money;

    public Car(String name, String money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public String getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}
