package com.jary.progressspringboot.scheduler;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author fanzhengjie
 * @date 2020/6/28 7:56 下午
 * 基于ScheduledExecutorService实现定时任务, 类似Timer
 */
public class ScheduledExecutorDemo {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        /**
         *  @param command the task to execute 任务体
         *  @param initialDelay the time to delay first execution 首次执行的延时时间
         *  @param period the period between successive executions 任务执行间隔
         *  @param unit the time unit of the initialDelay and period parameters 间隔时间单位
         */
        System.out.println("start execute task "+new Date());
        //延迟5秒执行, 每隔3秒执行一次
        //service.scheduleAtFixedRate(() -> System.out.println("task ScheduledExecutorService " + new Date()), 5, 3, TimeUnit.SECONDS);

        //延迟0秒执行, 子任务时间大于3秒, 每隔子任务实际耗时执行一次
        /*service.scheduleAtFixedRate(() -> {
                    System.out.println("task ScheduledExecutorService " + new Date());
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }, 0, 3, TimeUnit.SECONDS);*/

        //延迟3秒执行(只执行一次)
        //service.schedule(() -> System.out.println("task ScheduledExecutorService " + new Date()), 3, TimeUnit.SECONDS);

        //延迟5秒执行, 每隔3秒执行一次
        //service.scheduleWithFixedDelay(() -> System.out.println("task ScheduledExecutorService " + new Date()), 5, 3, TimeUnit.SECONDS);

        //延迟0秒执行, 子任务超过3秒, 则等子任务执行完后, 再过3秒(即每隔8秒)执行一次
        service.scheduleWithFixedDelay(() -> {
            System.out.println("task ScheduledExecutorService " + new Date());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 0, 3, TimeUnit.SECONDS);

    }
}
