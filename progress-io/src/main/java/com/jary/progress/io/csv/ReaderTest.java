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
public class ReaderTest {

    public static void main(String[] args) {
        String filePath = "/Users/fanzhengjie/Downloads/123.csv";
        String resultPath = "";

        try {
            CsvReader csvReader = new CsvReader(filePath, ',', Charset.forName("UTF-8"));

           // csvReader.readHeaders(); // 跳过表头   如果需要表头的话，不要写这句。
           // String[] head = csvReader.getHeaders(); //获取表头
           // System.out.println(head.length);
            String sql = "select * from mem_bill where mem_id in (%s) and biz_no in (%s) and biz_type = 'WITHDRAW'";
            List<String> memIds = Lists.newArrayList();
            List<String> orderNos = Lists.newArrayList();
            int i = 0;
            while (csvReader.readRecord() && i < 200)
            {
                String[] lines = csvReader.getRawRecord().split(",");
                memIds.add("'"+lines[0]+"'");
                orderNos.add("'"+lines[1]+"'");
                i++;
            }
            System.out.println(memIds.size());
            String memIdStr = Joiner.on(',').join(memIds);
            String orderNoStr = Joiner.on(',').join(orderNos);
            System.out.println(String.format(sql, memIdStr, orderNoStr ));
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
