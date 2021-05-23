package com.jary.progress.common.regex;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author fanzhengjie
 * @create 2018/9/22 下午4:46
 * @description 正则表达式例子
 * 在regex包中，包括了两个类，Pattern(模式类)和Matcher(匹配器类)。
 * Pattern类是用来表达和陈述所要搜索模式的对象，Matcher类是真正影响搜索的对象。
 * <p>
 * /s也另外一个比较有用的单字符类型，用来匹配空格，比如Space键，tab键和换行符
 * /d单字符类型用来匹配从0到9的任何数字，另外{3}重复符号，是个简便的记号，用来表示有3个连续的数字位
 */
public class RegexTest {

    public static void main(String[] args) {
        //test1();
        //test2();
        test3();
    }

    /**
     * 匹配电话号码
     */
    public static void test1() {
        System.out.println("电话号码匹配V1.0");
        String s110 = "(212)555-1212";
        String s111 = "(212) 555-1212";//ok
        String s112 = "(212)  555-1212";
        String s120 = "212-555-1212";
        String s130 = "212 555 1212";
        List<String> phone = Arrays.asList(s110, s111, s112, s120, s130);

        //匹配(nnn)nnn-nnnn
        Pattern pattern = Pattern.compile("\\(\\d{3}\\)\\s\\d{3}-\\d{4}");
        phone.stream().forEach(s -> {
                    Matcher matcher = pattern.matcher(s);
                    if (matcher.find()) {
                        System.out.println(matcher.group());
                    } else {
                        System.out.format("%s不匹配\n", s);
                    }
                }
        );

        System.out.println("\n电话号码匹配V1.1");
        // \\s?元字符表示在模式可能有0或1个空格符
        Pattern pattern2 = Pattern.compile("(\\(\\d{3}\\)|\\d{3})\\s?\\d{3}(-|)?\\d{4}");
        String s210 = "(212)555-1212";//ok
        String s211 = "212 555-1212";//ok
        String s212 = "212  555-1212";
        String s220 = "212 555-1212";//ok
        String s221 = "212 5551212";//ok
        String s222 = "212 555 1212";
        Arrays.asList(s210, s211, s212, s220, s221, s222)
                .stream().forEach(s -> {
            Matcher matcher = pattern2.matcher(s);
            if (matcher.find()) {
                System.out.println(matcher.group());
            } else {
                System.out.format("%s不匹配\n", s);
            }
        });
    }

    /**
     * 检查文本文件中是否有重复的单词
     * /w元字符用来匹配从字母a到u的任何字符。
     * +元字符表示匹配匹配一次或多次字符，
     * /b元字符是用来说明匹配单词的边界，它可以是空格或任何一种不同的标点符号(包括逗号，句号等)。
     */
    public static void test2() {
        String word = "The the theme of this article is the Java's regex package.";
        String word2 = "Paris in the the spring";
        String word3 = "Java's regex package is the theme of this article";
        String word4 = "abc   abc df   dfas";

        Pattern pattern = Pattern.compile("\\b(\\w+)\\s+\\1\\b", Pattern.CASE_INSENSITIVE);
        Arrays.asList(word, word2, word3, word4).stream().forEach(
                s -> {
                    Matcher matcher = pattern.matcher(s);
                    if (matcher.find()) {
                        //System.out.println(matcher.group(1));
                        System.out.println(matcher.group());
                    } else {
                        System.out.format("%s不匹配\n", s);
                    }
                }
        );

    }

    public static void test3() {
        String s = "Evening is full of the linnet's wings";
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        int i = 0;
        while (matcher.find(i)) {
            System.out.println(matcher.group());
            i++;
        }

    }


}
