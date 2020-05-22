package com.jack.design.create.build.build5;

import java.math.BigDecimal;

/**
 * 套餐
 * Created by manchong on 2020/4/21.
 */
public interface Item {
    String name();
    Package packing();
    BigDecimal price();
}
