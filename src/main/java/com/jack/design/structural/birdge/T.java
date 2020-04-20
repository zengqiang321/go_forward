package com.jack.design.structural.birdge;

/**
 * Created by manchong on 2020/4/8.
 */
public class T {


    public static void main(String[] args) {

        Phone phone = new FullScreenPhone(new XiaoMiBrand());
        phone.call();
        System.out.println("==============");

        Phone phone1 = new FlipPhone(new VivoBrand());
        phone1.call();
        System.out.println("==============");

    }

}
