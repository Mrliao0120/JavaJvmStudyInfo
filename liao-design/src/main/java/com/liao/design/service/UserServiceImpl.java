package com.liao.design.service;


import org.springframework.stereotype.Service;

/**
 * @author lhb
 * @Title: com.liao.design.service.UserServiceImpl
 * @ProjectName JavaJvmStudyInfo
 * @Description: for UserServiceImpl  handle
 * @Date create in 23:42 2020/3/22
 */
public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("添加了用户");
    }

    @Override
    public void updateUser() {
        System.out.println("更新了用户");
    }
}
