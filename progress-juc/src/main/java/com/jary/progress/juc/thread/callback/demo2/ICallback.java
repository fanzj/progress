package com.jary.progress.juc.thread.callback.demo2;

import java.util.Map;

/**
 * @author fanzhengjie
 * @create 2019/4/20 下午12:04
 * @description 回调一般是异步处理的一种技术
 */
public interface ICallback {

    void callback(Map<String, Object> params);

}
