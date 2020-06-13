package com.liao;

import com.liao.SpringClassOpation.TT1;
import com.liao.aop.LiaoAspect;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/5/30 15:12
 * @Version 1.0
 * @Description
 */
@ComponentScan(value = "com.liao.*")
@EnableAspectJAutoProxy
public class ApplicationTest {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext  ctx = new AnnotationConfigApplicationContext(ApplicationTest.class);
        TT1 bean = ctx.getBean(TT1.class);
        System.out.println(bean.getName());
    }
}
