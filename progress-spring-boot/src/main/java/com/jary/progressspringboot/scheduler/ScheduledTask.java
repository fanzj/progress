package com.jary.progressspringboot.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author fanzhengjie
 * @date 2020/6/28 8:24 下午
 * @Scheduled 实现定时任务, 容器启动就会定时运行
 */
@Component
public class ScheduledTask {

    /**
     * 每隔三秒执行一次(子任务时间小于3秒)
     */
    @Scheduled(fixedRate = 3000)
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

}
