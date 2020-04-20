package com.jack.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by manchong on 2019/12/24.
 */
public class CountDownLatchTest {

    public static void main(String[] args) {

        final CountDownLatch countDownLatch =new CountDownLatch(5);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i=0;i<5;i++) {

            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                    System.out.println("sdfsdfsdf");
                }
            });


        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("执行介绍");


    }

}
