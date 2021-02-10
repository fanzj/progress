package com.jary.progress.io.nio;

import java.nio.ByteBuffer;

/**
 * @author fanzhengjie
 * @create 2018/9/5 下午5:16
 * @description
 */
public class ByteBufferTest {

    public static void main(String[] args) {
        String str = "helloWorld";
        ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());
        System.out.println("position:"+byteBuffer.position()+"\t limit:"+byteBuffer.limit());

        //读取两个字节
        byteBuffer.get();
        byteBuffer.get();
        System.out.println("position:"+byteBuffer.position()+"\t limit:"+byteBuffer.limit());

        byteBuffer.mark();
        System.out.println("position:"+byteBuffer.position()+"\t limit:"+byteBuffer.limit());

        byteBuffer.flip();
        System.out.println("position:"+byteBuffer.position()+"\t limit:"+byteBuffer.limit());
    }

}
