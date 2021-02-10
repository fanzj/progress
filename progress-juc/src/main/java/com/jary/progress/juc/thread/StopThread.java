package com.jary.progress.juc.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author fanzhengjie
 * @create 2018/11/16 上午10:46
 * @description
 */
public class StopThread implements Runnable{

    @Override
    public void run() {
        while ( !Thread.currentThread().isInterrupted()) {
            // 线程执行具体逻辑
            System.out.println(Thread.currentThread().getName() + "运行中。。");
        }
        System.out.println(Thread.currentThread().getName() + "退出。。");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StopThread(), "thread A");
        thread.start();
        System.out.println("main 线程正在运行") ;
        TimeUnit.MILLISECONDS.sleep(10) ;
        thread.interrupt();
    }

}
