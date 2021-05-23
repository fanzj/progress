package com.jary.progress.juc.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author fanzhengjie
 * @create 2018/11/16 上午10:10
 * @description 【CountDownLatch 并发工具】
 * CountDownLatch 可以实现 join 相同的功能，但是更加的灵活。
 */
public class TestCountDownLatch {

    public static void main(String[] args) throws InterruptedException {
        countDownLatch();
    }

    public static void countDownLatch() throws InterruptedException {
        int thread = 3;
        long start = System.currentTimeMillis();
        final CountDownLatch countDownLatch = new CountDownLatch(thread);
        for (int i = 0; i < thread; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("thread run");
                    try {
                        Thread.sleep(2000);
                        countDownLatch.countDown();///该方法会将 AQS 内置的一个 state 状态 -1 。
                        System.out.println("thread end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        countDownLatch.await();//最终在主线程调用 await() 方法，它会阻塞直到 state == 0 的时候返回。
        long stop = System.currentTimeMillis();
        System.out.println("main over total time=" + (stop - start));
    }


}
