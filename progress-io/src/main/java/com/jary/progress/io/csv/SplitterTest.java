package com.jary.progress.io.csv;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @author fanzhengjie
 * @date 2020/8/12 9:14 上午
 */
public class SplitterTest {

    public static void main(String[] args) {
        String filePath = "/Users/fanzhengjie/Downloads/123.csv";
        String resultPath = "/Users/fanzhengjie/Downloads/tmp/";

        System.out.println(String.format("%00s", 1));

        try {
            CsvReader csvReader = new CsvReader(filePath, ',', Charset.forName("UTF-8"));

           // csvReader.readHeaders(); // 跳过表头   如果需要表头的话，不要写这句。
           // String[] head = csvReader.getHeaders(); //获取表头
           // System.out.println(head.length);
            int i = 0;
            String fileName = "";
            CsvWriter csvWriter = null;
            while (csvReader.readRecord())
            {
                if(i % 200 == 0) {
                    fileName = resultPath + String.format("%00d") + ".csv";
                    csvWriter = new CsvWriter(fileName, ',', Charset.forName("UTF-8"));
                }

                String[] lines = csvReader.getRawRecord().split(",");
                csvWriter.writeRecord(lines);

                i++;

            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
