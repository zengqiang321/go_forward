package com.jack.design.create.build;

/**
 * Created by manchong on 2020/4/7.
 */
public class WCarBuilder implements Builder {

    private String wheel;
    private String head;

    @Override
    public void setCarWheel(String wheel) {
        this.wheel=wheel;
    }

    @Override
    public void setCarHead(String head) {
        this.head=head;
    }

    @Override
    public Car build() {
        Car car = new WCar();
        car.setSetWheel("wc");
        car.setSetWheel("ddd");
        return car;
    }
}
