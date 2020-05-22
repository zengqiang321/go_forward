package com.jack.concurrent.demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by manchong on 2020/4/23.
 */
public class LockSupportDemo {

    List<String> list = new ArrayList<>();
    static Thread t2,  t;
    public static void main(String[] args) {
        LockSupportDemo valatile = new LockSupportDemo();

        t= new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1");

               // if (valatile.list.size() != 5) {
                    LockSupport.park();
                //}
                System.out.println("t2结束");
                LockSupport.unpark(t2);
            }
        });
        t.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2=new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {
                    if (i == 5) {
                        LockSupport.unpark(t);
                        LockSupport.park();
                    }
                    valatile.list.add("" + i);
                    System.out.println(i);
                }
            }
        });
        t2.start();
    }

}
