package com.jack.design.create.build.build5;

import java.math.BigDecimal;

/**
 * 鸡肉汉堡
 * Created by manchong on 2020/4/21.
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "ChickenBurger";
    }

    @Override
    public BigDecimal price() {
        return BigDecimal.valueOf(100);
    }
}
