package com.jary.progress.design.mode.strategy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author fanzhengjie
 * @date 2020/5/15 9:43 上午
 */
public class CashContextV3 {

    private Object obj = null;

    public CashContextV3(String type, Class[] paramsType, Object[] params) {
        CashTypeEnum cashTypeEnum = CashTypeEnum.getBy(type);
        try {
            Class clazz = Class.forName(cashTypeEnum.getClazz());
            Constructor constructor = clazz.getConstructor(paramsType);
            obj = constructor.newInstance(params);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public double getResult(double money) {
        return ((CashSuper) obj).acceptCash(money);
    }
}
