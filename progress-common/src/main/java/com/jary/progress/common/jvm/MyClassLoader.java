package com.jary.progress.common.jvm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author fanzhengjie
 * @create 2020/1/4 下午3:40
 * @description 自定义一个类加载器从指定磁盘目录加载类
 */
public class MyClassLoader extends ClassLoader {

    //不破坏双亲委派模型
    /*@Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("name=" + name);
        String myPath =
            "/Users/fanzhengjie/IdeaProjects/daily/target/classes/com/daily/demo/jvm/" + name.replace(".", "/")
                + ".class";
        System.out.println(myPath);
        byte[] classBytes = null;

        File file = new File(myPath);
        try(FileInputStream in = new FileInputStream(file)) {
            classBytes = new byte[(int) file.length()];
            in.read(classBytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Class<?> clazz = defineClass(name, classBytes, 0, classBytes.length);
        return clazz;
    }*/

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        String myPath = "/Users/fanzhengjie/IdeaProjects/study/progress/progress-common/target/classes/" + name.replace(".", "/")
            + ".class";
        System.out.println(myPath);
        byte[] classBytes = null;
        FileInputStream in = null;

        try {
            File file = new File(myPath);
            in = new FileInputStream(file);
            classBytes = new byte[(int) file.length()];
            in.read(classBytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println();
        Class<?> clazz = defineClass(name, classBytes, 0, classBytes.length);
        return clazz;
    }
}
