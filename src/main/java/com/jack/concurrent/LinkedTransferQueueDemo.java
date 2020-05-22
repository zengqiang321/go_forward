package com.jack.concurrent;

import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by manchong on 2020/4/24.
 */
public class LinkedTransferQueueDemo {

    public static void main(String[] args) {
        LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();

//        queue.add("1111");

        new Thread(()->{
            try {
                for(int i=0;i<100;i++) {
                    String s="dddd"+i;
                    queue.transfer(s);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                for(int i=0;i<100;i++) {
                    String s = queue.take();
                    System.out.println("ttt1====="+s);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                for(int i=0;i<100;i++) {
                    String s = queue.take();
                    System.out.println("ttt2==="+s);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
//        System.out.println(queue.poll());




    }

}
