package com.jary.progressspringboot.scheduler.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author fanzhengjie
 * @date 2020/6/28 7:48 下午
 * 基于java.util.Timer定时器，实现类似闹钟的定时任务。这种方式在项目中使用较少
 */
public class TimerDemo {

    public static void main(String[] args) {
        System.out.println("Server is running ...");

        TimerTask timerTask =  new TimerTask() {
            @Override
            public void run() {
                System.out.println("task  run:"+ new Date());
                try {
                    //模拟子任务耗时操作
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Timer timer = new Timer();

        //每隔3秒执行一次
        //1.子任务耗时小于3秒, ok
        //2.子任务耗时大于3秒, 每隔子任务实际耗时执行一次
        timer.schedule(timerTask,10,3000);
    }
}
