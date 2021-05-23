/**
 *
 */
package com.jary.progress.juc.futuretask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author lzb
 *
 */
public class TestFutureTaskCallable {

    /**
     * @param args
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("main主线程开始执行");
        FutureTask<String> futureTask = new FutureTask<String>(() -> {
            System.out.println("在callable子线程中开始执行call方法");
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "这很棒，不是吗？";
        });

        //采用线程池执行
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(futureTask);

        /** 采用线程执行
         Thread thread = new Thread(futureTask);
         thread.start();
         **/

        try {
            System.out.println("模拟执行主线程耗时操作开始");
            Thread.sleep(5000);
            System.out.println("模拟执行主线程耗时操作结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("子线程执行完后的执行结果为：" + futureTask.get());
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
