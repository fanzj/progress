package com.jary.progress.common.io.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author fanzhengjie
 * @create 2018/9/9 上午9:29
 * @description
 */
public class DisDemo {

    public static void main(String[] args) throws IOException {
        String file = "/Users/fanzhengjie/IdeaProjects/daily/src/main/java/com/daily/demo/io/dos.dat";
        //IOUtil.printHex(file);

        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        int i = dis.readInt();
        System.out.println(i);
        i = dis.readInt();
        System.out.println(i);
        long l = dis.readLong();
        System.out.println(l);
        double d = dis.readDouble();
        System.out.println(d);
        String s = dis.readUTF();
        System.out.println(s);

        dis.close();

    }

}
