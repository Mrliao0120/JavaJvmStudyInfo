package com.liao.util.arithmetic;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lhb
 * @Title: com.liao.util.arithmetic.GreedArithmetic
 * @ProjectName JavaJvmStudyInfo
 * @Description: for GreedArithmetic  handle
 * @Date create in 20:24 2020/3/6
 */
public class GreedArithmetic {


    //贪心算法


//题目：1.已知一些孩子和一些糖果，每个孩子有需求因子g，每个糖果有大小s，当某个糖果的大小s>=某个孩子的需求因子g时，
// 代表该糖果可以满足该孩子，求使用这些糖果，最多能满足多少孩子（注意，某个孩子最多只能用1个糖果满足）
    public static void main(String[] args) {
        //2
        Integer[]c={5,7,2,4};
        Integer[]s={6,3,4};
        int sort = sort(c,s);
        System.out.println(sort);
    }

    /**
     *
     * @param c 孩子需求量大小
     * @param s  大小
     * @return
     */
    public static int  sort(Integer[]c,Integer[]s){
        int count=0;


        //O(log)n
        Arrays.sort(c,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o2>o1){
                    return 1;
                }else {
                    return -1;
                }
            }
        });
        Arrays.sort(s,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o2>o1){
                    return 1;
                }else {
                    return -1;
                }
            }
        });


        //O(n)级别
        int j=0;
        for (int i = 0; i < s.length; ) {
            if (s[i]>=c[j]){
                i++;
                count++;
            }else {
                j++;
            }
        }
        return count;
    }


    //2.给定两个字符串s和t,问s是不是t的子序列；
    public static  Boolean  sortString(String s,String  t){
        boolean  isSon=false;
        char[] charS = s.toCharArray();
        char[] charsT = t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charsT);
        //s  ->t
        int a=0;
        int j=0;
        for (int i = 0; i < charS.length; i++) {
                if (charS[i]==charsT[j]){
                    a++;
                }else {
                    i--;
                    j++;
                }
        }
        if (a>=charS.length){
            isSon=true;
            return isSon;
        }
        return isSon;
    }


    class MyCompara implements Comparator<Integer> {
        public int compare(Integer o1, Integer o2) {
            //倒序前一个小于后一个返回正值就可实现，如果是要正序就是前一个大于后一个就返回正值
            if (o1 < o2) {
                return 1;
            } else if (o1 > o2) {
                return -1;
            } else {
                return 0;
            }
        }


    }
}
