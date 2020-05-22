package com.jack.design.create.build.build4;

import java.math.BigDecimal;

/**
 * Created by manchong on 2020/4/21.
 */
public abstract class Burger implements Item {



    @Override
    public Package packing() {
        return new Wrapper();
    }

}
