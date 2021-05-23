package com.jary.progress.common.annotation;

import java.lang.annotation.*;

/**
 * @author fanzhengjie
 * @create 2019/1/12 上午10:43
 * @description 自定义注解
 */
@Documented //注解包含在javadoc中
@Inherited //注解可以被继承
@Target({ElementType.METHOD, ElementType.FIELD}) //注解的作用目标: 方法和字段、枚举的常量
@Retention(RetentionPolicy.RUNTIME) //注解的保留策略:注解会在class字节码文件中存在，在运行时可以通过反射获取到
public @interface Init {

    String value() default "";

}
