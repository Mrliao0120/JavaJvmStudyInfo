package com.liao.SpringClassOpation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/6/13 15:03
 * @Version 1.0
 * @Description
 */
@Component
public class T3 {

    @Autowired
    T4 t4;
}
