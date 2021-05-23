/**
 *
 */
package com.jary.progress.juc.futuretask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author lzb
 *
 */
public class TestFutureCallable {

    /**
     * @param args
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(() -> {
            System.out.println("开始执行子线程的call方法");
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "100";
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main主线程开始执行任务");
        try {
            System.out.println("执行完子线程后返回的结果是：" + future.get());
            long endTime = System.currentTimeMillis();
            System.out.format("耗时：%fms", (endTime - startTime) / 1000.0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

}
