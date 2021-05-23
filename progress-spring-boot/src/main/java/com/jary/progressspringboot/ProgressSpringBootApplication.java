package com.jary.progressspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @EnableScheduling 注解的作用是发现注解 @Scheduled 的任务并在后台执行该任务。
 */
@EnableScheduling
@SpringBootApplication
public class ProgressSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProgressSpringBootApplication.class, args);
    }

}
