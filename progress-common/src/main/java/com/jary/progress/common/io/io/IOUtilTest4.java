package com.jary.progress.common.io.io;

import java.io.File;
import java.io.IOException;

/**
 * @author fanzhengjie
 * @create 2018/9/9 上午9:44
 * @description
 */
public class IOUtilTest4 {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        IOUtil.copyFileByBuyte(
                new File("/Users/fanzhengjie/IdeaProjects/daily/src/main/java/com/daily/demo/io/file.txt"),
                new File("/Users/fanzhengjie/IdeaProjects/daily/src/main/java/com/daily/demo/io/file_copy.txt"));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}
