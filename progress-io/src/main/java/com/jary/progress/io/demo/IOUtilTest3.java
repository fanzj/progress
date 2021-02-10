package com.jary.progress.io.demo;

import java.io.File;
import java.io.IOException;

/**
 * @author fanzhengjie
 * @create 2018/9/7 下午11:14
 * @description
 */
public class IOUtilTest3 {

    public static void main(String[] args) throws IOException {
        IOUtil.copyFile(new File("/Users/fanzhengjie/IdeaProjects/daily/src/main/java/com/daily/demo/io/file.txt"), new File("/Users/fanzhengjie/IdeaProjects/daily/src/main/java/com/daily/demo/io/file_copy.txt"));
    }

}
