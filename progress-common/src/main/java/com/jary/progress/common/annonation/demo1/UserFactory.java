package com.jary.progress.common.annonation.demo1;

import com.jary.progress.common.bean.User;

import java.lang.reflect.Method;

/**
 * @author fanzhengjie
 * @create 2019/1/12 上午10:48
 * @description 用“构造工厂”充当“注解解析器”
 */
public class UserFactory {

    public static User create(){
        User user = new User();

        //获取User类中的所有方法（getDeclaredMethods也行）
        Method[] methods = User.class.getMethods();

        try{
            for(Method method : methods){
                // 如果此方法有注解，就把注解里面的数据赋值到user对象
                if(method.isAnnotationPresent(Init.class)){
                    Init init = method.getAnnotation(Init.class);
                    method.invoke(user, init.value());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return user;
    }

}
