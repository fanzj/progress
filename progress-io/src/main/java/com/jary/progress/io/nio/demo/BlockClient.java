package com.jary.progress.io.nio.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author fanzhengjie
 * @create 2019/1/23 上午10:33
 * @description NIO在网络中是阻塞的状态代码
 * 客户端
 */
public class BlockClient {

    private static final String ROOT_PATH = "/Users/fanzhengjie/Downloads/";

    public static void main(String[] args) throws IOException{
        //1.获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 6666));

        //2.发送一张图片给服务端
        FileChannel fileChannel = FileChannel.open(Paths.get(ROOT_PATH + "image2018-6-13 17_0_56.png"),
            StandardOpenOption.READ);

        //3.要使用NIO，有了Channel，就必然要有Buffer，Buffer是与数据打交道的呢
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 4.读取本地文件(图片)，发送到服务器
        while(fileChannel.read(byteBuffer) != -1){
            // 在读之前都要切换成读模式
            byteBuffer.flip();

            socketChannel.write(byteBuffer);

            //读完切换成写模式，能让管道继续读取文件的数据
            byteBuffer.clear();
        }

        //告诉服务器已经写完了
        socketChannel.shutdownOutput();

        int len = 0;
        while((len = socketChannel.read(byteBuffer)) != -1){
            //切换读模式
            byteBuffer.flip();

            System.out.println(new String(byteBuffer.array(),0,len));

            //切换写模式
            byteBuffer.clear();
        }

        //5.关闭流
        socketChannel.close();
        fileChannel.close();

    }
}
