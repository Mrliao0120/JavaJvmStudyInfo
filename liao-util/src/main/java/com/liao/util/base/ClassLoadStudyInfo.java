package com.liao.util.base;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/6/15 16:40
 * @Version 1.0
 * @Description
 */
public class ClassLoadStudyInfo {



    private void  getTargetObject() throws ClassNotFoundException {
        //获取class对象
        Class<EnumInfo> enumInfoClass = EnumInfo.class;
        //通过路径获取
        Class<EnumInfo> aClass = (Class<EnumInfo>) Class.forName("com.liao.util.base.EnumInfo");
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> tagetClass = Class.forName("com.liao.util.base.TargetObject");
        /**
         * 获取TargetObject类的Class对象并且创建TargetObject类实例
         */
        TargetObject targetObject = (TargetObject) tagetClass.newInstance();
        /**
         * 获取所有方法
         */
        Method[] methods = tagetClass.getMethods();
        for (Method method: methods) {
            System.out.println(method.getName());
        }
        /**
         * 获取指定方法并调用
         */
        Method publicMethod = tagetClass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(targetObject,"JavaStudy");
        /**
         * 获取指定参数并对参数进行修改
         */
        Field value = tagetClass.getDeclaredField("value");
        value.setAccessible(false);
        value.set(targetObject,"Test");
        /**
         * 调用 private 方法
         */
        Method privateMethod = tagetClass.getDeclaredMethod("privateMethod");
        //为了调用private方法我们取消安全检查
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);

        /**
         * 反射机制优缺点
         优点： 运行期类型的判断，动态加载类，提高代码灵活度。
         缺点： 1,性能瓶颈：反射相当于一系列解释操作，通知 JVM 要做的事情，性能比直接的 java 代码要慢很多。
         2,安全问题，让我们可以动态操作改变类的属性同时也增加了类的安全隐患。
         Spring 框架的 IOC（动态加载管理 Bean）创建对象以及 AOP（动态代理）功能都和反射有联系；
         */
    }

}
