package com.jary.progress.common.java8.bean;

/**
 * @author fanzhengjie
 * @create 2018/7/29 下午8:06
 * @description 菜肴
 */
public class Dish {

    private String name;//名称

    private Integer calories;//卡路里

    private boolean vegetarian;

    private Type type;

    public Dish() {
    }

    public Dish(String name, Integer calories) {
        this.name = name;
        this.calories = calories;
    }

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }

    public enum Type {
        MEAT, FISH, OTHER
    }
}
