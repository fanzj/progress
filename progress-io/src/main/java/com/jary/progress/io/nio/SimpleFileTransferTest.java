package com.jary.progress.io.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author fanzhengjie
 * @create 2019/1/22 下午2:21
 * @description 测试一下使用NIO复制文件和传统IO复制文件的性能
 */
public class SimpleFileTransferTest {

    private long transferFile(File source, File des) throws IOException {
        long startTime = System.currentTimeMillis();

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try{
            if(!des.exists()){
                des.createNewFile();
            }

            bis = new BufferedInputStream(new FileInputStream(source));
            bos = new BufferedOutputStream(new FileOutputStream(des));

            //将数据源读到的内容写入目的地--使用数组
            byte[] bytes = new byte[1024 * 1024];
            int len;
            while ((len = bis.read(bytes))!=-1){
                bos.write(bytes,0,len);
            }
        }finally {
            if(bis != null){
                bis.close();
            }
            if(bos != null){
                bos.close();
            }
        }

        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    private long transferFileWithNIO(File source, File des) throws IOException {
        long startTime = System.currentTimeMillis();
        if(!des.exists()){
            des.createNewFile();
        }

        RandomAccessFile read = new RandomAccessFile(source, "rw");
        RandomAccessFile write = new RandomAccessFile(des, "rw");

        FileChannel readChannel = read.getChannel();
        FileChannel writeChannel = write.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);//1M缓冲区
        while(readChannel.read(byteBuffer) > 0){
            byteBuffer.flip();
            writeChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        writeChannel.close();
        readChannel.close();
        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    public static void main(String[] args) throws IOException {
        SimpleFileTransferTest simpleFileTransferTest = new SimpleFileTransferTest();
        File sourse = new File("/Users/fanzhengjie/Downloads/SecureCRT_8.3.3_xclient.info.dmg");
        File des = new File("/Users/fanzhengjie/Downloads/io.dmg");
        File nio = new File("/Users/fanzhengjie/Downloads/nio.dmg");

        long time = simpleFileTransferTest.transferFile(sourse, des);
        System.out.println(time + "：普通字节流时间");

        long timeNio = simpleFileTransferTest.transferFileWithNIO(sourse, nio);
        System.out.println(timeNio + "：NIO时间");


    }


}
