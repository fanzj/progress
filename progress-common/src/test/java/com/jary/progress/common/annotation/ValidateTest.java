package com.jary.progress.common.annotation;


import com.jary.progress.common.bean.User;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author fanzhengjie
 * @create 2019/1/12 上午11:28
 * @description
 */
public class ValidateTest {

    @Test
    public void testValidate() {
        User user = new User();

        user.setName("liang");
        user.setAge("12");

        System.out.println(check(user));
    }

    public boolean check(User user) {
        if (user == null) {
            System.out.println("！！校验对象为空！！");
            return false;
        }

        // 获取User类的所有属性（如果使用getFields，就无法获取到private的属性）
        Field[] fields = User.class.getDeclaredFields();
        for (Field field : fields) {
            // 如果属性有注解，就进行校验
            if (field.isAnnotationPresent(Validate.class)) {
                Validate validate = field.getAnnotation(Validate.class);
                if (field.getName().equals("age")) {
                    if (user.getAge() == null) {
                        if (validate.isNotNull()) {
                            System.out.println("！！年龄可空校验不通过：不可为空！！");
                            return false;
                        } else {
                            System.out.println("年龄可空校验通过：可以为空");
                            continue;
                        }
                    } else {
                        System.out.println("年龄可空校验通过");
                    }
                    if (user.getAge().length() < validate.min()) {
                        System.out.println("！！年龄最小长度校验不通过！！");
                        return false;
                    } else {
                        System.out.println("年龄最小长度校验通过");
                    }

                    if (user.getAge().length() > validate.max()) {
                        System.out.println("！！年龄最大长度校验不通过！！");
                        return false;
                    } else {
                        System.out.println("年龄最大长度校验通过");
                    }

                }

                if (field.getName().equals("name")) {
                    if (user.getName() == null) {
                        if (validate.isNotNull()) {
                            System.out.println("！！名字可空校验不通过：不可为空！！");
                            return false;
                        } else {
                            System.out.println("名字可空校验通过：可以为空");
                            continue;
                        }
                    } else {
                        System.out.println("名字可空校验通过");
                    }

                    if (user.getName().length() < validate.min()) {
                        System.out.println("！！名字最小长度校验不通过！！");
                        return false;
                    } else {
                        System.out.println("名字最小长度校验通过");
                    }

                    if (user.getName().length() > validate.max()) {
                        System.out.println("！！名字最大长度校验不通过！！");
                        return false;
                    } else {
                        System.out.println("名字最大长度校验通过");
                    }
                }
            }
        }
        return true;
    }
}
