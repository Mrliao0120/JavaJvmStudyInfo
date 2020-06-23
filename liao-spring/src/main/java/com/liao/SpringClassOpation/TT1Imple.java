package com.liao.SpringClassOpation;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.DispatcherServlet;

import java.lang.reflect.Proxy;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/6/13 10:09
 * @Version 1.0
 * @Description
 */
//@Component
public class TT1Imple implements FactoryBean<TT1> {

    public TT1Imple() {
        System.out.println("TT1Imple.TT1Imple");
    }

    //会返回到Spring容器中
    @Override
    public TT1 getObject() throws Exception {
        TT1 tt1=new TT1();
        tt1.setName("Liao");
        return tt1;
    }

    @Override
    public Class<?> getObjectType() {
        return TT1.class;
    }



}
