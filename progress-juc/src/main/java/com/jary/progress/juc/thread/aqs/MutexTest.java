package com.jary.progress.juc.thread.aqs;

/**
 * @author fanzhengjie
 * @create 2019/12/26 下午3:54
 * @description
 */
public class MutexTest {

    public static void main(String[] args) throws InterruptedException {
        Mutex mutex = new Mutex();

        for(int i=0;i<5;i++) {
            Thread thread = new SubThread(mutex);

            thread.start();

        }

        Thread.sleep(10000);
        System.out.println("num="+num);
    }

    private static int num = 0;

    private static class SubThread extends Thread {

        private Mutex mutex;

        public SubThread(Mutex mutex) {
            this.mutex = mutex;
        }

        @Override
        public void run() {
            for(int i=0;i<100_0000;i++){
                mutex.lock();
                try{
                    num ++;
                }finally {
                    mutex.unlock();
                }

            }
        }
    }

}
