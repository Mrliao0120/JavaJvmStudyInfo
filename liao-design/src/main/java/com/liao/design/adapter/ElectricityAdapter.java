package com.liao.design.adapter;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/3/24 14:29
 * @Version 1.0
 * @Description
 */
public class ElectricityAdapter  implements Voltage5V{


    private Voltag220V voltag220V;


    public ElectricityAdapter(Voltag220V voltag220V) {
        this.voltag220V = voltag220V;
    }

    @Override
    public void get5v() {
        int i = voltag220V.outPut220V();
        int i1 = i / 44;
        System.out.println("装换为:"+i1+"V");
    }


    public static void main(String[] args) {
        Voltage5V v=new ElectricityAdapter(new Voltag220V());
        v.get5v();
    }

}
