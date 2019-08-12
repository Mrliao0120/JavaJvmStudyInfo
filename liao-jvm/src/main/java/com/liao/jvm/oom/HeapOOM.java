package com.liao.jvm.oom;

import com.liao.jvm.model.OOMObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2019/8/12 15:09
 * @Version 1.0
 * @Description
 */
public class HeapOOM {


    /**
     * vm args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     * Description:  -Xms20m  堆大小 -Xmx20m 避免自动扩展 -XX:+HeapDumpOnOutOfMemoryError  出现异常内存堆换存储快照
     * @param args
     */
    public static void main(String[] args) {
        List<OOMObject> list=new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }
    }

}
