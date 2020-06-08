package com.liao.bean;

import com.liao.T2;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author lhb
 * @Title: com.liao.bean.MyFactoryPostProcessor
 * @ProjectName JavaJvmStudyInfo
 * @Description: for MyFactoryPostProcessor  handle
 * @Date create in 20:38 2020/6/7
 */
@Component
public class MyFactoryPostProcessor  implements BeanFactoryPostProcessor{
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyFactoryPostProcessor.postProcessBeanFactory");
        AbstractBeanDefinition t1 = (AbstractBeanDefinition) beanFactory.getBeanDefinition("T1");
        t1.setBeanClass(T2.class);
        System.out.println("MyFactoryPostProcessor.postProcessBeanFactory");
    }
}
