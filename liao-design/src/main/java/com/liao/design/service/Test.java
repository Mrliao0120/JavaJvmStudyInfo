package com.liao.design.service;

import com.liao.design.proxy.UserProxyInvocationHandler;
import com.liao.design.service.UserService;
import com.liao.design.service.UserServiceImpl;
import org.apache.catalina.User;

import java.lang.reflect.Method;

/**
 * @author lhb
 * @Title: com.liao.design
 * @ProjectName JavaJvmStudyInfo
 * @Description: for Test  handle
 * @Date create in 23:52 2020/3/22
 */
public class Test {


    public static void main(String[] args) {
        UserService userService=new UserServiceImpl();
        UserProxyInvocationHandler userProxyInvocationHandler=new  UserProxyInvocationHandler();
        userProxyInvocationHandler.setTarget(userService);
        UserService proxy = (UserService) userProxyInvocationHandler.getProxy();
        proxy.addUser();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


    public void   javaMethod(){
        Method[] methods = Test.class.getMethods();
    }
}
