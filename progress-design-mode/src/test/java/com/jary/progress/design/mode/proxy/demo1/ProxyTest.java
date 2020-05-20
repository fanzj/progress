package com.jary.progress.design.mode.proxy.demo1;

import org.junit.Test;

/**
 * @author fanzhengjie
 * @date 2020/5/20 9:43 下午
 */
public class ProxyTest {

    @Test
    public void testProxy(){
        Proxy proxy = new Proxy(new Pursuit(new SchoolGirl("小美")));
        proxy.giveChocolate();
        proxy.giveDolls();
        proxy.giveFlowers();
    }
}
