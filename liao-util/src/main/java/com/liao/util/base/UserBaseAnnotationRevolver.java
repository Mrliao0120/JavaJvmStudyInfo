package com.liao.util.base;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2019/10/26 09:27
 * @Version 1.0
 * @Description
 */
@Aspect
@Component
public class UserBaseAnnotationRevolver {

    @Pointcut(value = "execution (public * com.liao.util.*.*(..))")
    public void sexAnnotation(){
    }

    @Before(value = "sexAnnotation()")
    public void  beforeSexAnnotation(){

    }


}
