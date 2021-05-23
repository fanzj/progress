package com.jary.progress.common.io.io;

import java.io.*;

/**
 * @author fanzhengjie
 * @create 2018/9/10 下午11:25
 * @description
 */
public class BrAndBwOrPwDemo {

    public static void main(String[] args) throws IOException {
        //对文件进行读写操作
       /* BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/fanzhengjie/IdeaProjects/daily/src/main/java/com/daily/demo/io/file.txt")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/fanzhengjie/IdeaProjects/daily/src/main/java/com/daily/demo/io/file_3.txt")));
        String line;
        while((line = br.readLine())!=null){
            System.out.println (line);//一次读一行，并不能识别换行
            bw.write(line);
            //单独写出换行操作
            bw.newLine();//换行操作
            bw.flush();
        }
        br.close();
        bw.close();*/

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/fanzhengjie/IdeaProjects/daily/src/main/java/com/daily/demo/io/file.txt")));
        PrintWriter pw = new PrintWriter("/Users/fanzhengjie/IdeaProjects/daily/src/main/java/com/daily/demo/io/file_4.txt");
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);//一次读一行，并不能识别换行
            pw.println(line);
            pw.flush();
        }
        br.close();
        pw.close();

    }

}
