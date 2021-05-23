/**
 *
 */
package com.jary.progress.juc.futuretask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author linzhibing
 *
 */
public class TestCompletionService {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletionService<String> completionService = new ExecutorCompletionService<String>(executorService);
        List<String> list = Arrays.asList("lily", "alan", "nathen", "alice");
        list.forEach(element -> {
            completionService.submit(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(1000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return element;
            });
        });

        List<String> resultList = getExecResult(completionService, list.size());
        resultList.forEach(e -> {
            System.out.println("result is:" + e);
        });
    }

    private static List<String> getExecResult(CompletionService<String> completionService, int taskNum) {
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < taskNum; i++) {
            try {
                Future<String> future = completionService.poll(2000l, TimeUnit.MILLISECONDS);
                if (future != null) {
                    //在给定时间内没有超时
                    String result = future.get(1000l, TimeUnit.MILLISECONDS);//返回是任务列表中最早执行完的那个结果，并不一定是顺序第一个
                    resultList.add(result);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return resultList;
    }


}
