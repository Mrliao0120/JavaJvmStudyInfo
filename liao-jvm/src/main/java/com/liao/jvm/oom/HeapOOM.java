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
     * @param args
     */
    public static void main(String[] args) {
        List<OOMObject> list=new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }
    }

}
