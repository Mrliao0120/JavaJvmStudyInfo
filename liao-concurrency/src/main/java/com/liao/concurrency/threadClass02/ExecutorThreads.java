package com.liao.concurrency.threadClass02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2019/8/21 09:29
 * @Version 1.0
 * @Description
 */
public class ExecutorThreads  implements Executor{
    //newFixedThreadPool 将创建一个固定长度的线程池，每当提交一个任务时就创建一个线程，直到达到线程池的最大数量，这时线程池的规模将不再变化
    // （如果某个线程由于发生未知Exception而结束，那么线程池会补充一个新线程）
    private static final Executor exec= Executors.newFixedThreadPool(100);

    private static final ExecutorService exec02= Executors.newFixedThreadPool(100);

    //为每个web开启一个socket链接
    private void ThreadTest() throws IOException {
        ServerSocket serverSocket=new ServerSocket(80);
        while (true){
            final Socket connection=serverSocket.accept();
            Runnable task=new Runnable() {
                @Override
                public void run() {
                    System.out.println(connection);
                }
            };
            exec.execute(task);
        }
    }


    /**
     *  实现了Executor   每个请求都会开启一个新线程
     * @param command
     */
    @Override
    public void execute(Runnable command) {
            new Thread(command).start();
    }
}
