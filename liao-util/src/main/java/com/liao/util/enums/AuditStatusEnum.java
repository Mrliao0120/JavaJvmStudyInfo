package com.liao.util.enums;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 *
 * @author Jonathan.jin
 * @version $Id: AuditStatusEnum.java, v 0.1 2017/5/15 23:48 Jonathan.jin Exp $
 */
public enum AuditStatusEnum implements TitleEnum {

    DRAFT("填写中"),

    AUDIT_WAIT("待审核"),

    AUDIT_FAILED("审核失败"),

    AUDIT_SUCCESS("审核成功");

    private AuditStatusEnum(final String title) {
        this.title = title;
    }

    private String title;

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return AuditStatusEnum        对应的枚举值
     */
    public static AuditStatusEnum getByEnumName(final String enumName) {
        for (AuditStatusEnum element : values()) {
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

        for (AuditStatusEnum element : values()) {
            name2TitleMap.put(element.name(), element.title);
        }

        return name2TitleMap;
    }

}
