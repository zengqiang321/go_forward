package com.jack.design.structural.decorator.decorator;

import java.math.BigDecimal;

/**
 * Created by manchong on 2020/4/13.
 */
public class CoofeeTeaMilk implements TeaMilk {
    @Override
    public String name() {
        return "Cafe Americano";
    }

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(100D);
    }
}
