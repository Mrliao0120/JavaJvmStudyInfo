package com.liao.concurrency.container;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

import static com.liao.concurrency.container.ConcurrentHashMapTest.concurrentHashMap;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/6/17 09:08
 * @Version 1.0
 * @Description
 */
public class ThreadTest{





    public static void main(String[] args) {
        BlockingQueue blockingQueue=new ArrayBlockingQueue(10,true);
        for (int i = 0; i < 11; i++) {
            blockingQueue.add(i);
        }

        blockingQueue.forEach(x->{
            System.out.println(x.toString());
        });



     /*   Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                concurrentHashMap.put("1","2");
                concurrentHashMap.put("2","2");
                concurrentHashMap.put("3","2");
            }
        });
        thread.start();

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                Object o = concurrentHashMap.get("1");
                System.out.println(o);
                concurrentHashMap.remove("1");

            }
        });
        thread1.start();*/
    }



}
