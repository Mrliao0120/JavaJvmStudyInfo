/**
 * Zfounder.com Inc.
 * Copyright (c) 2013-2066 All Rights Reserved.
 */
package com.liao.util.enums;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 唯一编码规则类型：用于控制唯一键生成，如 code 或 序列号等
 *
 * @author Jonathan.jin
 * @version $Id: IdentityRuleEnum.java, v 0.1 2017/3/4 14:59 Jonathan.jin Exp $
 */
public enum IdentityRuleEnum implements TitleEnum {

    /** 唯一编码规则类型：工单序列号产生规则 */
    WORK_PROCESS_SN("工单序列号产生规则"),

    /** 唯一编码规则类型：店铺编码规则 */
    SHOP_CODE("店铺编码规则"),

    /** 唯一编码规则类型：维修单序列号产生规则 */
    ORDER_SN("维修单序列号产生规则");

    private IdentityRuleEnum(final String title) {
        this.title = title;
    }

    private String title;

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return IdentityRuleEnum        对应的枚举值
     */
    public static IdentityRuleEnum getByEnumName(final String enumName) {
        for (IdentityRuleEnum element : values()) {
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

        for (IdentityRuleEnum element : values()) {
            name2TitleMap.put(element.name(),element.title);
        }

        return name2TitleMap;
    }

}
