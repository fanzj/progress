package com.jary.progress.common.reflect;

/**
 * @author fanzhengjie
 * @date 2020/5/29 9:04 下午
 */
public class Person {

    public String name = "smt";

    private String idCard = "1001u09t";

    public Person() {
        System.out.println("Person类无参数构造");
    }

    public Person(int a, int b, String s) {
        System.out.println("Person类有参数构造：a:" + a + " b:" + b + " s:" + s);
    }

    private Person(int a) {
        System.out.println("Person类有参数私有构造：a:" + a);
    }


    public void show() {
        System.out.println("show 空参数");
    }

    public void show(int a) {
        System.out.println("show   a:" + a);
    }

    private void show(String s) {
        System.out.println("show   s:" + s);
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }
}
