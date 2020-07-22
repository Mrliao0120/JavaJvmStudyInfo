/**
 * Zfounder.com Inc.
 * Copyright (c) 2013-2066 All Rights Reserved.
 */
package com.liao.util.enums;



import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Jonathan.jin
 * @version $Id: PictureOwnerEnum.java, v 0.1 2017/4/27 23:30 Jonathan.jin Exp $
 */
public enum PictureOwnerEnum  implements TitleEnum {

    /**  图片属主：LOGO */
    LOGO("LOGO")  ;

    /**
     * 展示中文表述
     */

    private String title;

    private PictureOwnerEnum(String title) {
        this.title = title;
    }

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return PictureOwnerEnum        对应的枚举值
     */
    public static PictureOwnerEnum getByEnumName(final String enumName) {
        for (PictureOwnerEnum element : values()) {
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

        for (PictureOwnerEnum element : values()) {
            name2TitleMap.put(element.name(),element.title);
        }

        return name2TitleMap;
    }

}