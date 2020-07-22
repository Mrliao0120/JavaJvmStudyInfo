/**
 * Zfounder.com Inc.
 * Copyright (c) 2013-2066 All Rights Reserved.
 */
package com.liao.util.enums;



import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Jonathan.jin
 * @version $Id: PictureFolderTypeEnum.java, v 0.1 2017/3/5 15:51 Jonathan.jin Exp $
 */
public enum DeviceTypeEnum implements TitleEnum  {

    /**  设备类型：pc */
    PC("pc端访问"),

    /**  设备类型：微端 */
    MICRO("微端访问");

    /**
     * 展示中文表述
     */

    private String title;

    private DeviceTypeEnum(String title) {
        this.title = title;
    }

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return DeviceTypeEnum        对应的枚举值
     */
    public static DeviceTypeEnum getByEnumName(final String enumName) {
        for (DeviceTypeEnum element : values()) {
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

        for (DeviceTypeEnum element : values()) {
            name2TitleMap.put(element.name(),element.title);
        }

        return name2TitleMap;
    }

}
