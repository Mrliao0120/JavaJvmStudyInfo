package com.liao.jvm.model;

import com.liao.jvm.LiaoJvmApplication;
import lombok.Data;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2019/8/12 15:12
 * @Version 1.0
 * @Description
 */
@Data
public class OOMObject {

    public static void main(String[] args) {
        OOMObject oomObject=new OOMObject();
        ClassLoader classLoader = oomObject.getClass().getClassLoader();
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getClass());
        ClassLoader classLoader1 = String.class.getClassLoader();
        //系统类加载器
        System.out.println(classLoader1.getSystemClassLoader());
    }

}
