package com.jary.progress.juc.futuretask;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author fanzhengjie
 * @create 2018/9/16 下午7:30
 * @description
 */
public class FutureDemo1 {

    /**
     * 最简单的并行计算，任务开始submit()，等待返回get()。
     * 一个Future表示一个异步计算结果。Future接口里提供多个方法，判断任务是否可取消，任务执行结果，等待执行结果等。
     * V get()：获取异步结果，如果没结果可用，会一直阻塞到计算完成返回。
     * V get(long timeout, TimeUnit unit)：有时间限制的阻塞，直到timeout时间结束还未计算完成，抛出异常。
     *
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<String>> futures = Lists.newArrayList();
        long t1 = System.currentTimeMillis();
        Future<String> future1 = executorService.submit(() -> {
            System.out.println("开始执行线程1call方法");
            Thread.sleep(3000L);//模拟线程1耗时操作
            return "线程1执行完毕";
        });
        futures.add(future1);

        Future<String> future2 = executorService.submit(() -> {
            System.out.println("开始执行线程2call方法");
            Thread.sleep(2000L);//模拟线程2耗时操作
            return "线程2执行完毕";
        });
        futures.add(future2);

        futures.forEach(stringFuture -> {
            try {
                String futureStr = stringFuture.get();
                System.out.println("线程执行结果" + futureStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        long t2 = System.currentTimeMillis();
        System.out.println("执行时间 = " + (t2 - t1) + "ms");
        executorService.shutdown();

    }

}
