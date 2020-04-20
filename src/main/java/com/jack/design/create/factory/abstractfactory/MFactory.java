package com.jack.design.create.factory.abstractfactory;

/**
 * Created by manchong on 2020/4/7.
 */
public class MFactory implements AbFactory {
    @Override
    public Food getFood() {
        return new MFood();
    }

    @Override
    public Cart getCart() {
        return new MCart();
    }
}
