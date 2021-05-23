package com.jary.progress.common.java8;


import com.jary.progress.common.java8.bean.Trader;
import com.jary.progress.common.java8.bean.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author fanzhengjie
 * @create 2018/8/25 下午12:35
 * @description 交易员和交易测试
 */
public class TestTransaction {

    public static void main(String[] args) {
        //数据初始化
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1.找出2011年发生的所有交易，并按交易额排序(从低到高)。
        List<Transaction> result1 = transactions.stream().filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        print1(result1);


        //2.交易员都在哪些不同的城市工作过?
        List<String> result2 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(result2);

        //3.查找所有来自于剑桥的交易员，并按姓名排序。
        List<Trader> result3 = transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getTrader)
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        print2(result3);

        //4.返回所有交易员的姓名字符串，按字母顺序排序。
        transactions.stream()
                .map(Transaction::getTrader)
                .sorted(Comparator.comparing(Trader::getName))
                .map(Trader::getName)
                .distinct()
                .forEach(name -> System.out.println(name));

        //5.有没有交易员是在米兰工作的
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity() == "Milan")
                .findFirst()
                .ifPresent(trader -> System.out.println(trader));

        //6.打印生活在剑桥的交易员的所有交易额。
        Integer result6 = transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .reduce(0, (t1, t2) -> (t1 + t2));
        System.out.println(result6);


        //7.所有交易中，最高的交易额是多少?
        Optional<Integer> optional = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo);
        System.out.println(optional.isPresent() ? optional.get() : "value is null");

        //8.找到交易额最小的交易。
        transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue))
                .findFirst()
                .ifPresent(transaction -> System.out.println(transaction));
    }

    private static void print1(List<Transaction> result) {
        result.stream().forEach(transaction -> System.out.println(transaction));
    }

    private static void print2(List<Trader> result) {
        result.stream().forEach(trader -> System.out.println(trader));
    }

}
