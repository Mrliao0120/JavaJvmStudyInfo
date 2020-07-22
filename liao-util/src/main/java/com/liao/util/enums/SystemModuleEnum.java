/**
 * Zfounder.com Inc.
 * Copyright (c) 2013-2066 All Rights Reserved.
 */
package com.liao.util.enums;



import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Jonathan.jin
 * @version $Id: SystemModuleEnum.java, v 0.1 2017/3/5 15:51 Jonathan.jin Exp $
 */
public enum SystemModuleEnum implements TitleEnum {

    /**  系统模块：租户 */
    TENANT("租户模块"),

    /**  系统模块：租户用户模块 */
    TENANT_USER("租户用户模块"),

    ;

    /**
     * 展示中文表述
     */

    private String title;

    private SystemModuleEnum(String title) {
        this.title = title;
    }

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return SystemModuleEnum        对应的枚举值
     */
    public static SystemModuleEnum getByEnumName(final String enumName) {
        for (SystemModuleEnum element : values()) {
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

        Map<String,String> name2TitleMap = new LinkedHashMap<>();

        for (SystemModuleEnum element : values()) {
            name2TitleMap.put(element.name(),element.title);
        }

        return name2TitleMap;
    }



}
