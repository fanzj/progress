package com.jary.progress.juc.future;

import com.google.common.collect.Lists;

import java.text.MessageFormat;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author fanzhengjie
 * @date 2020/4/24 9:38 上午
 * 异步计算1
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
        ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(10));
        List<Future<String>> futureList = Lists.newArrayList();
        long start = System.currentTimeMillis();
        Future<String> future1 = executorService.submit(() -> {
            System.out.println("开始执行线程1方法");
            Thread.sleep(4000L);//模拟线程1耗时操作
            System.out.println(MessageFormat.format("线程1执行时间：{0}ms", System.currentTimeMillis() - start));
            return "线程1执行完毕";
        });
        futureList.add(future1);

        Future<String> future2 = executorService.submit(() -> {
            System.out.println("开始执行线程2方法");
            Thread.sleep(6000L);//模拟线程2耗时操作
            System.out.println(MessageFormat.format("线程2执行时间：{0}ms", System.currentTimeMillis() - start));
            return "线程2执行完毕";
        });
        futureList.add(future2);

     /*   try {
            Thread.sleep(2000L);
            System.out.println(MessageFormat.format("休息2ms, 当前已经过：{0}ms", System.currentTimeMillis() - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //执行foreach之前已经任务在执行, 线程1、2同时执行中，线程1执行4s，get完，线程2再执行2s即可
        futureList.forEach(f -> {
            try {
                String result = f.get();
                System.out.println("线程执行结果：" + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        long end = System.currentTimeMillis();
        System.out.println(MessageFormat.format("所有任务执行时间: {0}ms", (end - start)));
        executorService.shutdown();
    }

}
