package com.jary.progress.common.basic;

/**
 * @author fanzhengjie
 * @create 2019/11/29 下午8:18
 * @description
 */
public class StringTest {

    public static final String a = "123";
    public static final String b = "456";
    public static final String c;
    public static final String d;

    static {
        c = "111";
        d = "222";
    }

    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "Hel" + "lo";
        String s4 = "Hel" + new String("lo");
        String s5 = new String("Hello");
        String s6 = s5.intern();
        String s7 = "H";
        String s8 = "ello";
        String s9 = s7 + s8;

        System.out.println(s1 == s2);  // true
        System.out.println(s1 == s3);  // true
        System.out.println(s1 == s4);  // false
        System.out.println(s1 == s9);  // false
        System.out.println(s4 == s5);  // false
        System.out.println(s1 == s6);  // true

       /* String c = "123456";
        String d = a + b;
        System.out.println(c == d); //true*/

       /*String e = "111222";
       String f = c + d;
        System.out.println(e == f);// false*/
    }

}
