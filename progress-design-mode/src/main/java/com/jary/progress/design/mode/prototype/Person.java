package com.jary.progress.design.mode.prototype;

import lombok.Data;
import lombok.ToString;

/**
 * @author fanzhengjie
 * @date 2020/5/20 10:00 下午
 * https://blog.csdn.net/qq_33314107/article/details/80271963
 */
@Data
@ToString
public class Person implements Cloneable{

    private String name;
    private Integer age;
    private Address address;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
