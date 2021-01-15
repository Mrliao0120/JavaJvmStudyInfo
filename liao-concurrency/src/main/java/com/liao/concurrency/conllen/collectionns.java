package com.liao.concurrency.conllen;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

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
        BlockingQueue arrayBlockingQueue=new ArrayBlockingQueue(3,true);

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




    }




}
