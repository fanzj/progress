package com.jary.progress.common.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

/**
 * @author fanzhengjie
 * @create 2018/9/16 下午5:32
 * @description 简单使用：定时过期
 */
public class CacheDemo1 {

    /**
     * 如果用其他的缓存方式，如redis，我们知道下面这种“如果有缓存则返回；
     * 否则运算、缓存、然后返回”的缓存模式是有很大弊端的。当高并发条件下同时进行get操作，
     * 而此时缓存值已过期时，会导致大量线程都调用生成缓存值的方法，比如从数据库读取。
     * 这时候就容易造成数据库雪崩。这也就是我们常说的“缓存穿透”。
     * 而Guava cache则对此种情况有一定控制。当大量线程用相同的key获取缓存值时，
     * 只会有一个线程进入load方法，而其他线程则等待，直到缓存值被生成。这样也就避免了缓存穿透的危险。
     *
     * @param args
     */
    public static void main(String[] args) {
        LoadingCache<String, Object> caches = CacheBuilder.newBuilder()
                .maximumSize(100)//缓存容量大小，当缓存数量即将达到容量上线时，则会进行缓存回收，
                // 回收最近没有使用或总体上很少使用的缓存项（需要注意的是在接近这个容量上限时就会发生，
                // 所以定义这个值的时候需要视情况适量增大）
                .expireAfterWrite(10, TimeUnit.MINUTES)//缓存的过期时间，写入十分钟后过期
                .build(new CacheLoader<String, Object>() {

                    @Override
                    public Object load(String s) {//当获取的缓存值不存在或已经过期时，调用，进行缓存值计算
                        return "generateValueByKey(key)";
                    }
                });
    }

}
