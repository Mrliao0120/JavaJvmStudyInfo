package com.liao.design.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author lhb
 * @Title: com.liao.design.proxy.UserProxyCGLIBHandler
 * @ProjectName JavaJvmStudyInfo
 * @Description: for UserProxyCGLIBHandler  handle
 * @Date create in 22:04 2020/6/8
 */
public class UserProxyCGLIBHandler implements MethodInterceptor {
    //obj 代理对象     method对象方法     args参数    proxy代理方法对象
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object result=null;
        System.out.println("准备开始添加用户了");
        result = proxy.invokeSuper(obj, args);
        System.out.println("添加好了么");
        return result;
    }
}
