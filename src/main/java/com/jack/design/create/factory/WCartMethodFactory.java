package com.jack.design.create.factory;

/**
 * Created by manchong on 2020/4/7.
 */
public class WCartMethodFactory extends AbstractFactory {

    @Override
    public Cart getCart() {
        return new WCart();
    }
}
