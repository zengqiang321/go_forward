package com.jack.design.structural.decorator.decorator;

import java.math.BigDecimal;

/**
 * Created by manchong on 2020/4/13.
 */
public class AbstractTeaMilkDecator  implements TeaMilk {

    private TeaMilk teaMilk;

    public AbstractTeaMilkDecator(TeaMilk teaMilk) {
        this.teaMilk = teaMilk;
    }

    @Override
    public String name() {
        return teaMilk.name();
    }

    @Override
    public BigDecimal getPrice() {
        return teaMilk.getPrice();
    }
}
