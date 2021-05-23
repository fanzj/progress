package com.jary.progress.common.test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {

    byte[] array = new byte[1024 * 1024];//1M

    /**
     * -Xms1m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
     * @param args
     */
    public static void main(String[] args) {
        List<Demo01> list = new ArrayList<>();

        int count = 0;


        try{
            while (true) {
                list.add(new Demo01());
                count ++;
            }
        }catch (Exception e){

        }

    }
}
