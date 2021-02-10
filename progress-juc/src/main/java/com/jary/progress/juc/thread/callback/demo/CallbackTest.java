package com.jary.progress.juc.thread.callback.demo;

/**
 * @author fanzhengjie
 * @create 2019/4/20 上午11:59
 * @description
 */
public class CallbackTest {

    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client(server);
        client.sendMsg("hello");
    }

}
