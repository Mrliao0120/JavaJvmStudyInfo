package com.liao.SpringClassOpation;

import com.liao.LiaoSpringApplication;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/5/30 15:12
 * @Version 1.0
 * @Description
 */
public class ApplicationTest {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext  ctx = new AnnotationConfigApplicationContext();

        ctx.register(LiaoSpringApplication.class);
        ctx.refresh();
        LiaoSpringApplication liaoSpringApplication = (LiaoSpringApplication)ctx.getBean("liaoSpringApplication");
        System.out.println("=========="+liaoSpringApplication.getClass().getCanonicalName());

    }
}
