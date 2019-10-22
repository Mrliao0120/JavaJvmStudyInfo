package com.liao.concurrency.threadClass02;

import jdk.internal.dynalink.beans.StaticClass;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2019/8/21 10:07
 * @Version 1.0
 * @Description
 */
public class CompletionServiceThread {

    private  final ExecutorService excutor;

    private Lock lock=new ReentrantLock();

    CompletionServiceThread(ExecutorService excutor){
        this.excutor=excutor;
    }

    void   renderPage(CharSequence charSequence) throws ExecutionException {
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Date>info=new ArrayList<>();
        CompletionService<Date> completionService=new ExecutorCompletionService<Date>(excutor);
        for (Date date:info) {
            completionService.submit(new Callable<Date>() {
                @Override
                public Date call() throws Exception {
                    return new Date();
                }
            });
        }

            try {for (int i = 0; i < info.size(); i++) {
                Future<Date> take = completionService.take();
                Date date = take.get();

            }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


    }

}
