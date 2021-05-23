package com.jary.progress.io.csv;

import com.csvreader.CsvWriter;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author fanzhengjie
 * @create 2019/11/14 上午11:20
 * @description
 */

public class WriterTest {

    public static void main(String[] args) {
        String filePath = "/Users/fanzhengjie/test.csv";

        try {
            // 创建CSV写对象
            CsvWriter csvWriter = new CsvWriter(filePath, ',', Charset.forName("UTF-8"));

            // 写表头
            String[] headers = {"编号", "姓名", "年龄"};
            csvWriter.writeRecord(headers);

            for (int i = 0; i < 10; i++) {
                String[] content = {"" + i, "aaaa", "10"};
                csvWriter.writeRecord(content);
            }
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}