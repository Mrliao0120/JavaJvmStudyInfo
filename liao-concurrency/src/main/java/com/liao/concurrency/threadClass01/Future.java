package com.liao.concurrency.threadClass01;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2019/8/20 10:01
 * @Version 1.0
 * @Description
 */
public interface Future<V> {

    boolean cancel(boolean mayInterruptIfRunning);

    boolean isCancalled();

    boolean isDone();

    V get() throws InterruptedException,ExecutionException,CancellationException;

    V get(long timeout, TimeUnit unit)throws InterruptedException,ExecutionException,CancellationException,TimeoutException;



}
