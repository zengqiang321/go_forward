package com.jack.design.create.build.build5;

/**
 * Created by manchong on 2020/4/21.
 */
public abstract class ColdDrink implements Item {
    @Override
    public Package packing() {
        return new Bottle();
    }
}
