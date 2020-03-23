package com.liao.design.bridge;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/3/23 14:11
 * @Version 1.0
 * @Description
 */
public class Desktop extends Computer {
    public Desktop(Brand brand) {
        super(brand);
    }


    @Override
    public void info() {
        super.info();
        System.out.print("台式机");
    }


    public static void main(String[] args) {
        Computer computer=new Desktop(new Apple());
        computer.info();
    }
}
