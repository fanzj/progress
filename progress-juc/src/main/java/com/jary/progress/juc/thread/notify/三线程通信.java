package com.jary.progress.juc.thread.notify;

/**
 * @author fanzhengjie
 * @create 2019/3/24 下午9:50
 * @description 三个线程交替执行
 */
public class 三线程通信 {

    static class Printer {

        int flag = 1;

        public void print1() throws InterruptedException {
            synchronized (this){
                while(flag != 1){
                    this.wait();
                }

                System.out.println(Thread.currentThread().getName()+"-11111");
                flag = 2;
                this.notifyAll();
            }
        }

        public void print2() throws InterruptedException {
            synchronized (this){
                while (flag != 2){
                    this.wait();
                }
                System.out.println(Thread.currentThread().getName()+"-22222");
                flag = 3;
                this.notifyAll();
            }
        }

        public void print3() throws InterruptedException {
            synchronized (this){
                while (flag != 3){
                    this.wait();
                }
                System.out.println(Thread.currentThread().getName()+"-33333");
                flag = 1;
                this.notifyAll();
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
