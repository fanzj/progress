package com.jary.progress.io.demo;

import java.io.*;

/**
 * @author fanzhengjie
 * @create 2018/9/9 上午10:18
 * @description
 */
public class IsrAndOswDemo {

    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("/Users/fanzhengjie/IdeaProjects/daily/src/main/java/com/daily/demo/io/file.txt");
        InputStreamReader isr = new InputStreamReader(in);//默认gbk
        FileOutputStream out = new FileOutputStream("/Users/fanzhengjie/IdeaProjects/daily/src/main/java/com/daily/demo/io/file_copy2.txt");
        OutputStreamWriter osw = new OutputStreamWriter(out);
        /*int c;
        while ((c=isr.read())!=-1){
            System.out.print((char) c);
        }*/
        char[] buffer = new char[8*1024];
        int c;
        //批量读取，放入buffer这个字符数组，从第0个位置开始放置，最多放buffer.length个
        //返回的是读到字符的个数
        while((c=isr.read(buffer,0,buffer.length))!=-1){
            String s= new String(buffer,0,c);
            System.out.print(s);
            osw.write(buffer, 0,c);
            osw.flush();
        }

        in.close();
        isr.close();
    }

}
