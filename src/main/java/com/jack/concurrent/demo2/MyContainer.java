package com.jack.concurrent.demo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 面试题：写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 * 容器最多存储10个元素，
 * Created by manchong on 2020/4/23.
 */
public class MyContainer {

    final static Queue<Integer> list = new ArrayBlockingQueue<>(100);

    final static int max = 10;

    final static Lock lock = new ReentrantLock();
    final static Condition producer = lock.newCondition();
    final static Condition consumer = lock.newCondition();
    private int count=0;

    public void put(int i) {
        try {
            lock.lock();
            while (max == list.size()) {
                    try {
                        System.out.println("生产者等待");
                        producer.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    consumer.signalAll();
            }
            count=count+1;
            list.add(i);

        }finally {
            lock.unlock();
        }
    }

    public void poll(){
        try{
            lock.lock();
            while (list.size()==0) {
                try {
                    consumer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                consumer.signalAll();
            }
            System.out.println(list.poll());

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MyContainer container = new MyContainer();
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                     for (int j=0;j<100;j++){
                         container.put(j);
                     }
                }
            }).start();
        }


        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                     for (int j=0;j<5;j++){
                         container.poll();
                     }
                }
            }).start();
        }



    }


}
