package com.jary.progress.juc.future;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author fanzhengjie
 * @date 2020/5/17 6:58 下午
 */
public class CompletableFutureDemo1 {

    public static void main(String[] args) {
        Map<String, String> returnMap = new HashMap<>();
        ExecutorService executorService = new ThreadPoolExecutor(4, 4, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        CompletableFuture completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("task1 doing...");
            try {
                Thread.sleep(5000);
                System.out.println("task1 done...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Map<String, String> map = new HashMap<>();
            returnMap.put("xtd", "xtd");
            return map;
        }, executorService);

        CompletableFuture completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("task2 doing...");
            try {
                Thread.sleep(2000);
                System.out.println("task2 done...");
            } catch (InterruptedException e) {
                System.out.println("args = [" + e + "]");
                e.printStackTrace();
            }

            Map<String, String> map = new HashMap<>();
            returnMap.put("gjb", "gjb");
            return returnMap;
        }, executorService);

        CompletableFuture[] completableFutures = new CompletableFuture[]{completableFuture1, completableFuture2};
        CompletableFuture allResult = CompletableFuture.allOf(completableFutures);
        allResult.join();//allOf全部任务结束; anyOf最快的一个
        for(Map.Entry<String, String> entry : returnMap.entrySet()) {
            System.out.println("args = [" + entry + "]");
        }
        executorService.shutdown();

    }
}
