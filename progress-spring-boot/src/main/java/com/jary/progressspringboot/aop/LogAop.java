package com.jary.progressspringboot.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Aspect
@Component
@Slf4j
public class LogAop {

    @Pointcut("execution(* com.jary.progressspringboot.service.*.*(..))")
    public void pointCut() {

    }

    @Around("pointCut()")
    public void logPrint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object[] objects = proceedingJoinPoint.getArgs();
        if (Objects.nonNull(objects) && objects.length == 1 && Objects.nonNull(objects[0])) {

            Class clazz = objects[0].getClass();

            log.info(clazz.getSimpleName());

            Signature signature = proceedingJoinPoint.getSignature();

            log.info("start execute {}, request: {}", signature.getDeclaringTypeName(), JSON.toJSONString(objects[0]));

            Object response = proceedingJoinPoint.proceed();

            log.info("end execute {}, response: {}", signature.getDeclaringTypeName(), JSON.toJSONString(response));


        }

    }
}
