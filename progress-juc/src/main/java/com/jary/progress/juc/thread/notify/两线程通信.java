package com.jary.progress.juc.thread.notify;

/**
 * @author fanzhengjie
 * @create 2019/3/23 下午9:40
 * @description 两个线程交替执行，通过Object对象的wait()和notify()方法实现
 */
public class 两线程通信 {

    static class Printer {
        int flag = 1;

        public void print1() throws InterruptedException {
            synchronized (this){
                if(flag != 1){
                    this.wait();
                }
                System.out.println(Thread.currentThread().getName()+"aaaaaa");
                flag = 2;
                this.notify();
            }
        }

        public void print2() throws InterruptedException {
            synchronized (this){
                if(flag != 2){
                    this.wait();
                }
                System.out.println(Thread.currentThread().getName()+"bbbbbb");
                flag = 1;
                this.notify();
            }
        }
    }

    public static void main(String[] args) {
        final Printer printer = new Printer();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++){
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
                for(int i=0;i<5;i++){
                    try {
                        printer.print2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
