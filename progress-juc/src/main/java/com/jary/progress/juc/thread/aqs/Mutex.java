package com.jary.progress.juc.thread.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author fanzhengjie
 * @create 2019/12/26 下午3:21
 * @description AQS的简单应用
 * Mutex：不可重入互斥锁，锁资源（state）只有两种状态：0：未被锁定；1：锁定
 */
public class Mutex implements Lock{

    /**
     * 自定义同步器
     */
    private static class Sync extends AbstractQueuedSynchronizer {

        /**
         * 尝试获取资源,立即返回. 成功返回true,否则false
         * @param arg
         * @return
         */
        @Override
        protected boolean tryAcquire(int arg) {
            assert arg == 1;//限定只能为1个量
            if(compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());//设置为当前线程独占资源
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            assert arg == 1;
            if(getState() == 0){
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        /**
         * 判断是否锁定状态
         * @return
         */
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
    }

    private final Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }


    @Override
    public void lockInterruptibly() throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }


    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void unlock() {
        sync.release(1);
    }


    @Override
    public Condition newCondition() {
        throw new UnsupportedOperationException();
    }
}
