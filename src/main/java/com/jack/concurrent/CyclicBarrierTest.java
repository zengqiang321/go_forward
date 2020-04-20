package com.jack.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by manchong on 2019/12/24.
 */
public class CyclicBarrierTest {

    //循环屏障

    public static void main(String[] args) {

        int parties=3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(parties, () -> System.out.println("我是命令1"));
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(parties);

       // for (int i=readme;i<=parties;i++) {
            Task task = new Task("TaskName" + 0,  1000,cyclicBarrier);
            Thread thread = new Thread(task);
            thread.start();
        //}

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        task = new Task("TaskName" + 1,  500,cyclicBarrier);
        thread = new Thread(task);
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        task = new Task("TaskName" + 2,  1500,cyclicBarrier);
        thread = new Thread(task);
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("线程循环结束");

//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }


    public static class Task implements Runnable {
        private String name;
        private long sleep;
        private CyclicBarrier cyclicBarrier;
        public Task(String name,long sleep,CyclicBarrier cyclicBarrier){
            this.name = name;
            this.sleep=sleep;
            this.cyclicBarrier =cyclicBarrier;
        }
        @Override
        public void run() {
            String taskMsg="Task name :" + name;
            System.out.println(taskMsg+" start");

            try {
                int wait=cyclicBarrier.await();
                System.out.println(taskMsg+ " sleep "+sleep+" locked "+Thread.currentThread().getName()+"===waitNum:"+wait);
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(taskMsg+" end");
        }
    }

}
