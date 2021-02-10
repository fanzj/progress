package com.jary.progress.juc.thread.notify.demo;

/**
 * @author fanzhengjie
 * @create 2019/10/28 上午12:09
 * @description
 */
public class RunTest {

    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA a = new ThreadA(lock);
        a.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ThreadB b = new ThreadB(lock);
        b.start();
    }

}
