package com.jary.progress.juc.futuretask;

import java.util.concurrent.FutureTask;

/**
 * @author fanzhengjie
 * @create 2018/9/16 下午7:44
 * @description
 */
public class FutureTaskDemo2 {

    /**
     * 1、如demo在主线程中开启单个线程执行任务，阻塞获取执行结果。
     * 2、如果有多个任务可以使用Future接口。
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            System.out.println("主线程开始。。。。");
            FutureTask<String> futureTask = new FutureTask<>(() -> {
                System.out.println("子线程开始。。。。");
                Thread.sleep(5000);
                return "子线程执行完毕返回。。。。";
            });
            Thread thread = new Thread(futureTask);
            thread.start();

            Thread.sleep(2000);//模拟主线程执行耗时操作
            System.out.println("主线程执行完毕。。。。");

            String futureStr = futureTask.get();
            System.out.println(futureStr);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
