package com.jary.progress.common.java8.test;

import com.google.common.collect.Lists;
import com.jary.progress.common.java8.bean.Dish;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;


/**
 * @author fanzhengjie
 * @create 2018/8/24 下午10:56
 * @description 规约操作
 */
public class TestReduce {

    private static List<Dish> menu = Arrays.asList(
        new Dish("pork", false, 800, Dish.Type.MEAT),
        new Dish("beef", false, 700, Dish.Type.MEAT),
        new Dish("chicken", false, 400, Dish.Type.MEAT),
        new Dish("french fries", true, 530, Dish.Type.OTHER),
        new Dish("rice", true, 350, Dish.Type.OTHER),
        new Dish("season fruit", true, 120, Dish.Type.OTHER),
        new Dish("pizza", true, 550, Dish.Type.OTHER),
        new Dish("prawns", false, 300, Dish.Type.FISH),
        new Dish("salmon", false, 450, Dish.Type.FISH) );

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5,3,1,2,4);
        System.out.println(sum(numbers));
        System.out.println(multi(numbers));
        optionalSum(Lists.newArrayList());
        MaxMin(numbers);
        testDish();
        testCount();
        testGroup();
        testPartitioning();
        System.out.println(partitionPrimes(10));
    }

    public static Integer sum(List<Integer> list){
        //return list.stream().reduce(0,(a, b)-> a+b);
        return list.stream().reduce(0, Integer::sum);
    }

    public static Integer multi(List<Integer> list){
        return list.stream().reduce(1, (a,b)->a*b);
    }

    public static void optionalSum(List<Integer> list){
        Optional<Integer> sum = list.stream().reduce((a,b)->(a+b));
        System.out.println(sum.isPresent()?sum.get():"value is null");
    }

    public static void MaxMin(List<Integer> list){
        Optional<Integer> max = list.stream().reduce(Integer::max);
        System.out.println(max.isPresent()?max.get():"max is null");
        Optional<Integer> min = list.stream().reduce(Integer::min);
    }

    public static void testDish(){
        //方法1
        int count = menu.stream()
            .map(d -> 1)
            .reduce(0, (a, b) -> a + b);
        System.out.format("一共有%d道菜肴\n", count);

        //方法2
        long count2 = menu.stream().count();
        System.out.format("一共有%d道菜肴\n", count2);
    }

    public static void testCount(){
        long howManyDishs = menu.stream().collect(counting());
        System.out.println("有"+howManyDishs+"道菜！");
        howManyDishs = menu.stream().count();
        System.out.println("有"+howManyDishs+"道菜！");

        //找最大
        Optional<Dish> mostCalories = menu.stream()
            .collect(maxBy(Comparator.comparingInt(Dish::getCalories)));
        System.out.println(mostCalories.isPresent()?mostCalories.get():"null");

        //统计信息
        IntSummaryStatistics intSummaryStatistics = menu.stream()
            .collect(summarizingInt(Dish::getCalories));
        System.out.println(intSummaryStatistics);

        //连接字符串
        String menuname = menu.stream().map(Dish::getName).collect(joining(","));
        System.out.println(menuname);
    }

    public static void testGroup(){
        Map<Dish.Type, List<Dish>> dishByType = menu.stream()
            .collect(groupingBy(Dish::getType));
        System.out.println(dishByType);

        //按自定义类型分组
        Map<CaloricLevel, List<Dish>> dishByLevel = menu.stream()
            .collect(groupingBy(dish -> {
                    if(dish.getCalories() <= 400)
                        return CaloricLevel.DIET;
                    else if(dish.getCalories() <= 700)
                        return CaloricLevel.NORMAL;
                    else
                        return CaloricLevel.FAT;
            }));
        System.out.println(dishByLevel);

        //多级分组
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream()
            .collect(groupingBy(Dish::getType, groupingBy(dish -> {
                if(dish.getCalories() <= 400)
                    return CaloricLevel.DIET;
                else if(dish.getCalories() <= 700)
                    return CaloricLevel.NORMAL;
                else
                    return CaloricLevel.FAT;
            })));
        System.out.println(dishesByTypeCaloricLevel);

        //按子组收集数据
        Map<Dish.Type, Long> typesCount = menu.stream()
            .collect(groupingBy(Dish::getType, counting()));
        System.out.println(typesCount);

        //找到每个类型热量最大的
        Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream()
            .collect(groupingBy(Dish::getType, maxBy(Comparator.comparing(Dish::getCalories))));
        System.out.println(mostCaloricByType);

        //把收集器到的结果转换为另一种类型
        Map<Dish.Type, Dish> mostCaloricByType2 = menu.stream()
            .collect(groupingBy(Dish::getType, collectingAndThen(maxBy(Comparator.comparing(Dish::getCalories)),Optional::get)));
        System.out.println(mostCaloricByType2);

        //与groupingBy联合使用的其他收集器的例子
        Map<Dish.Type, Integer> totalCaloriesByType = menu.stream()
            .collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
        System.out.println(totalCaloriesByType);

    }

    public static void testPartitioning(){//分区
        Map<Boolean, List<Dish>> partitionedMenu = menu.stream()
            .collect(partitioningBy(Dish::isVegetarian));
        partitionedMenu.get(true);
        System.out.println(partitionedMenu);

        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menu.stream()
            .collect(partitioningBy(Dish::isVegetarian, collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(mostCaloricPartitionedByVegetarian);
    }

    public static enum CaloricLevel{
        DIET, NORMAL, FAT
    }

    //按数字将质数和非质数分区
    public static Map<Boolean, List<Integer>> partitionPrimes(int n){
        return IntStream.rangeClosed(2, n).boxed()
            .collect(partitioningBy(candidate -> isPrime(candidate)));
    }


    //判断是否为质数
    public static boolean isPrime(int candidate){
        int candidateRoot = (int) Math.sqrt(candidate);
        return IntStream.rangeClosed(2, candidateRoot)
            .noneMatch(i -> candidate%i == 0);
    }
}
