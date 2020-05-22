package com.jack.design.create.build.build5;

import java.math.BigDecimal;

/**
 * 百事可乐
 * Created by manchong on 2020/4/21.
 */
public class Pepsl extends ColdDrink {
    @Override
    public String name() {
        return "Pepsl";
    }

    @Override
    public BigDecimal price() {
        return BigDecimal.valueOf(15);
    }
}
