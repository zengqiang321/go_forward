package com.jack.design.behavioral.strategy.demo2;

/**
 * Created by manchong on 2020/4/7.
 */
public class CartPromotion  implements Promotion {
    @Override
    public Promote getPromote() {
        return new Promote("CartPromote");
    }
    @Override
    public boolean isSupport(String strategy) {
        return "CART".equalsIgnoreCase(strategy);
    }

    @Override
    public String getStrategyName() {
        return "CART";
    }
}
