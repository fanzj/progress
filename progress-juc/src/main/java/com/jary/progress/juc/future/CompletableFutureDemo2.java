package com.jary.progress.juc.future;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author fanzhengjie
 * @date 2020/5/17 7:25 下午
 */
public class CompletableFutureDemo2 {

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(4, 4, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //仅仅为了测试异常类型
            int i = 10 / 0;
            return String.valueOf(new Random().nextInt(1000));
        }, executorService);

        try {
            String result = completableFuture.get(2000L, TimeUnit.MILLISECONDS);
            System.out.println("result = " + result);
        } catch (ArithmeticException e) {
            //异常类型被转换, 待研究
            System.out.println("it is ArithmeticException error");
        } catch (Exception e) {
            //异常正常获取方法
            Throwable throwable = e.getCause();
            if (throwable instanceof ArithmeticException) {
                System.out.println("it is ArithmeticException error ++");
                throwable.printStackTrace();
            }
        }

        // executorService.shutdown();
    }
}
