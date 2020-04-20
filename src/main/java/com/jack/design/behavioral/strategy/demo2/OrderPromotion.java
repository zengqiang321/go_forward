package com.jack.design.behavioral.strategy.demo2;

/**
 * Created by manchong on 2020/4/7.
 */
public class OrderPromotion implements Promotion {

    @Override
    public Promote getPromote() {
        return new Promote("Order");
    }


    @Override
    public boolean isSupport(String strategy) {
        return "ORDER".equalsIgnoreCase(strategy);
    }

    @Override
    public String getStrategyName() {
        return "ORDER";
    }

}
