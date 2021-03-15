package com.liao.concurrency.conllen;

import java.util.*;
import java.util.concurrent.*;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2021/1/14 14:08
 * @Version 1.0
 * @Description
 */
public class collectionns {


    public static void main(String[] args) {
       /* List<Integer> linkedList=new LinkedList<>();
        Collection<Integer> integers = Collections.synchronizedCollection(linkedList);
        List<Integer> list = Collections.synchronizedList(linkedList);*/
      /*  BlockingQueue arrayBlockingQueue=new ArrayBlockingQueue(3,true);

        try {
            arrayBlockingQueue.put(1);
            arrayBlockingQueue.put(2);
            arrayBlockingQueue.put(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        arrayBlockingQueue.forEach(x->{
            System.out.println(x);
        });
*/
        /*CountDownLatch countDownLatch=new CountDownLatch(10);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

       /* ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.shutdown();
        executorService.shutdownNow();
        try {
            boolean b = executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //轮询是否关闭
        executorService.isTerminated();*/


        List  list=new LinkedList();
        list.add(1);
        list.remove(1);

    }




}
