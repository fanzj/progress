package com.jary.progress.design.mode.facade;

/**
 * @author fanzhengjie
 * @date 2020/5/24 3:09 下午
 */
public class Facade {

    private SubSystemOne one;
    private SubSystemTwo two;
    private SubSystemThree three;
    private SubSystemFour four;

    public Facade() {
        one = new SubSystemOne();
        two = new SubSystemTwo();
        three = new SubSystemThree();
        four = new SubSystemFour();
    }

    public void methodA() {
        System.out.println("方法组A");
        one.methodOne();
        two.methodTwo();
        four.methodFour();
    }

    public void methodB() {
        System.out.println("方法组B");
        two.methodTwo();
        three.methodThree();
    }
}
