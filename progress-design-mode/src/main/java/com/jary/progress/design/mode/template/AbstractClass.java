package com.jary.progress.design.mode.template;

/**
 * @author fanzhengjie
 * @date 2020/5/22 8:12 下午
 */
public abstract class AbstractClass {

    public abstract void primitiveOperation1();

    public abstract void primitiveOperation2();

    public void templateMethod() {
        primitiveOperation1();
        primitiveOperation2();
        System.out.println("模版方法");
    }
}
