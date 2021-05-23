package com.jary.progress.juc.thread.notify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fanzhengjie
 * @create 2019/3/24 下午10:24
 * @description 可指定唤醒对象
 */
public class 三线程通信2 {

    static class Printer{
        private ReentrantLock lock = new ReentrantLock();
        private Condition c1 = lock.newCondition();
        private Condition c2 = lock.newCondition();
        private Condition c3 = lock.newCondition();

        int flag = 1;

        public void print1() throws InterruptedException {
            lock.lock();
            try{
                if(flag != 1){
                    c1.await();
                }

                System.out.println(Thread.currentThread().getName()+": 111");
                flag = 2;
                c2.signal();
            }finally {
                lock.unlock();
            }
        }

        public void print2() throws InterruptedException {
            lock.lock();
            try{
                if(flag != 2){
                    c2.await();
                }
                System.out.println(Thread.currentThread().getName()+": 222");
                flag = 3;
                c3.signal();
            } finally {
                lock.unlock();
            }
        }

        public void print3() throws InterruptedException {
            lock.lock();
            try{
                if(flag != 3){
                    c3.await();
                }
                System.out.println(Thread.currentThread().getName()+": 333");
                flag = 1;
                c1.signal();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final Printer printer = new Printer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int j=0;j<5;j++){
                    try {
                        printer.print1();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int j=0;j<5;j++){
                    try {
                        printer.print2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int j=0;j<5;j++){
                    try {
                        printer.print3();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
