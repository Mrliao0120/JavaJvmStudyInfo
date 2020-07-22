package com.liao.util.enums;



import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by mu.jie on 2017/7/15.
 */
public enum FileTypeEnum implements TitleEnum {

    EXCEL("excel表格"),

    DOCUMENT("Word和pdf文档"),

    MOVIE("Film"),

    MUSIC("Music");

    /*
     * 展示中文表述
     */

    private String title;

    FileTypeEnum(String title) {
        this.title = title;
    }

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName 枚举名称
     */
    public static FileTypeEnum getByEnumName(final String enumName) {
        for (FileTypeEnum element : values()) {
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
    public static Map<String, String> getName2TitleMap() {

        Map<String, String> name2TitleMap = new LinkedHashMap<>();

        for (FileTypeEnum element : values()) {
            name2TitleMap.put(element.name(), element.title);
        }

        return name2TitleMap;
    }
}
