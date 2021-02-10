package com.jary.progress.juc.thread.notify.demo;

/**
 * @author fanzhengjie
 * @create 2019/10/28 上午12:02
 * @description
 */
public class ThreadA extends Thread {

    private Object lock;

    public ThreadA(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                if (MyList.size() != 5) {
                    System.out.println("wait begin " + System.currentTimeMillis());
                }
                lock.wait();
                System.out.println("wait end " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
