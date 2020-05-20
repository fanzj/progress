package com.jary.progress.design.mode.prototype.deep;

import lombok.Data;
import lombok.ToString;

/**
 * @author fanzhengjie
 * @date 2020/5/20 10:00 下午
 */
@Data
@ToString
public class Person implements Cloneable{

    private String name;
    private Integer age;
    private Address address;

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();
        Address ad = ((Person) obj).getAddress();
        ((Person) obj).setAddress((Address) ad.clone());
        return obj;
    }
}
