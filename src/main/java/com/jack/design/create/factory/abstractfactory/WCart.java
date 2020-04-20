package com.jack.design.create.factory.abstractfactory;

import com.jack.design.create.factory.abstractfactory.Cart;

/**
 * Created by manchong on 2020/4/7.
 */
public class WCart implements Cart {

    @Override
    public String getCartName() {
        return "WCart";
    }
}
