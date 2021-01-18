package com.liao.concurrency.conllen;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2021/1/18 15:38
 * @Version 1.0
 * @Description
 */
public class BoundHashSet<T> {

    private final Set<T>  set;

    private final Semaphore semaphore;

    public BoundHashSet(int bound){
        this.set= Collections.synchronizedSet(new HashSet<T>());
        this.semaphore=new Semaphore(bound);
    }

    public Boolean  add(T t){
        boolean wasAdd=false;
        try {
            //获得许可
            semaphore.acquire();
            set.add(t);
            return wasAdd;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (!wasAdd){
                semaphore.release();
            }
        }
        return wasAdd;
    }


    public boolean remove(Object o){
        boolean wasRemoved=set.remove(o);
        if (wasRemoved){
            semaphore.release();
        }
        return wasRemoved;
    }



}
