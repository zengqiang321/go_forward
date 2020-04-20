package com.jack.design.behavioral.strategy.demo1;

/**
 * Created by manchong on 2020/4/7.
 */
public class OrderPromotion implements Promotion {

    @Override
    public Promote getPromote() {
        return new Promote("Order");
    }
}
