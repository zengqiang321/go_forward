package com.jack.design.create.factory;

/**
 * Created by manchong on 2020/4/7.
 */
public class MCartMethodFactory extends AbstractFactory {
    @Override
    public Cart getCart() {
        return new MCart();
    }
}
