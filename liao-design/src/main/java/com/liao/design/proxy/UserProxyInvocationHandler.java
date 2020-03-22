package com.liao.design.proxy;

import java.lang.reflect.*;

/**
 * @author lhb
 * @Title: com.liao.design.proxy.UserProxyInvocationHandler
 * @ProjectName JavaJvmStudyInfo
 * @Description: for UserProxyInvocationHandler  handle 代理实例
 * @Date create in 23:44 2020/3/22
 */
public class UserProxyInvocationHandler implements InvocationHandler {

    //需要被代理的实例
    private Object  target;

    public void setTarget(Object target) {
        this.target = target;
    }

    //获取代理实例  比如UserService
    public Object  getProxy(){
        return  Proxy.newProxyInstance(this.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
    }


    //处理代理逻辑  并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object invoke = method.invoke(target, args);
        AnnotatedType annotatedReturnType = method.getAnnotatedReturnType();
        Type type = annotatedReturnType.getType();
        type.getTypeName();
        return invoke;
    }
}
