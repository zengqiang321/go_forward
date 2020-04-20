package com.jack.design.structural.birdge;

/**
 * Created by manchong on 2020/4/8.
 */
public class FullScreenPhone extends AbstractPhone {
    public FullScreenPhone(Brand brand) {
        super(brand);
    }

    @Override
    public void call() {
        super.call();
        System.out.println("   全屏式手机");
    }
}
