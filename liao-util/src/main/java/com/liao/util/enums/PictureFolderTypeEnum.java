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
public enum PictureFolderTypeEnum implements TitleEnum  {

    /**  图片文件夹类型：临时图片 */
    TMP("临时图片"),

    /**  图片文件夹类型：原图片 */
    ORG("原图片"),

    /**  图片文件夹类型：缩略图片 */
    THUMBNAIL("缩略图片");

    /**
     * 展示中文表述
     */

    private String title;

    private PictureFolderTypeEnum(String title) {
        this.title = title;
    }

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return PictureFolderTypeEnum        对应的枚举值
     */
    public static PictureFolderTypeEnum getByEnumName(final String enumName) {
        for (PictureFolderTypeEnum element : values()) {
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

        for (PictureFolderTypeEnum element : values()) {
            name2TitleMap.put(element.name(),element.title);
        }

        return name2TitleMap;
    }

}
