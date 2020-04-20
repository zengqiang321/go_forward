package com.jack.design.create.factory.abstractfactory;

/**
 * Created by manchong on 2020/4/7.
 */
public class WFactory implements AbFactory{
    @Override
    public Food getFood() {
        return new WFood();
    }

    @Override
    public Cart getCart() {
        return new WCart();
    }
}
