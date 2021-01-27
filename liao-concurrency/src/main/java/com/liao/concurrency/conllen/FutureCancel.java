package com.liao.concurrency.conllen;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2021/1/26 11:26
 * @Version 1.0
 * @Description
 */
public class FutureCancel extends ThreadPoolExecutor{

   private static ExecutorService executorService= Executors.newCachedThreadPool();
    private static final AtomicBoolean  ifdelete=new AtomicBoolean(false);
  private static ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(
           10,
           100,
           200L,
           TimeUnit.MINUTES,
           new LinkedBlockingQueue(),
           new ThreadPoolExecutor.CallerRunsPolicy());

    public FutureCancel(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public  static  void  timeRun(Runnable runnable){

        Future<?> submit = executorService.submit(runnable);

        try {
            Object o = submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            submit.cancel(true);
        }


        //System.identityHashCode();
    }

    public    void  timeRuns(Runnable runnable,Throwable throwable){
        //扩展
       super.afterExecute(runnable,throwable);

        super.beforeExecute(new Thread(),runnable);


        super.terminated();
    }

//修车  用车  租车
}
