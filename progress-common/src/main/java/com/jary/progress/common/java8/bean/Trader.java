package com.jary.progress.common.java8.bean;

/**
 * @author fanzhengjie
 * @create 2018/8/25 下午12:33
 * @description 交易员
 */
public class Trader {

    private final String name;
    private final String city;
    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader{" +
            "name='" + name + '\'' +
            ", city='" + city + '\'' +
            '}';
    }
}
