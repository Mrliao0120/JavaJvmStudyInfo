package com.liao.util.enums;



import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 系统部署环境
 *
 * Created by 13336 on 2017/3/31.
 */
public enum DeployEnvEnum implements TitleEnum {

    /** 系统部署环境：开发环境  */
    DEV("开发环境"),

    /** 系统部署环境：测试环境  */
    TEST("测试环境"),

    /** 系统部署环境：预发环境  */
    PREPARE("预发环境"),

    /** 系统部署环境：正式环境  */
    ONLINE("正式环境");

    /**
     * 展示中文表述
     */

    private String title;

    private DeployEnvEnum(String title) {
        this.title = title;
    }

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return DeployEnvEnum        对应的枚举值
     */
    public static DeployEnvEnum getByEnumName(final String enumName) {
        for (DeployEnvEnum element : values()) {
            if (element.name().equals(enumName)) {
                return element;
            }
        }
        return null;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    /**
     * 获取枚举名称和title所有的映射
     *
     * @return
     */
    public static Map<String,String> getName2TitleMap(){

        Map<String,String> name2TitleMap = new LinkedHashMap <>();

        for (DeployEnvEnum element : values()) {
            name2TitleMap.put(element.name(),element.title);
        }

        return name2TitleMap;
    }
}
