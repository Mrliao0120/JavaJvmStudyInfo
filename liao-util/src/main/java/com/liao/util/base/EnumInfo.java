package com.liao.util.base;

import com.liao.util.enums.UserEnum;

import java.util.EnumSet;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/6/15 16:12
 * @Version 1.0
 * @Description
 */
public class EnumInfo {


    public static void main(String[] args) {
        UserEnum[] values = UserEnum.values();
        for (UserEnum userEnum:values) {
            System.out.println(userEnum);
        }

        EnumSet<UserEnum> generalUser = EnumSet.of(UserEnum.GENERAL_USER, UserEnum.SYSTEM_USER);
        generalUser.forEach(x->{
            System.out.println(x);
        });

    }







}
