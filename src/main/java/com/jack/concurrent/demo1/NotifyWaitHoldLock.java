package com.jack.concurrent.demo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by manchong on 2020/4/23.
 */
public class NotifyWaitHoldLock {

    List<String> list =new ArrayList<>();


    public static void main(String[] args) {
        NotifyWaitHoldLock valatile = new NotifyWaitHoldLock();
        Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1");
                 synchronized (lock) {

                     if (valatile.list.size() != 5) {
                         try {
                             lock.wait();
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                     }
                     System.out.println("t2结束");
                 }
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
                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        if(i==5){
                            lock.notify();
                        }
                        valatile.list.add("" + i);
                        System.out.println(i);
                    }
                }
            }
        }).start();
    }

}
