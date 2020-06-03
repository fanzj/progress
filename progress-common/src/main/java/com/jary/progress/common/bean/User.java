package com.jary.progress.common.bean;

import com.jary.progress.common.annonation.demo1.Init;
import com.jary.progress.common.annonation.demo2.Validate;

/**
 * @author fanzhengjie
 * @create 2019/1/12 上午10:46
 * @description 在数据模型使用注解
 */
public class User {

    @Validate(isNotNull = false)
    private String name;

    @Validate(min = 2, max = 5)
    private String age;

    public String getName() {
        return name;
    }

    @Init(value = "liang")
    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    @Init(value = "23")
    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
            "name='" + name + '\'' +
            ", age='" + age + '\'' +
            '}';
    }
}
