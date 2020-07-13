package com.liao.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @author lhb
 * @Title: com.liao.aware.Red
 * @ProjectName JavaJvmStudyInfo
 * @Description: for Red  handle
 * @Date create in 20:28 2020/6/30
 */
@Component
public class Red implements ApplicationContextAware,BeanNameAware,EmbeddedValueResolverAware {

    private ApplicationContext applicationContext;

    /**
     * ApplicationContextAware
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("IOC:"+applicationContext);
        this.applicationContext=applicationContext;
    }

    /**
     * BeanNameAware
     * @param name
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("Red.setBeanName:"+name);
    }

    /**
     * EmbeddedValueResolverAware
     * @param resolver
     */
    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        System.out.println("解析${name}类型字符串");
    }
}
