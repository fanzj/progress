package com.jary.progress.juc.thread.executor;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author fanzhengjie
 * @create 2020/1/15 上午10:45
 * @description
 */
public class SingleThreadExecutorTest {

    public static void main(String[] args) {
        /*ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());*/
        ThreadPoolExecutor executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
            60L, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>());

        for(int i=0;i<100;i++) {
            int finalI = i;
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName());
                System.out.println("i=" + finalI);
                try {
                    Thread.sleep(1000);
                    System.out.println("线程池中线程数目: "+ executor.getPoolSize()+", 队列中等待执行的任务数目: " + executor.getQueue().size() + ", 已执行完别的任务数目: " + executor.getCompletedTaskCount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            //System.out.println("线程池中线程数目: "+ executor.getPoolSize()+", 队列中等待执行的任务数目: " + executor.getQueue().size() + ", 已执行完别的任务数目: " + executor.getCompletedTaskCount());
        }




    }

}
