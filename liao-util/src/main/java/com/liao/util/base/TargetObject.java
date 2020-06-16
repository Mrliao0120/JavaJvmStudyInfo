package com.liao.util.base;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/6/15 16:48
 * @Version 1.0
 * @Description
 */
public class TargetObject {

    private Integer i;

    public TargetObject(Integer i) {
        this.i = 1;
    }


    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + i);
    }
}
