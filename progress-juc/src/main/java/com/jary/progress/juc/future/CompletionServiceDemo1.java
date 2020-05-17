package com.jary.progress.juc.future;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fanzhengjie
 * @date 2020/5/16 11:45 下午
 */
public class CompletionServiceDemo1 {

    /**
     * 1、使用FutureTask轮循获取任务，如果第一个任务未完成第二个任务已完成，循环会阻塞在第一个任务的get方法处。
     * 2、使用CompletionService实现任务优先完成优先拿到结果，结果按照任务完成顺序返回。内部使用BlockingQueue无界队列管理Future，有执行完毕的任务就把结果放入队列。
     * 3、take()获取并移除表示下一个已完成任务的Future，如果目前不存在，则等待；poll()如果目前不存在，则返回null。
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);
        List<String> list = Arrays.asList("lily", "alan", "nathen", "alice");
        Long[] time = new Long[]{5000L, 2000L, 3000L, 10000L};
        AtomicInteger num = new AtomicInteger(0);
        list.forEach(element -> {
            completionService.submit(()-> {
                System.out.println("args = [" + element +"]");
                TimeUnit.MILLISECONDS.sleep(time[num.getAndIncrement()]);
                return element;
            });
        });

        List<String> resultList = getExecResult(completionService, list.size());
        resultList.forEach(e -> System.out.println("result is " + e));
        executorService.shutdown();
    }

    private static List<String> getExecResult(CompletionService<String> completionService, int taskNum) {
        List<String> resultList = new ArrayList<>();
        for(int i=0;i<taskNum;i++){
            try{
               // Future<String> future = completionService.poll();//poll没结果就返回null
                Future<String> future = completionService.take();//take可以阻塞得到结果
                if(future != null){
                    //在给定时间内没有超时
                    String result = future.get();//返回是任务列表中最早执行完的那个结果，并不一定是顺序第一个
                    resultList.add(result);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return resultList;
    }
}
