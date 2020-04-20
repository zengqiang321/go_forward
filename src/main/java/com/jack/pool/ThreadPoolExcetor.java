package com.jack.pool;

import sun.misc.Unsafe;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Created by manchong on 2019/12/17.
 */
public class ThreadPoolExcetor {

    private int corePool;

    private BlockingQueue<Runnable> tasks =null;

    private Set<Worker> workerSet;

    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long stateOffset;

    private volatile int state;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset
                    (AbstractQueuedSynchronizer.class.getDeclaredField("state"));

        } catch (Exception ex) { throw new Error(ex); }
    }

    public boolean compareAndSetState(int exp,int update) {
        return unsafe.compareAndSwapInt(this,stateOffset,exp,update);
    }

    public ThreadPoolExcetor(int corePool) {

        this.corePool = corePool;

        this.tasks = new ArrayBlockingQueue<>(1000);

        this.workerSet = new HashSet<>(this.corePool);

    }


    public void execute(Runnable task) {
        if(workerSet.size()<corePool){
            addWorker(task);
        }else {
           boolean si= tasks.offer(task);
        }
    }

    private boolean addWorker(Runnable task) {
        if(workerSet.size()>corePool){
            return false;
        }

        Worker worker = new Worker(task);
        workerSet.add(worker);
        worker.run();
        return true;
    }

    private final class Worker implements Runnable {

        private Runnable firstTask;

        public Worker(Runnable firstTask) {
            this.firstTask = firstTask;
        }

        @Override
        public void run() {

            Runnable task = this.firstTask;
            this.firstTask=null;

            while (task!=null || (task=getTask())!=null) {
                task.run();
            }
        }
    }


    private Runnable getTask() {
        try {
            for (;;) {
                return tasks.take();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

}
