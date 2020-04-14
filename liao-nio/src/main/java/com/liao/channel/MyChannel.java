package com.liao.channel;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author lhb
 * @Title: com.liao.channel.MyChannel
 * @ProjectName JavaJvmStudyInfo
 * @Description: for MyChannel  handle
 * @Date create in 21:59 2020/4/13
 */
public class MyChannel {



    public static void main(String[] args) {
        try {
            //分配缓冲区
            ByteBuffer allocate = ByteBuffer.allocate(1024);
            RandomAccessFile randomAccessFile=new RandomAccessFile("test","rw");
            //渠道
            FileChannel channel = randomAccessFile.getChannel();
            channel.write(allocate);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

}
