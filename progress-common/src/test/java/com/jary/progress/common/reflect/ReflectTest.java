package com.jary.progress.common.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author fanzhengjie
 * @date 2020/5/29 9:00 下午
 */
public class ReflectTest {

    /**
     * 获取Class对象
     */
    @Test
    public void testGetClassObject() throws ClassNotFoundException {
        //第一种方式获取class对象
        Person p1 = new Person();
        Class c1 = p1.getClass();
        System.out.println(c1);

        //第二种方式获取class对象
        Class c2 = Person.class;
        System.out.println(c2);

        //第三种方式获取class对象
        Class c3 = Class.forName("com.jary.progress.common.reflect.Person");
        System.out.println(c3);

        System.out.println(c1 == c2);
        System.out.println(c2 == c3);
    }

    /**
     * 获取构造
     *
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    @Test
    public void testGetConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Person.class;
        //1、获取Person2类所有公共构造
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor con : constructors) {
            System.out.println(con);
        }

        //2、获取指定构造方法
        //2.1、无参数
        Constructor con1 = clazz.getConstructor();
        Object oo = con1.newInstance();

        //2.2、有参数
        Constructor con2 = clazz.getConstructor(int.class, int.class, String.class);
        Object oo2 = con2.newInstance(1, 2, "haha");

        //3、获取私有构造方法
        Constructor con3 = clazz.getDeclaredConstructor(int.class);
        //暴力访问
        con3.setAccessible(true);
        Object oo3 = con3.newInstance(1);


        //直接获取空参数构造，必须public
        clazz.newInstance();

    }

    /**
     * 获取成员变量
     */
    @Test
    public void testGetFiled() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class clazz = Person.class;
        Object obj = clazz.newInstance();

        //获取Person类的所有【公共】成员变量
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }

        Field field = clazz.getField("name");
        field.set(obj, "haha");
        System.out.println(obj);

        //获取私有变量
        Field field2 = clazz.getDeclaredField("idCard");
        field2.setAccessible(true);
        field2.set(obj, "123456");
        System.out.println(obj);
    }

    /**
     * 获取成员方法
     */
    @Test
    public void testGetMethod() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Person.class;
        Object obj = clazz.newInstance();
        //获取Person类所有【公共】成员方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        Method m = clazz.getMethod("show");
        m.invoke(obj);

        Method m1 = clazz.getMethod("show", int.class);
        m1.invoke(obj, 1);

        Method m2 = clazz.getDeclaredMethod("show", String.class);
        m2.setAccessible(true);
        m2.invoke(obj, "smt");
    }
}
