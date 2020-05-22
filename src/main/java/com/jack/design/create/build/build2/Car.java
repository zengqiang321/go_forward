package com.jack.design.create.build.build2;

/**
 * Created by manchong on 2020/4/7.
 */
public class Car {

    private final String name;
    private final String money;

    private Car(String name, String money){
        this.money=money;
        this.name=name;
    }

    public static Builder create(){
        return new Builder();
    }

    public static class Builder {

        private String name;
        private String money;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setMoney(String money) {
            this.money = money;
            return this;
        }

        public Car build() {
            return new Car(name,money);
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
