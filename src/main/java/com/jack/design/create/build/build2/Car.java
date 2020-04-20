package com.jack.design.create.build.build2;

/**
 * Created by manchong on 2020/4/7.
 */
public class Car {

    private final String name;
    private final String money;

    private Car(String name,String money){
        this.money=money;
        this.name=name;
    }

    public static class builder {

        private String name;
        private String money;

        public builder setName(String name) {
            this.name = name;
            return this;
        }

        public builder setMoney(String money) {
            this.money = money;
            return this;
        }

        public Car build() {
            Car car = new Car(name,money);
            return car;
        }
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
