package com.liao.aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/6/2 14:40
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping(value = "/v1")
public class LiaoAspect {


    @RequestMapping(value = "/hello")
    public String hello(String s) {
        System.out.println(s);
        return s;
    }
}
