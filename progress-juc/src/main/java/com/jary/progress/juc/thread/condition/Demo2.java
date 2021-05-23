package com.jary.progress.juc.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fanzhengjie
 * @create 2019/1/16 上午11:18
 * @description http://blog.sina.com.cn/s/blog_636cc1f30101r758.html
 */
public class Demo2 {

    static class Info{
        private static Lock lock = new ReentrantLock();
        private static Condition c1 = lock.newCondition();//将c1这把小锁绑定到lock上
        private static Condition c2 = lock.newCondition();

        public static void Run1(){
            lock.lock();
            try {
                for(int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+"正在运行");
                    c2.signal(); //唤醒
                    try {
                        c1.await(); //暂停 执行await需要捕获异常
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }finally {
                lock.unlock();
            }
        }

        public static void Run2(){
            lock.lock();
            try {
                for(int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+"正在运行");
                    c1.signal(); //唤醒
                    try {
                        c2.await(); //暂停 执行await需要捕获异常
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }finally {
                lock.unlock();
            }
        }
    }

    static class A implements Runnable{

        @Override
        public void run() {
            Info.Run1();
        }
    }

    static class B implements Runnable{

        @Override
        public void run() {
            Info.Run2();
        }
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        new Thread(a).start();
        new Thread(b).start();
    }

}
