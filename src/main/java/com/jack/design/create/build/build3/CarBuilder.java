package com.jack.design.create.build.build3;

/**
 * Created by manchong on 2020/4/7.
 */
public class CarBuilder {

    private String name;
    private String money;

//    private CarBuilder(String name, String money){
//        this.money=money;
//        this.name=name;
//    }

    public static CarBuilder create(){
        return new CarBuilder();
    }

    public String getName() {
        return name;
    }

    public CarBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getMoney() {
        return money;
    }

    public CarBuilder setMoney(String money) {
        this.money = money;
        return this;
    }

    public Car build(){
        return new Car(this.name,this.money);
    }

    @Override
    public String toString() {
        return "CarBuilder{" +
                "name='" + name + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}
