package com.jary.progressspringboot.scheduler;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.time.LocalDateTime;

/**
 * @author fanzhengjie
 * @date 2020/6/28 8:24 下午
 * @Scheduled 实现定时任务, 容器启动就会定时运行
 * https://github.com/Snailclimb/springboot-guide/blob/master/docs/advanced/SpringBoot-ScheduleTasks.md
 */
@Component
public class ScheduledTask {

    /**
     * 每隔三秒执行一次(子任务时间小于3秒)
     * 定时任务开始后再次执行定时任务的延时（需等待上次定时任务完成）
     */
    //@Scheduled(fixedRate = 3000)
    public void scheduledTask() {
        System.out.println("任务执行时间：" + LocalDateTime.now() + " " + ScheduledTask.class.getName());
    }

    /**
     * 每隔三秒执行一次(子任务时间大于3秒), 此时以实际子任务执行时间为准，每隔5秒执行一次
     */
    //@Scheduled(fixedRate = 3000)
    public void scheduledTask2() throws InterruptedException {
        System.out.println("任务执行时间：" + LocalDateTime.now() + " " + ScheduledTask.class.getName());
        Thread.sleep(5000);
    }

    /**
     * 每隔3秒执行一次
     */
    //@Scheduled(cron = "0/3 * * * * *")
    public void scheduledTask3() {
        System.out.println(MessageFormat.format("使用cron---任务执行时间：{0}  线程名称：{1}",
                LocalDateTime.now(),
                Thread.currentThread().getName()));
    }

    /**
     * 定时任务执行完成后再次执行定时任务的延时（需等待上次定时任务完成）
     */
    //@Scheduled(fixedDelay = 3000)
    public void scheduledTask4(){
            System.out.println(MessageFormat.format("使用cron---任务执行时间：{0}  线程名称：{1}",
            LocalDateTime.now(),
            Thread.currentThread().getName()));
    }

    @Async
    @Scheduled(cron = "0/5 * * * * *")
    public void scheduled(){
        System.out.println(MessageFormat.format("使用cron---任务执行时间：{0}  线程名称：{1}",
                LocalDateTime.now(),
                Thread.currentThread().getName()));
    }

    @Async
    @Scheduled(fixedRate = 5000)
    public void scheduled1() {
        System.out.println(MessageFormat.format("fixedRate---任务执行时间：{0}  线程名称：{1}",
                LocalDateTime.now(),
                Thread.currentThread().getName()));
    }

    @Async
    @Scheduled(fixedDelay = 5000)
    public void scheduled2() {
        System.out.println(MessageFormat.format("fixedDelay---任务执行时间：{0}  线程名称：{1}",
                LocalDateTime.now(),
                Thread.currentThread().getName()));
    }


}
