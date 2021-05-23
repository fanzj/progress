package com.jary.progress.common.bean;

/**
 * @author fanzhengjie
 * @create 2019/1/14 下午9:17
 * @description
 */
public class Student {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
