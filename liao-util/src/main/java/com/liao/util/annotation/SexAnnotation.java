package com.liao.util.annotation;

import java.lang.annotation.*;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2019/10/25 14:50
 * @Version 1.0
 * @Description
 */
//@Target(value = ElementType.TYPE)
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SexAnnotation {


    String  userName() default "";
}
