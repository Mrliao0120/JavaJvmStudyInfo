package com.liao.util.base;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/6/15 15:10
 * @Version 1.0
 * @Description
 */
public class JavaBaseInfo {


    /**
     * 推荐使用Objects.equals
     * @param o1
     * @param o2
     * @return
     */
    public Boolean equals(Object o1,Object o2){
        boolean equals = Objects.equals(o1, o2);
        return equals;
    }


    /**
     * 当使用自动装箱方式创建一个Integer对象时，当数值在-128 ~127时，会将创建的 Integer 对象缓存起来，
     * 当下次再出现该数值时，直接从缓存中取出对应的Integer对象。
     * 所以上述代码中，x和y引用的是相同的Integer对象。
     */
    public void  packageEquals(){
        Integer x = 3;
        Integer y = 3;
        System.out.println(x == y);// true
        Integer a = new Integer(3);
        Integer b = new Integer(3);
        System.out.println(a == b);//false
        System.out.println(a.equals(b));//true

    }


    /**
     * 返回 -1 表示小于，0 表示 等于， 1表示 大于。
     * @param b1
     * @param b2
     * @return
     */
    public int compartTo(BigDecimal b1,BigDecimal b2){
        //通过 setScale方法设置保留几位小数以及保留规则
        BigDecimal m = new BigDecimal("1.255433");
        BigDecimal n = m.setScale(3,BigDecimal.ROUND_HALF_DOWN);
        System.out.println(n);// 1.255

        //推荐使用String 为BigDecimal的构造方法

        int i = b1.compareTo(b2);
        return i;
    }


    /**
     *
     */
    public void  ArrayList(){
        String[] myArray = { "Apple", "Banana", "Orange" };
        List<String> myList = Arrays.asList(myArray);
//上面两个语句等价于下面一条语句
        List<String> myList1 = Arrays.asList("Apple","Banana", "Orange");
        String[] objects = (String[]) myList1.toArray();
        System.out.println(objects);
        ///** JDK 源码对于这个方法的说明
        // *返回由指定数组支持的固定大小的列表。此方法作为基于数组和基于集合的API之间的桥梁，
        // 与Collection.toArray()结合使用。返回的List是可序列化并实现RandomAccess接口。
        // */
        //public static <T> List<T> asList(T... a) {
        //    return new ArrayList<>(a);
        //}
    }







}
