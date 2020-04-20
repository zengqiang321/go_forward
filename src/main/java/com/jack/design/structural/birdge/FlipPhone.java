package com.jack.design.structural.birdge;

/**
 * Created by manchong on 2020/4/8.
 */
public class FlipPhone extends AbstractPhone {

    public FlipPhone(Brand brand) {
        super(brand);
    }

    @Override
    public void call() {
        super.call();
        System.out.println("   翻盖式手机");
    }
}
