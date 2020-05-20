package com.jary.progress.design.mode.prototype;

import org.junit.Test;

/**
 * @author fanzhengjie
 * @date 2020/5/20 10:06 下午
 */
public class PrototypeTest {

    /**
     * 测试浅拷贝
     */
    @Test
    public void testShallowCopy() throws CloneNotSupportedException {
        Person p1 = new Person();
        p1.setAge(31);
        p1.setName("Peter");
        System.out.println("p1="+p1);

        Person p2 = (Person) p1.clone();
        System.out.println(p1 == p2);
        System.out.println("p2="+p2);

        p2.setName("Jacky");
        System.out.println("p1="+p1);
        System.out.println("p2="+p2);
    }

    @Test
    public void testShallowCop2() throws Exception{
        Address address=new Address();
        address.setType("Home");
        address.setValue("北京");

        Person p1=new Person();
        p1.setAge(31);
        p1.setName("Peter");
        p1.setAddress(address);

        Person p2=(Person) p1.clone();
        System.out.println(p1==p2);//false
        System.out.println("p1="+p1);
        System.out.println("p2="+p2);

        p2.getAddress().setType("Office");
        System.out.println("p1="+p1);
        System.out.println("p2="+p2);
    }

    @Test
    public void testShallowDeep() throws Exception{
        com.jary.progress.design.mode.prototype.deep.Address address = new com.jary.progress.design.mode.prototype.deep.Address();
        address.setType("Home");
        address.setValue("北京");

        com.jary.progress.design.mode.prototype.deep.Person p1=new com.jary.progress.design.mode.prototype.deep.Person();
        p1.setAge(31);
        p1.setName("Peter");
        p1.setAddress(address);

        com.jary.progress.design.mode.prototype.deep.Person p2=(com.jary.progress.design.mode.prototype.deep.Person) p1.clone();
        System.out.println(p1==p2);//false
        System.out.println("p1="+p1);
        System.out.println("p2="+p2);

        p2.getAddress().setType("Office");
        System.out.println("p1="+p1);
        System.out.println("p2="+p2);
    }
}
