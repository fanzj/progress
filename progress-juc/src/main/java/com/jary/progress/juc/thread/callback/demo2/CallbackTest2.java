package com.jary.progress.juc.thread.callback.demo2;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author fanzhengjie
 * @create 2019/4/20 下午12:08
 * @description
 */
public class CallbackTest2 {

    static ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void doSth(ICallback callback){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //模拟业务逻辑处理
                System.out.println("do sth...");

                //模拟耗时操作
                try {
                    TimeUnit.SECONDS.sleep(
                        5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //处理完业务逻辑
                Map<String, Object> params = Maps.newHashMap();
                params.put("a1", "这是我返回的参数字符串");
                callback.callback(params);
            }
        });
        executor.execute(t);
    }

    public static void main(String[] args) {
        doSth(new ICallback() {
            @Override
            public void callback(Map<String, Object> params) {
                System.out.println("单个线程已处理完毕了，返回参数a1=" + params.get("a1"));
            }
        });
        System.out.println("主线程任务已经执行完了");
    }

}
