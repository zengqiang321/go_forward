package com.jack.design.create.build.build4;

import java.math.BigDecimal;

/**
 *  可口可乐
 * Created by manchong on 2020/4/21.
 */
public class Coke extends ColdDrink{
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public BigDecimal price() {
        return BigDecimal.valueOf(15);
    }
}
