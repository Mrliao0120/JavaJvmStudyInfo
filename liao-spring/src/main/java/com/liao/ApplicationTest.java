package com.liao;

import com.liao.aop.LiaoAspect;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

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
        LiaoAspect bean = ctx.getBean(LiaoAspect.class);
        bean.hello("1");

    }
}
