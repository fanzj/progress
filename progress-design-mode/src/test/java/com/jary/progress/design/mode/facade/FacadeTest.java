package com.jary.progress.design.mode.facade;

import org.junit.Test;

/**
 * @author fanzhengjie
 * @date 2020/5/24 3:13 下午
 */
public class FacadeTest {

    @Test
    public void test() {
        Facade facade = new Facade();
        facade.methodA();

        facade.methodB();
    }
}
