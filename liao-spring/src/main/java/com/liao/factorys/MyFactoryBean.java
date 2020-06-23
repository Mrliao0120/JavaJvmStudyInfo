package com.liao.factorys;

import com.liao.SpringClassOpation.TT1;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/6/23 15:44
 * @Version 1.0
 * @Description
 */
@Component
public class MyFactoryBean implements FactoryBean<TT1> {

    @Override
    public TT1 getObject() throws Exception {
        TT1  tt1=new TT1();
        tt1.setName("test");
        return tt1;
    }

    @Override
    public Class<?> getObjectType() {
        return TT1.class;
    }
}
