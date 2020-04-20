package com.jack.design.structural.decorator.decorator;

import java.math.BigDecimal;

/**
 * Created by manchong on 2020/4/13.
 */
public class CooskinMilkTea implements TeaMilk {
    @Override
    public String name() {
        return "Cooskin Milk Tea";
    }

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(50D);
    }
}
