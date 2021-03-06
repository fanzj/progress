package com.jary.progress.common.io.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author fanzhengjie
 * @create 2018/9/11 上午12:04
 * @description
 */
public class Student implements Serializable {

    private String stuno;
    private String stuname;
    private transient int stuage;//该元素不会进行jvm默认的序列化,也可以自己完成这个元素的序列化

    public Student() {
    }

    public Student(String stuno, String stuname, int stuage) {
        this.stuno = stuno;
        this.stuname = stuname;
        this.stuage = stuage;
    }

    public String getStuno() {
        return stuno;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public int getStuage() {
        return stuage;
    }

    public void setStuage(int stuage) {
        this.stuage = stuage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuno='" + stuno + '\'' +
                ", stuname='" + stuname + '\'' +
                ", stuage=" + stuage +
                '}';
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();//把jvm能默认序列化的元素进行序列化操作
        s.writeInt(stuage);//自己完成stuage的序列化
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();//把jvm能默认反序列化的元素进行反序列化操作
        this.stuage = s.readInt();//自己完成stuage的反序列化
    }
}
