package com.jack.concurrent;

import java.util.concurrent.Exchanger;

/**
 *
 *  线程间的数据交换，通过同一个exchange  交互数据， 只有成对的线程exchange才会生效，不然需要等待数据到达
 *
 * Created by manchong on 2020/4/24.
 */
public class ExchangerDemo {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(()->{
            try {
                String t2=exchanger.exchange("t2----ddd");
                System.out.println(Thread.currentThread().getName()+"1111---"+t2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();



//        Exchanger<String> exchanger2 = new Exchanger<>();
//        new Thread(()->{
//            try {
//                String tMessage=exchanger2.exchange("t1---ccc");
//
//                System.out.println(Thread.currentThread().getName()+"----222---"+tMessage);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//
//        new Thread(()->{
//            try {
//                String tMessage=exchanger2.exchange("t3---ccc");
//
//                System.out.println(Thread.currentThread().getName()+"----333---"+tMessage);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();


        new Thread(()->{
            try {
                String tMessage=exchanger.exchange("t4---ccc");

                System.out.println(Thread.currentThread().getName()+"----444---"+tMessage);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
