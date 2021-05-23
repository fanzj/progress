package com.jary.progress.common.guava.cache;

import com.google.common.cache.*;
import com.jary.progress.common.guava.cache.bean.Student;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author fanzhengjie
 * @create 2019/1/14 下午9:14
 * @description
 */
public class CacheDemo4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //缓存接口这里是LoadingCache，LoadingCache在缓存项不存在时可以自动加载缓存
        //CacheBuilder的构造函数是私有的，只能通过其静态方法newBuilder()来获得CacheBuilder的实例
        LoadingCache<Integer, Student> studentCache
                = CacheBuilder.newBuilder()
                .concurrencyLevel(8)//设置并发级别为8，并发级别是指可以同时写缓存的线程数
                .expireAfterWrite(8, TimeUnit.SECONDS)//设置写缓存后8秒钟过期
                .initialCapacity(10)//设置缓存容器的初始容量为10
                .maximumSize(100)//设置缓存最大容量为100，超过100之后就会按照LRU最近虽少使用算法来移除缓存项
                .recordStats()//设置要统计缓存的命中率
                .removalListener(new RemovalListener<Object, Object>() {//设置缓存的移除通知
                    @Override
                    public void onRemoval(RemovalNotification<Object, Object> notification) {
                        System.out.println(notification.getKey() + " was removed, cause is " + notification.getCause());
                    }
                })
                .build(new CacheLoader<Integer, Student>() {//build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
                    @Override
                    public Student load(Integer key) throws Exception {
                        System.out.println("load student " + key);
                        Student student = new Student();
                        student.setId(key);
                        student.setName("name " + key + " " + new Date());
                        return student;
                    }
                });


        for (int i = 0; i < 20; i++) {
            //从缓存中得到数据，由于我们没有设置过缓存，所以需要通过CacheLoader加载缓存数据
            Student student = studentCache.get(1);
            System.out.println(student);
            //休眠1秒
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println("cache stats:");
        //最后打印缓存的命中率等 情况
        System.out.println(studentCache.stats().toString());


    }

}
