package com.liao.channel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/4/14 15:36
 * @Version 1.0
 * @Description
 */
public class FileChannelDemo {



    public  void  readFile(File file){
        try {
            RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rw");
            FileChannel channel = randomAccessFile.getChannel();
            ByteBuffer allocate = ByteBuffer.allocate(48);
            int reads = channel.read(allocate);
            while (reads!=-1){
                System.out.println("read Size"+reads);
                //一旦读到数据需要通过flip()方法将Buffer从写模式切换到读模式，在读模式下，可以读取之前写入到buffer的所有数据。
                //一旦读完了所有的数据，就需要清空缓冲区，让它可以再次被写入。有两种方式能清空缓冲区：调用clear()或
                // compact()方法。clear()方法会清空整个缓冲区。compact()方法只会清除已经读过的数据。
                // 任何未读的数据都被移到缓冲区的起始处，新写入的数据将放到缓冲区未读数据的后面。
                allocate.flip();
                while (allocate.hasRemaining()){
                    System.out.println((char) allocate.get());
                }
                allocate.compact();
                reads=channel.read(allocate);
                //mark()与reset()方法
                //通过调用Buffer.mark()方法，可以标记Buffer中的一个特定position。之后可以通过调用Buffer.reset()方法恢复到这个position。
            }

           // channel.read(allocate);
            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {
        FileChannelDemo  fileChannelDemo=new FileChannelDemo();
        File file=new File("D:\\使用说明.txt");
        fileChannelDemo.readFile(file);

    }


}
