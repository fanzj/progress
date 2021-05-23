package com.jary.progress.juc.thread.callback.demo;

import java.util.concurrent.TimeUnit;

/**
 * @author fanzhengjie
 * @create 2019/4/20 上午11:41
 * @description 模拟服务端消息处理
 */
public class Server {

    public void getMsg(Callback callback, String msg) throws InterruptedException {
        System.out.println("服务端获得消息：" + msg);
        //模拟消息处理过程，等待5秒
        TimeUnit.SECONDS.sleep(5);
        System.out.println("服务端处理成功，返回状态为200");
        //处理完消息，调用回调方法，告知客户端
        callback.process(200);
    }



}
