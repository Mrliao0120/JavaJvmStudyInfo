package com.liao.design.bridge;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/3/23 14:08
 * @Version 1.0
 * @Description
 */
public class Apple implements Brand {


    @Override
    public void info() {
        System.out.print("苹果");
    }
}
