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
 * @version $Id: BankStatusEnum.java, v 0.1 2017/3/4 14:59 Jonathan.jin Exp $
 */
public enum BankCardTypeEnum implements TitleEnum {

    CREDIT("贷记卡"),

    DEBIT("借记卡"),

    MIX("借贷不分"),

    ;


    private BankCardTypeEnum(final String title) {
        this.title = title;
    }

    private String title;

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return BankCardTypeEnum        对应的枚举值
     */
    public static BankCardTypeEnum getByEnumName(final String enumName) {
        for (BankCardTypeEnum element : values()) {
            if (element.name().equals(enumName)) {
                return element;
            }
        }
        return null;
    }

    @Override
    public String getTitle() {
        return title;
    }

    /**
     * 获取枚举名称和title所有的映射
     *
     * @return
     */
    public static Map<String,String> getName2TitleMap(){

        Map<String,String> name2TitleMap = new LinkedHashMap <>();

        for (BankCardTypeEnum element : values()) {
            name2TitleMap.put(element.name(),element.title);
        }

        return name2TitleMap;
    }

}
