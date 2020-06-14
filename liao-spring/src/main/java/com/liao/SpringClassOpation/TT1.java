package com.liao.SpringClassOpation;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/6/8 10:38
 * @Version 1.0
 * @Description
 */


public class TT1   {


    public TT1() {
        System.out.println("TT1.TT1  create");
    }



    private String  name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
