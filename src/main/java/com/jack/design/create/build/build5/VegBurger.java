package com.jack.design.create.build.build5;

import java.math.BigDecimal;

/**
 * 素食汉堡
 * Created by manchong on 2020/4/21.
 */
public class VegBurger  extends Burger {
    @Override
    public String name() {
        return "VegBurger";
    }

    @Override
    public BigDecimal price() {
        return BigDecimal.valueOf(50);
    }
}
