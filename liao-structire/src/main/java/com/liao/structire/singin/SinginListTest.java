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
        singleOperation.inser(0,"0" );
        singleOperation.inser(1,"1" );
        singleOperation.inser(2,"2" );
        singleOperation.inser(3,"3" );
        singleOperation.delete(2 );
        Object o = singleOperation.get(2);
        System.out.println(o);
        System.out.println(singleOperation);
    }
}
