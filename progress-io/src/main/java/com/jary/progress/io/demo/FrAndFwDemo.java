package com.jary.progress.io.demo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author fanzhengjie
 * @create 2018/9/9 上午11:19
 * @description
 */
public class FrAndFwDemo {

    public static void main(String[] args) throws IOException{
        FileReader fr = new FileReader("/Users/fanzhengjie/IdeaProjects/daily/src/main/java/com/daily/demo/io/file.txt");
        FileWriter fw = new FileWriter("/Users/fanzhengjie/IdeaProjects/daily/src/main/java/com/daily/demo/io/file_fr_fw.txt", true);//追加
        char[] buffer = new char[2056];
        int c;
        while((c = fr.read(buffer, 0, buffer.length))!=-1){
            fw.write(buffer, 0, c);
            fw.flush();
        }
        fr.close();
        fw.flush();
    }

}
