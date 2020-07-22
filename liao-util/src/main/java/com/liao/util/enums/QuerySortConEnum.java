/**
 * Zfounder.com Inc.
 * Copyright (c) 2013-2066 All Rights Reserved.
 */
package com.liao.util.enums;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询排序条件枚举
 *
 * @author Jonathan.Jin
 * @version $Id: QuerySortConEnum.java, v 0.1 2017/5/1 13:11 Jonathan.Jin Exp $
 */
public enum QuerySortConEnum implements TitleEnum {

    /**  排序条件：降序 */
    DESC("降序"),

    /**  排序条件：升序 */
    ASC("升序");

    /** 展示中文表述 */
    private String title;

    private QuerySortConEnum(String title) {
        this.title = title;
    }

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return QuerySortConEnum        对应的枚举值
     */
    public static QuerySortConEnum getByEnumName(final String enumName) {
        for (QuerySortConEnum element : values()) {
            if (element.name().equals(enumName)) {
                return element;
            }
        }
        return ASC;
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

        for (QuerySortConEnum element : values()) {
            name2TitleMap.put(element.name(), element.title);
        }

        return name2TitleMap;
    }

}
