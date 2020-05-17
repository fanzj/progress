package com.jary.progress.juc.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author fanzhengjie
 * @date 2020/5/17 10:19 下午
 * 线程池执行流程测试
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5));

        for(int i = 0;i<20;i++){
            final int j = i;
            executor.execute(() -> {
                System.out.println("正在执行task" + j);
                try {
                    Thread.currentThread().sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("task " + j + "执行完毕");
            });

            System.out.println("线程池中线程数目: "+ executor.getPoolSize()+", 队列中等待执行的任务数目: " + executor.getQueue().size() + ", 已执行完别的任务数目: " + executor.getCompletedTaskCount());
        }

        executor.shutdown();
    }

}
