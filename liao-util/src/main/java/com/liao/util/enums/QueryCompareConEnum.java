/**
 * Zfounder.com Inc.
 * Copyright (c) 2013-2066 All Rights Reserved.
 */
package com.liao.util.enums;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 比较条件枚举
 *
 * @author Jonathan.Jin
 * @version $Id: QueryCompareConEnum.java, v 0.1 2017/5/1 13:10 Jonathan.Jin Exp $
 */
public enum QueryCompareConEnum implements TitleEnum {
    EQUAL("相等"),
    NOT_EQUAL("不相等"),

    GREAT_THAN("大于"),
    GREAT_OR_EQUAL("大于等于"),
    LESS_THAN("小于"),
    LESS_OR_EQUAL("小于等于"),

    LIKE_ANY("任何位置的模糊比较"),
    LIKE_START("前缀固定的模糊比较"),
    LIKE_END("后缀固定的模糊比较"),

    IN("集合条件比较"),

    NULL("null条件比较"),
    NOT_NULL("非null条件比较"),

    EQUAL_OR_NULL("null或等于条件比较"),
    NOT_EQUAL_OR_NOT_NULL("非null或不等于条件比较"),

    OR_LIKE_ANY("or连接多个key，每个key跟条件都是 %value% 比较"),
    OR_LIKE_START("or连接多个key，每个key跟条件都是 value% 比较"),
    OR_LIKE_END("or连接多个key，每个key跟条件都是 %value 比较"),
    OR_EQUAL("or连接多个key，每个key跟条件都是=比较"),;

    /** 展示中文表述  */
    private String title;

    private QueryCompareConEnum(String title) {
        this.title = title;
    }

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return QueryCompareConEnum        对应的枚举值
     */
    public static QueryCompareConEnum getByEnumName(final String enumName) {
        for (QueryCompareConEnum element : values()) {
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

        for (QueryCompareConEnum element : values()) {
            name2TitleMap.put(element.name(), element.title);
        }

        return name2TitleMap;
    }

}
