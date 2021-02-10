package com.jary.progress.juc.future;

import java.text.MessageFormat;
import java.util.concurrent.*;

/**
 * @author fanzhengjie
 * @date 2020/5/17 7:48 下午
 */
public class FutureDemo2 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
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
            long end = System.currentTimeMillis();
            System.out.println(MessageFormat.format("耗时：{0}s", (end - start) / 1000.0));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
