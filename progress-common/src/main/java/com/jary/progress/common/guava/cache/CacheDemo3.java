package com.jary.progress.common.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author fanzhengjie
 * @create 2018/9/16 下午5:54
 * @description 进阶使用：异步刷新
 */
public class CacheDemo3 {

    /**
     * 如2中的使用方法，解决了同一个key的缓存过期时会让多个线程阻塞的问题，只会让用来执行刷新缓存操作的一个用户线程会被阻塞。
     * 由此可以想到另一个问题，当缓存的key很多时，高并发条件下大量线程同时获取不同key对应的缓存，
     * 此时依然会造成大量线程阻塞，并且给数据库带来很大压力。这个问题的解决办法就是将刷新缓存值的任务交给后台线程，
     * 所有的用户请求线程均返回旧的缓存值，这样就不会有用户线程被阻塞了。
     * <p>
     * 题外话：在使用内存缓存时，切记拿到缓存值之后不要在业务代码中对缓存直接做修改，
     * 因为此时拿到的对象引用是指向缓存真正的内容的。如果需要直接在该对象上进行修改，
     * 则在获取到缓存值后拷贝一份副本，然后传递该副本，进行修改操作。
     *
     * @param args
     */
    public static void main(String[] args) {
        ListeningExecutorService backgroundRefreshPools =
                MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(20));
        LoadingCache<String, Object> caches = CacheBuilder.newBuilder()
                .maximumSize(100)
                .refreshAfterWrite(10, TimeUnit.MINUTES)
                .build(new CacheLoader<String, Object>() {
                    @Override
                    public Object load(String s) {
                        return "generateValueByKey(key)";
                    }

                    @Override
                    public ListenableFuture<Object> reload(String key, Object oldValue) throws Exception {
                        return backgroundRefreshPools.submit(new Callable<Object>() {
                            @Override
                            public Object call() {
                                return "generateValueByKey(key)";
                            }
                        });
                    }
                });

        try {
            System.out.println(caches.get("key-zorro"));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
