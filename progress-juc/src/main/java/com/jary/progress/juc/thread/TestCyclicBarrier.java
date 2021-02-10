package com.jary.progress.juc.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * @author fanzhengjie
 * @create 2018/11/16 上午10:23
 * @description 【CyclicBarrier 并发工具】
 *
 */
public class TestCyclicBarrier {

    public static void main(String[] args) throws Exception {
        cyclicBarrier();
    }

    private static void cyclicBarrier() throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3) ;
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread run");
                try {
                    cyclicBarrier.await() ;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread end do something");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread run");
                try {
                    cyclicBarrier.await() ;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread end do something");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread run");
                try {
                    Thread.sleep(5000);
                    cyclicBarrier.await() ;//调用 await() 将会在所有参与者线程都调用之前等待。
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread end do something");
            }
        }).start();

        System.out.println("main thread");
    }


}
