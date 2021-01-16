package com.jary.progress.juc.sync;

import com.jary.progress.juc.executor.AsyncExecutor;

/**
 * @author fanzhengjie
 * @date 2020/5/17 8:13 下午
 */
public class SynchronizedTest {

    private synchronized void service1() {
        System.out.println("service1");
        service2();
    }

    private synchronized void service2() {
        System.out.println("service2");
        service3();
    }

    private synchronized void service3() {
        System.out.println("service3");
    }

    public static void main(String[] args) {
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        AsyncExecutor.getExecutorService().execute(() -> synchronizedTest.service1());
    }
}
