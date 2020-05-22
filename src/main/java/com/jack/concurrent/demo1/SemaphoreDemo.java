package com.jack.concurrent.demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * Created by manchong on 2020/4/23.
 */
public class SemaphoreDemo {

    List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1,true);

        SemaphoreDemo valatile = new SemaphoreDemo();
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1");
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2结束");
                semaphore.release();
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
                        semaphore.release();
                        try {
                            semaphore.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    valatile.list.add("" + i);
                    System.out.println(i);
                }
                semaphore.release();
            }
        }).start();
    }


}
