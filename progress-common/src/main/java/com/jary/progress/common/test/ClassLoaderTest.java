package com.jary.progress.common.test;

/**
 * @author fanzhengjie
 * @date 2021/2/10 1:44 下午
 */
public class ClassLoaderTest {


    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
        Class.forName(ClassLoaderTest.class.getName());

        ClassLoader.getSystemClassLoader().loadClass(ClassLoaderTest.class.getName());
    }
}
