package com.jary.progress.aop;


import com.jary.progress.annotation.Hash;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author fanzhengjie
 * @date 2020/5/26 10:21 上午
 */
@Aspect
@Component
@Order(1)
public class HashAop {

    @Pointcut("@annotation(com.jary.progress.annotation.DomainFieldHash)")
    public void pointCut(){

    }

    @Around("pointCut()")
    public void hash(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        if(args != null && args.length == 1 && args[0] != null) {
            Class<?> clazz = args[0].getClass();

            for(Field field : clazz.getDeclaredFields()) {
                if(field.getAnnotation(Hash.class) != null && field.getType().equals(String.class)) {

                    String hashName = genHashMethodName(field.getName(), "set");
                    Method declaredMethod = clazz.getDeclaredMethod(hashName, String.class);
                    declaredMethod.setAccessible(true);
                    field.setAccessible(true);
                    declaredMethod.invoke(args[0], toHash((String) field.get(args[0])));
                }
            }
        }
        proceedingJoinPoint.proceed();
    }

    private String toHash(String origin) {
        return "***" + origin + "xxx";
    }

    private String genHashMethodName(String fieldName, String prefix) {
        StringBuilder getMethodName = new StringBuilder();
        getMethodName.append(prefix).append(fieldName.substring(0, 1).toUpperCase()).append(fieldName.substring(1)).append("Hash");
        return getMethodName.toString();
    }

}
