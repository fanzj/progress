package com.jary.progress.juc.lock2condition;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fanzhengjie
 * @create 2019/1/16 上午11:13
 * @description http://blog.sina.com.cn/s/blog_636cc1f30101r758.html
 */
public class Demo1 {

    public static void main(String[] args) {
        A a = new A();
        new Thread(a).start();
        new Thread(a).start();
    }

    static class A implements Runnable {

        private Lock lock = new ReentrantLock();

        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "正在运行");
            } finally {
                lock.unlock();
            }
        }
    }


}
