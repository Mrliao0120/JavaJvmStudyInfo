package com.liao.util.enums;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 *
 * @author Jonathan.jin
 * @version $Id: AuditStatusEnum.java, v 0.1 2017/5/15 23:48 Jonathan.jin Exp $
 */
public enum PostageEnum implements TitleEnum {

    BILATERAL_AGREEMENT("双方协议"),

    FREE_SHIPPING("包邮"),

    POSTAGE_PAID("邮费到付");

    private PostageEnum(final String title) {
        this.title = title;
    }

    private String title;

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return AuditStatusEnum        对应的枚举值
     */
    public static PostageEnum getByEnumName(final String enumName) {
        for (PostageEnum element : values()) {
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
    public static Map<String, String> getName2TitleMap() {

        Map<String, String> name2TitleMap = new LinkedHashMap<>();

        for (PostageEnum element : values()) {
            name2TitleMap.put(element.name(), element.title);
        }

        return name2TitleMap;
    }

}
