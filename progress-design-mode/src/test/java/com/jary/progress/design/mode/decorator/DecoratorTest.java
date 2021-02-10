package com.jary.progress.design.mode.decorator;

import org.junit.Test;

/**
 * @author fanzhengjie
 * @date 2020/5/15 11:24 下午
 */
public class DecoratorTest {

    @Test
    public void testDecorator() {
        ConcreteComponent component = new ConcreteComponent();
        ConcreteDecoratorA decoratorA = new ConcreteDecoratorA();
        ConcreteDecoratorB decoratorB = new ConcreteDecoratorB();

        decoratorA.setComponent(component);
        decoratorB.setComponent(decoratorA);
        decoratorB.operation();
    }
}
