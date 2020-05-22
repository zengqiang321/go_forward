package com.jack.concurrent.demo1;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Phaser 按不同阶段来对线程执行，
 * 允许不同线程走到不同的阶段。 在整个过程，只有一个线程最后走完全场
 * 案例：
 * 结婚现场： 第一阶段： 嘉宾入场，新人入场 婚礼仪式；
 * 第2阶段：吃，新人敬酒；
 * 第3阶段：嘉宾离开，新人送别
 * 第4阶段：新人洞房
 * Created by manchong on 2020/5/21.
 */
public class PhaserTest {

    public static Random r = new Random();

    public static MarriagePhaser phaser = new MarriagePhaser();

    public static void millSleep(int s) {
        try {
            TimeUnit.MILLISECONDS.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        phaser.bulkRegister(7);//注册N个线程；
        for(int i=0;i<5;i++) {
            new Thread(new Person("贵宾"+i)).start();
        }
        new Thread(new Person("新郎")).start();
        new Thread(new Person("新娘")).start();

    }

    public static class MarriagePhaser extends Phaser{

        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    System.out.println("所有人都到齐了，"+registeredParties);
                    return false;
                case 1:
                    System.out.println("所有人都开吃，新人敬酒，"+registeredParties);
                    return false;
                case 2:
                    System.out.println("所有人都离开，送别"+registeredParties);
                    return false;
                case 3:
                    System.out.println("新人洞房"+registeredParties);
                    return true;
                default: return true;
            }
        }
    }

    public static class Person implements Runnable{
        String name;
        public Person(String name) {
            this.name=name;
        }

        public void arrive() {
            millSleep(r.nextInt(1000));
            System.out.printf("%s 到达现场!\n",name);
            phaser.arriveAndAwaitAdvance();
        }

        public void eat() {
            millSleep(r.nextInt(1000));
            System.out.printf("%s 吃完了!\n",name);
            phaser.arriveAndAwaitAdvance();
        }

        public void leave() {
            millSleep(r.nextInt(1000));
            System.out.printf("%s 离开了!\n",name);
            phaser.arriveAndAwaitAdvance();
        }

        public void hug() {
            if(name.equalsIgnoreCase("新郎")||name.equals("新娘")) {
                millSleep(r.nextInt(1000));
                System.out.printf("%s 洞房    !\n", name);
                phaser.arriveAndAwaitAdvance();
            }else {
                phaser.arriveAndDeregister();
            }
        }

        @Override
        public void run() {
            arrive();
            eat();
            leave();
            hug();
        }
    }
}
