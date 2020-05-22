package com.jack.concurrent;

import java.util.concurrent.SynchronousQueue;

/**
 * SynchronousQueue：
 *      A blocking queue，每个插入操作必须等待另一个线程相应的删除操作。
 *      同步队列没有任何内部容量，甚至没有一个容量
 *
 *      queue.offer非阻塞的，queue.put 是阻塞的，需要等待对应的take操作
 *      queue.take是阻塞的，等待offer 一个数据后才能进行。
 *
 *
 *      因为队列是0大小的，所以不能迭代，通过queue.poll(),peek操作也不能取出数据
 *
 *
 *
 *      应用场景：同步队列适用于切换设计，其中运行在一个线程中的对象必须与在另一个线程中运行的对象同步，以便交付一些信息，事件或任务
 *
 * Created by manchong on 2020/4/24.
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) {

        SynchronousQueue<String> queue = new SynchronousQueue<>();

        new Thread(()->{
            for (;;) {
                try {
                    String s = queue.take();
                    System.out.println(s);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            System.out.println("puts value"+1);
            try {
                queue.offer("str");
            } catch (Exception e) {
                e.printStackTrace();
            }
        System.out.println("puts value");
            queue.offer("st2");
            System.out.println(queue.size());
            System.out.println("puts value");
            queue.offer("st3");
        }).start();





    }

}
