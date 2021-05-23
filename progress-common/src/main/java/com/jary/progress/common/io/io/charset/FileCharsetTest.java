package com.jary.progress.common.io.io.charset;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author fanzhengjie
 * @create 2019/1/10 上午11:41
 * @description
 */
public class FileCharsetTest {

    private static final String PATH = "src/main/java/com/daily/demo/io/file/";

    public static void main(String[] args) throws IOException {
        String file = PATH + "stream.txt";
        String charset = "UTF-8";
        //写字符转换成字节流
        FileOutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, charset);
        try {
            writer.write("这是要保存的中文字符");
        } finally {
            writer.close();
        }
        //读取字节转换成字符
        FileInputStream inputStream = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(inputStream, charset);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char[] buf = new char[64];
        try {
            while ((count = reader.read(buf)) != -1) {
                sb.append(buf, 0, count);
            }
        } finally {
            reader.close();
        }
        System.out.println(sb.toString());

    }

}
