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
