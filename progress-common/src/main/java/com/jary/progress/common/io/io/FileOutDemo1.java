package com.jary.progress.common.io.io;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author fanzhengjie
 * @create 2018/9/7 下午10:59
 * @description
 */
public class FileOutDemo1 {

    public static void main(String[] args) throws IOException {
        //如果该文件不存在，则直接创建，如果存在，删除后创建
        FileOutputStream out = new FileOutputStream("/Users/fanzhengjie/IdeaProjects/daily/src/main/java/com/daily/demo/io/out.dat");
        out.write('A');//写出了'A'的低8位
        out.write('B');//写出了'B'的低8位
        int a = 10;//write只能写出8位，那么写一个int需要写4次，每次8位
        out.write(a >>> 24);
        out.write(a >>> 16);
        out.write(a >>> 8);
        out.write(a);
        byte[] gbk = "中国".getBytes("gbk");
        out.write(gbk);
        out.close();

        IOUtil.printHex("/Users/fanzhengjie/IdeaProjects/daily/src/main/java/com/daily/demo/io/out.dat");
    }


}
