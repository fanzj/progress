package com.jary.progress.common.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author fanzhengjie
 * @create 2018/9/16 下午5:43
 * @description 进阶使用：定时刷新
 */
public class CacheDemo2 {

    /**
     * 如上的使用方法，虽然不会有缓存穿透的情况，但是每当某个缓存值过期时，老是会导致大量的请求线程被阻塞。
     * 而Guava则提供了另一种缓存策略，缓存值定时刷新：更新线程调用load方法更新该缓存，其他请求线程返回该缓存的旧值。
     * 这样对于某个key的缓存来说，只会有一个线程被阻塞，用来生成缓存值，而其他的线程都返回旧的缓存值，不会被阻塞。
     * 此外需要注意一个点，这里的定时并不是真正意义上的定时。Guava cache的刷新需要依靠用户请求线程，让该线程去进行load方法的调用，
     * 所以如果一直没有用户尝试获取该缓存值，则该缓存也并不会刷新。
     * @param args
     */
    public static void main(String[] args) {
        LoadingCache<String, Object> caches = CacheBuilder.newBuilder()
            .maximumSize(100)
            .refreshAfterWrite(10, TimeUnit.MINUTES)
            .build(new CacheLoader<String, Object>() {
                @Override
                public Object load(String key) throws Exception {
                    return "generateValueByKey(key)" + key;
                }
            });
        try {
            System.out.println(caches.get("key-zorro"));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
