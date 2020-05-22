package com.jack.concurrent.demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by manchong on 2020/4/23.
 */
public class CountDownLatchDemo {

    List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDownLatchDemo valatile = new CountDownLatchDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1");

                    //if (valatile.list.size() != 5) {
                        try {
                            countDownLatch.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    //}
                    System.out.println("t2结束");
                }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {

                    for (int i = 0; i < 10; i++) {
                        if(i==5){
                            countDownLatch.countDown();
                        }
                        valatile.list.add("" + i);
                        System.out.println(i);
                }
            }
        }).start();
    }

}
