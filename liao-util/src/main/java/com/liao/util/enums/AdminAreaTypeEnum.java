package com.liao.util.enums;



import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by 13336 on 2017/3/31.
 */
public enum AdminAreaTypeEnum implements TitleEnum {

    /** 行政区划省市县区类型 */
    PROVINCE("省"),

    /** 行政区划市类型 */
    CITY("市"),

    /** 行政区划县区类型 */
    DISTRICT("县区");

    /**
     * 展示中文表述
     */

    private String title;

    private AdminAreaTypeEnum(String title) {
        this.title = title;
    }

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return AdminAreaTypeEnum        对应的枚举值
     */
    public static AdminAreaTypeEnum getByEnumName(final String enumName) {
        for (AdminAreaTypeEnum element : values()) {
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

        for (AdminAreaTypeEnum element : values()) {
            name2TitleMap.put(element.name(), element.title);
        }

        return name2TitleMap;
    }
}
