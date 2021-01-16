package com.jary.progress.design.mode.proxy;

import org.junit.Test;

/**
 * @author fanzhengjie
 * @date 2020/5/20 9:26 下午
 */
public class ProxyTest {

    @Test
    public void testProxy() {
        Proxy proxy = new Proxy(new RealSubject());
        proxy.request();
    }

}
