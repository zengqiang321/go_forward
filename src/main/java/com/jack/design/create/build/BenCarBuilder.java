package com.jack.design.create.build;

/**
 * Created by manchong on 2020/4/7.
 */
public class BenCarBuilder implements Builder {

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
        Car cart = new BenCar();
        cart.setSetWheel(wheel);
        cart.setHeadstock(head);
        return cart;
    }
}
