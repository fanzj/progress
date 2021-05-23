/**
 *
 */
package com.jary.progress.juc.futuretask;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author linzhibing
 *
 */
public class TestCompletableFuture {


    private static final Random rand = new Random();

    /**
     * @param args
     */
    public static void main(String[] args) {
        final int randRange = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(2000l);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //仅仅为了测试异常类型
            int i = 10 / 0;
            return String.valueOf(rand.nextInt(randRange));
        }, executorService);

        try {
            String result = completableFuture.get(2100l, TimeUnit.MILLISECONDS);
            System.out.println("result=" + result);
        } catch (ArithmeticException e) {
            //异常类型被转换了，待研究
            //System.out.println("it is ArithmeticException error");
        } catch (Exception e) {
            //e.printStackTrace();
            //异常正常获取方法
            Throwable throwable = e.getCause();
            if (throwable instanceof ArithmeticException) {
                System.out.println("it is ArithmeticException error");
                throwable.printStackTrace();
            }
        }

    }

}
