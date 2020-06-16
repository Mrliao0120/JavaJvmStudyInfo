package com.liao.util.base;

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

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> tagetClass = Class.forName("com.liao.util.base.TargetObject");
        /**
         * 获取TargetObject类的Class对象并且创建TargetObject类实例
         */
        TargetObject targetObject = (TargetObject) tagetClass.newInstance();


    }

}
