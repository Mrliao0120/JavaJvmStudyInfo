package com.liao.jvm.oom;

import com.liao.jvm.model.OOMObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2019/8/12 15:09
 * @Version 1.0
 * @Description  单线程操作
 */
public class JavaVMStackSOF {

    private int stackLength=1;

    /**
     * vm args:  -Xss:128k  减少栈内存容量。
     */
    private void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF=new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        }catch (Throwable throwable){
            System.out.println("stack lenght:"+javaVMStackSOF.stackLength);
            throw  throwable;
        }

    }

}
