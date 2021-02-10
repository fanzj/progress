package com.jary.progress.juc.thread.visibility;

/**
 * @author fanzhengjie
 * @create 2019/2/1 下午2:43
 * @description 内存可见行demo
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {

        @Override
        public void run() {
            while(!ready){
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }

}
