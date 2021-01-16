package com.jary.progress.design.mode.factory.method;

import com.jary.progress.design.mode.factory.simple.Operation;
import org.junit.Test;

/**
 * @author fanzhengjie
 * @date 2020/5/20 9:51 下午
 */
public class FactoryMethodTest {

    @Test
    public void testAdd() {
        IFactory factory = new AddFactory();
        Operation operation = factory.createOperation();
        System.out.println(operation.getResult(1, 2));
    }

    @Test
    public void testSub() {
        IFactory factory = new SubFactory();
        Operation operation = factory.createOperation();
        System.out.println(operation.getResult(5, 7));
    }

}
