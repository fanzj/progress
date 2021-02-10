package com.jary.progress.juc.thread.daemo;

/**
 * @author fanzhengjie
 * @create 2019/10/23 下午10:58
 * @description
 */
public class DaemoTest {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(
            () -> {
                int i = 0;
            while (true) {
                i++;
                System.out.println("i=" + (i));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(5000);
        System.out.println("我离开thread对象也不再打印了，也就是停止了！");
    }

}
