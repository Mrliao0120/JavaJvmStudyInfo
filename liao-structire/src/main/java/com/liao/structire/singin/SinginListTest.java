package com.liao.structire.singin;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/6/15 10:18
 * @Version 1.0
 * @Description
 */
public class SinginListTest {

    public static void main(String[] args) {
        SingleOperation singleOperation=new SingleOperation();
        singleOperation.add(0);
        singleOperation.add(1);
        singleOperation.add(2);
        singleOperation.add(3);
        singleOperation.add(4);
        singleOperation.delete(4);
        System.out.println(singleOperation);
    }
}
