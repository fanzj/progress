package com.jary.progress.juc.futuretask;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fanzhengjie
 * @create 2018/9/16 下午8:03
 * @description
 */
public class CompletableFutureDemo4 {

    /**
     * 1、jdk1.8新加入，类中的方法支持函数式编程中流式处理。
     * 2、supplyAsync()方法，和ExecutorService.submit()很像，不同的是返回CompletableFuture而不是Future。
     * 3、不定义线程池默认使用ForkJoinPool.commonPool()系统公共线程池，线程池由所有CompletableFuture共享。
     *
     * @param args
     */
    public static void main(String[] args) {
        Map<String, String> returnMap = new HashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture completableFuture1 = CompletableFuture.supplyAsync(() -> {
            //模拟执行耗时任务
            System.out.println("task1 doing...");
            try {
                Thread.sleep(5000);
                System.out.println("task1 done...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //返回结果
            Map<String, String> map = new HashMap<>();
            returnMap.put("xtd", "xtd");
            return map;
        }, executorService);

        CompletableFuture completableFuture2 = CompletableFuture.supplyAsync(() -> {
            //模拟执行耗时任务
            System.out.println("task2 doing...");
            try {
                Thread.sleep(2000);
                System.out.println("task2 done...");
            } catch (ArithmeticException e) {
                System.out.println("args = [" + e + "]");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //返回结果
            Map<String, String> map = new HashMap<>();
            returnMap.put("gjb", "gjb");
            return map;
        }, executorService);

        CompletableFuture[] completableFutures = {completableFuture1, completableFuture2};
        CompletableFuture allResult = CompletableFuture.allOf(completableFutures);
        allResult.join();//allOf全部任务结束；anyOf最快的一个结束
        for (Map.Entry<String, String> entry : returnMap.entrySet()) {
            System.out.println("args = [" + entry + "]");
        }
        executorService.shutdown();
    }
}
