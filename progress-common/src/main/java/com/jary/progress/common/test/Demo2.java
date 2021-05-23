package com.jary.progress.common.test;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo2 {

    public static void main(String[] args) throws InterruptedException {
//        while(true) {
//            Thread.sleep(1000);
//            System.out.println(123);
//        }

        ExecutorService executor = new ThreadPoolExecutor(1,1,1000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        executor.submit(() -> System.out.println("hello"));
        executor.execute(null);

        executor.shutdown();
        executor.shutdownNow();


    }
}
