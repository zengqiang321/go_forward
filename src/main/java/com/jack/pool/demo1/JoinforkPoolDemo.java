package com.jack.pool.demo1;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by manchong on 2020/readme/7.
 */
public class JoinforkPoolDemo {


    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool(5);
        Task task = new Task(0, 100000);
        Integer result = pool.invoke(task);
        task.isCompletedAbnormally();
        System.out.println(result+"==="+(System.currentTimeMillis()-start));
    }


    public static class Task extends RecursiveTask<Integer> {

        private int from;
        private int to;

        public Task(int from,int to) {
            this.from =from;
            this.to=to;
        }

        @Override
        protected Integer compute() {
            if (to - from < 500){
                int sum = 0 ;
                for (int i = from; i <= to; i++)
                    sum += i;
                return sum;
            } else{
                int middle = (from + to) / 2;
                Task countAdd1 = new Task(from, middle);
                Task countAdd2 = new Task(middle+1, to);
                countAdd1.fork();
                countAdd2.fork();
                return countAdd1.join() + countAdd2.join();
            }
        }


    }

}
