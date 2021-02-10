package com.jary.progress.design.mode.template;

import org.junit.Test;

/**
 * @author fanzhengjie
 * @date 2020/5/22 8:16 下午
 */
public class TemplateTest {

    @Test
    public void test() {
        AbstractClass c = new ConcreteClassA();
        c.templateMethod();

        AbstractClass c2 = new ConcreteClassB();
        c2.templateMethod();
    }
}
