package com.jary.progress.common.jvm;

/**
 * @author fanzhengjie
 * @create 2020/1/4 下午3:40
 * @description
 */
public class MyClassLoaderTest {

    static {
        System.out.println("static block init");
    }

    public static void main(String[] args) {
        Class<?> class0 = MyClassLoaderTest.class;
        System.out.println(class0.getClassLoader());
        try {
            System.out.println(class0.getClassLoader() instanceof MyClassLoader);
            Class<?> class1 = class0.getClassLoader().loadClass("com.jary.progress.common.jvm.MyClassLoaderTest");
            ClassLoader classLoader = new MyClassLoader();
            Class<?> class2 = classLoader.loadClass("com.jary.progress.common.jvm.MyClassLoaderTest");
            System.out.println(class1.hashCode());
            System.out.println(class2.hashCode());
            System.out.println(class1.equals(class2));
            System.out.println(classLoader.getParent());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
