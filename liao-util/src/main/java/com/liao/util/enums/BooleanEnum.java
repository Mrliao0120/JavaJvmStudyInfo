package com.liao.util.enums;



import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Jonathan on 2017/5/5.
 */
public enum BooleanEnum implements TitleEnum  {

    /** 布尔：YES */
    YES("是"),

    /** 布尔：NO */
    NO("否");

    /**
     * 展示中文表述
     */

    private String title;

    private BooleanEnum(String title) {
        this.title = title;
    }

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return GenderEnum        对应的枚举值
     */
    public static BooleanEnum getByEnumName(final String enumName) {
        for (BooleanEnum element : values()) {
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

        for (BooleanEnum element : values()) {
            name2TitleMap.put(element.name(),element.title);
        }

        return name2TitleMap;
    }
}
