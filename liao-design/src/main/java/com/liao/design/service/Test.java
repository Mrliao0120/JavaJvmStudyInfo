package com.liao.design.service;

import com.liao.design.proxy.UserProxyCGLIBHandler;
import com.liao.design.proxy.UserProxyInvocationHandler;
import com.liao.design.service.UserService;
import com.liao.design.service.UserServiceImpl;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import org.apache.catalina.User;

import javax.swing.*;
import java.lang.reflect.Method;

/**
 * @author lhb
 * @Title: com.liao.design
 * @ProjectName JavaJvmStudyInfo
 * @Description: for Test  handle
 * @Date create in 23:52 2020/3/22
 */
public class Test {

    //jdktest
   /* public static void main(String[] args) {
        UserService userService=new UserServiceImpl();
        UserProxyInvocationHandler userProxyInvocationHandler=new  UserProxyInvocationHandler();
        userProxyInvocationHandler.setTarget(userService);
        UserService proxy = (UserService) userProxyInvocationHandler.getProxy();
        proxy.addUser();
    }*/


    public static void main(String[] args) {
        //生成的代理文件
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"c:\\Users\\liaohongbin\\Desktop");

        //创建enhancer对象  类似jdk代理的proxy类
        Enhancer enhancer=new Enhancer();
        //设置目标字节码文件
        enhancer.setSuperclass(UserServiceImpl.class);
        //设置回调函数
        enhancer.setCallback(new UserProxyCGLIBHandler());

        UserService userService = (UserService) enhancer.create();
        userService.addUser();
        userService.updateUser();
    }





}
