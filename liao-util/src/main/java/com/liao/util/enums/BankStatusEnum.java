/**
 * Zfounder.com Inc.
 * Copyright (c) 2013-2066 All Rights Reserved.
 */
package com.liao.util.enums;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 银行状态枚举。
 * 严谨的来说：应该是先配置通道（如 银联、支付宝、微信支付等），然后再进行通道银行配置（如支付宝后端支持的银行）
 *
 * @author Jonathan.jin
 * @version $Id: BankStatusEnum.java, v 0.1 2017/3/4 14:59 Jonathan.jin Exp $
 */
public enum BankStatusEnum implements TitleEnum {

    STRANGER("未合作"),

    PARTNER("合作已打通"),

    PENDING_PARTNER("合作未打通"),

    TOUCHING("正在谈合作"),


    ;


    private BankStatusEnum(final String title) {
        this.title = title;
    }

    private String title;

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return BankStatusEnum        对应的枚举值
     */
    public static BankStatusEnum getByEnumName(final String enumName) {
        for (BankStatusEnum element : values()) {
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

        for (BankStatusEnum element : values()) {
            name2TitleMap.put(element.name(),element.title);
        }

        return name2TitleMap;
    }

}
