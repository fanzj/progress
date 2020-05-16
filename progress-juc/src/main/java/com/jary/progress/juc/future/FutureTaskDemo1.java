package com.jary.progress.juc.future;

import java.util.concurrent.FutureTask;

/**
 * @author fanzhengjie
 * @date 2020/5/16 11:41 下午
 */
public class FutureTaskDemo1 {

    public static void main(String[] args) throws Exception{
        System.out.println("主线程开始。。。");
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            System.out.println("子线程开始。。。");
            Thread.sleep(4000);
            return "子线程执行完毕返回";
        });

        new Thread(futureTask).start();

        Thread.sleep(2000L);//模拟主线程执行耗时操作
        System.out.println("主线程执行完毕。。。");

        String result = futureTask.get();
        System.out.println(result);
    }
}
