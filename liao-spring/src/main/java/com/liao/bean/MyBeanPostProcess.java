package com.liao.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author lhb
 * @Title: com.liao.bean.MyBeanPostProcess
 * @ProjectName JavaJvmStudyInfo
 * @Description: for MyBeanPostProcess  handle
 * @Date create in 20:27 2020/6/7
 */
//@Component
public class MyBeanPostProcess implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化之前增强-postProcessBeforeInitialization-"+beanName);
        return  bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化之后增强-postProcessBeforeInitialization-"+beanName);
        return bean;
    }
}
