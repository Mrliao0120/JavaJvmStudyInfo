package com.liao.design.bridge;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/3/23 14:09
 * @Version 1.0
 * @Description  可以抽象出来
 */
public abstract class Computer {


    private Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }

    public  void  info(){
        brand.info();
    }




}
