package com.jack.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * https://github.com/alibaba/transmittable-thread-local
 * Created by manchong on 2020/5/29.
 */
public class T1 {

    public static ExecutorService exec = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws InterruptedException {
        T1 t=new T1();
        //使用ThreadLocal 不能传递到子线程
        /*T1ThreadLocalHolder.set("12312");
        T1ThreadLocalHolder.get();
        t.threadLocal();*/

        //子线程可以拿到父线程的隐式传参; 只能传递一层。它的子子线程不能够获取到
        /*T1IneritThreadLocalHolder.set("2123123");
        t.InheritableThreadLocal();*/


        //并行多级线程不能获取到其它线程的传参
        /*Thread tt=new Thread(()->{
            T1IneritThreadLocalHolder.set("2123123");
        });
        tt.start();
        tt.join();
        t.InheritableThreadLocal();*/

//        for (int i=0;i<10;i++) {
//            Integer var1 = (int)(Math.random()*100);
//            T1IneritThreadLocalHolder.set(var1.toString());
//            t.threadPoolInheritableThreadLocal(var1.toString());
//        }
//        Thread.sleep(1000);

        for (int i=0;i<10;i++) {
            Integer var1 = (int)(Math.random()*100);
            TransmitTableThreadLocalHolder.set(var1.toString());
//            t.threadPoolTransmittableThreadLocal(var1.toString());
            t.subThreadPoolTransmittableThreadLocal(var1.toString());
        }
        Thread.sleep(1000);
    }


    public void threadLocal() throws InterruptedException  {
        Thread thread =new Thread(()->{
            T1ThreadLocalHolder.get();
        });
        thread.start();
        thread.join();
    }

    public void InheritableThreadLocal() throws InterruptedException {
        Thread thread =new Thread(()->{
            T1IneritThreadLocalHolder.get();

            //sub thread
            Thread subThread=new Thread(()->{
                T1ThreadLocalHolder.get();
            });
            subThread.start();
            try {
                subThread.join();
            }catch (InterruptedException e){}
        });
        thread.start();
        thread.join();
    }

    public void threadPoolInheritableThreadLocal(String var1)throws InterruptedException {
            exec.execute(() -> {
                String val=T1IneritThreadLocalHolder.get();
                System.out.println(val.equalsIgnoreCase(var1)+"==="+var1+"----"+val);
            });
    }

    public void threadPoolTransmittableThreadLocal(String var1)throws InterruptedException {
            exec.execute(TtlRunnable.get(() -> {
                String val=TransmitTableThreadLocalHolder.get();
                System.out.println(val.equalsIgnoreCase(var1)+"==="+var1+"----"+val);
            }));
    }

    public void subThreadPoolTransmittableThreadLocal(String var1)throws InterruptedException {
        exec.execute(TtlRunnable.get(() -> {
            new Thread(TtlRunnable.get(()->{
                doRun(var1);
            })).start();
        }));
    }

    public void doRun(String var1){
        String val=TransmitTableThreadLocalHolder.get();
        System.out.println(val.equalsIgnoreCase(var1)+"==="+var1+"----"+val);
    }

}


class TransmitTableThreadLocalHolder {
    private static ThreadLocal<String> threadLocal = new TransmittableThreadLocal<>();

    public static void set(String value) {
        threadLocal.set(value);
    }

    public static String get(){
        String value=  threadLocal.get();
        System.out.println("currentThread:"+Thread.currentThread().getName()+"===getValue="+value);
        return value;
    }

    public static void remove(){
        threadLocal.remove();
    }
}

class T1IneritThreadLocalHolder {
    private static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void set(String value) {
        threadLocal.set(value);
    }

    public static String get(){
        String value=  threadLocal.get();
        System.out.println("currentThread:"+Thread.currentThread().getName()+"===getValue="+value);
        return value;
    }

    public static void remove(){
        threadLocal.remove();
    }
}

class T1ThreadLocalHolder {

    private static ThreadLocal<String> threadLocal = new ThreadLocal();

    public static void set(String value) {
        threadLocal.set(value);
    }

    public static String get(){
        String value=  threadLocal.get();
        System.out.println("currentThread:"+Thread.currentThread().getName()+"===getValue="+value);
        return value;
    }

    public static void remove(){
        threadLocal.remove();
    }

}
