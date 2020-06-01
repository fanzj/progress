package com.jary.progressspringboot.hystrix;

import com.netflix.hystrix.HystrixCommandGroupKey;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import rx.Observable;
import rx.Observer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;

/**
 * @author fanzhengjie
 * @date 2020/5/29 3:15 下午
 */
@SpringBootTest
public class CommandHelloWorldTest {

    @Test
    public void testSync() {
        HystrixCommandGroupKey hystrixCommandGroupKey = HystrixCommandGroupKey.Factory.asKey("ExampleGroup");
        CommandHelloWorld command = new CommandHelloWorld(hystrixCommandGroupKey, "World");
        String result = command.execute();
        assertEquals("Hello, World", result);
    }

    @Test
    public void testAsync() throws ExecutionException, InterruptedException {
        HystrixCommandGroupKey groupKey = HystrixCommandGroupKey.Factory.asKey("ExampleGroup");
        assertEquals("Hello, Jack", new CommandHelloWorld(groupKey, "Jack").queue().get());
        assertEquals("Hello, Rose", new CommandHelloWorld(groupKey, "Rose").queue().get());

        CommandHelloWorld command = new CommandHelloWorld(groupKey, "Cheng");
        Future<String> future = command.queue();
        String result = future.get();
        assertEquals("Hello, Cheng", result);

        //  blocking
        Observable<String> observable = new CommandHelloWorld(groupKey, "Lucy").observe();
        assertEquals("Hello, Lucy", observable.toBlocking().single());

        //  non-blocking
        Observable<String> observable2 = new CommandHelloWorld(groupKey, "Jerry").observe();
        observable2.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("completed");

            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();

            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext: " + s);

            }

        });

    }

}
