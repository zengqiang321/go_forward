package com.jack.printobjectheader;

import org.openjdk.jol.info.ClassLayout;

/**
 * Created by manchong on 2020/4/3.
 */
public class T {

    public static void main(String[] args) {
//        Object[] object = new Object[3];
//        System.out.println(ClassLayout.parseInstance(object).toPrintable());
//
        System.out.println(ClassLayout.parseClass(User.class).toPrintable());
        System.out.println("=======");

        User use = new User();
        System.out.println(ClassLayout.parseInstance(use).toPrintable());
        System.out.println("=======");


        User[] user = new User[1];
        System.out.println(ClassLayout.parseInstance(user).toPrintable());
    }


}
