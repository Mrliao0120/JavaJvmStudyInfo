package com.liao.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/6/1 15:36
 * @Version 1.0
 * @Description
 */

@Slf4j
@Aspect
@Component
public class UserAspect {



    @Pointcut("execution(* com.liao.aop.*.*(..))")
    public void  pointcut(){


    }


    @Before( "pointcut()")
    public void  before(){
        log.info("=========before=========");
    }


    @After( "pointcut()")
    public void  after(){
        log.info("========after==========");
    }


}
