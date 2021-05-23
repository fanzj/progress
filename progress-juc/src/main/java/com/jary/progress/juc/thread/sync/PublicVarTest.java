package com.jary.progress.juc.thread.sync;

/**
 * @author fanzhengjie
 * @create 2019/10/24 上午12:02
 * @description
 */
public class PublicVarTest {

    static class ThreadA extends Thread {
        private PublicVar publicVar;

        public ThreadA(PublicVar publicVar) {
            super();
            this.publicVar = publicVar;
        }

        @Override
        public void run() {
            super.run();
            publicVar.setValue("B", "BB");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PublicVar publicVar = new PublicVar();
        ThreadA threadA = new ThreadA(publicVar);
        threadA.start();

        Thread.sleep(200);
        publicVar.getValue();

    }

}
