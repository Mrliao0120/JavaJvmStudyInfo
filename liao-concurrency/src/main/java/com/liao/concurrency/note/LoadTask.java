package com.liao.concurrency.note;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2021/1/7 14:46
 * @Version 1.0
 * @Description
 */
public class LoadTask {



    public  int loadTask(Collection<Thread> candidates){
        SortedSet<Thread> sortedSet;
        int numPairs=0;
        Thread thread=new Thread();

        sortedSet=new TreeSet<>();

        sortedSet.add(thread);
        for (Thread thread1:sortedSet){
            ++numPairs;
            thread1.start();
        }
        return numPairs;
    }




}
