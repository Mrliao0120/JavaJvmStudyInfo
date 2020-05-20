package com.liao;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/5/12 09:45
 * @Version 1.0
 * @Description
 */
public class T1 extends Thread{

    private static ReentrantLock reentrantLock=new ReentrantLock();

    private static   Condition condition = reentrantLock.newCondition();


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i==50){

                System.out.println("==========运行=======");

            }
            System.out.println(i);

        }

    }

    public static void main(String[] args) {
        T1 t1=new T1();
        t1.start();
        try {
            t1.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        FutureTask<String> futureTask=new FutureTask(new T2());
        Thread thread=new Thread(futureTask);
        thread.start();
        try {
            String s = futureTask.get();
            if ("k".equals(s)){
                t1.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }




}
