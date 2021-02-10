package com.jary.progress.io.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author fanzhengjie
 * @create 2018/9/11 上午12:05
 * @description
 */
public class ObjectSeriaDemo1 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String file = "/Users/fanzhengjie/Downloads/filetest/obj.dat";
        //1.对象的序列化
       /* ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        Student stu = new Student("10001", "张三", 20);
        oos.writeObject(stu);
        oos.flush();
        oos.close();*/
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Student student = (Student) ois.readObject();
        System.out.println(student);
        ois.close();
    }

}
