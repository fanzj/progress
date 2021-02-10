package com.jary.progress.juc.thread.callback.demo;

/**
 * @author fanzhengjie
 * @create 2019/4/20 上午11:53
 * @description 模拟客户端发送消息
 */
public class Client {

    private Server server;

    public Client(Server server) {
        this.server = server;
    }

    public void sendMsg(String msg){
        System.out.println("客户端正在发送消息：" + msg);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //调用server类的获取消息方法，并且传入callback对象
                    server.getMsg(new Callback() {//实现Callback接口
                        @Override
                        public void process(int status) {
                            System.out.println("处理成功，返回状态：" + status);
                        }
                    }, msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
