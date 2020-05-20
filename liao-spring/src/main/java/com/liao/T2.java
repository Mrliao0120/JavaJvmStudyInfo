package com.liao;

import java.util.concurrent.Callable;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/5/12 09:45
 * @Version 1.0
 * @Description
 */
public class T2   implements Callable<String>{



    @Override
    public String call() throws Exception {
        System.out.println("线程2执行完毕，现在回调给线程1");
        return "k";
    }





}
