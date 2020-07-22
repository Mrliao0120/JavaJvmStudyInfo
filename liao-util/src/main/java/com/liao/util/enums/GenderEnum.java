package com.liao.util.enums;



import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 性别
 *
 * Created by 13336 on 2017/3/31.
 */
public enum GenderEnum implements TitleEnum {

    /** 性别：保密 */
    SECRET("保密"),

    /** 性别：男 */
    MALE("男"),

    /** 性别：女 */
    FEMALE("女");

    /**
     * 展示中文表述
     */

    private String title;

    private GenderEnum(String title) {
        this.title = title;
    }

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return GenderEnum        对应的枚举值
     */
    public static GenderEnum getByEnumName(final String enumName) {
        for (GenderEnum element : values()) {
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

        for (GenderEnum element : values()) {
            name2TitleMap.put(element.name(),element.title);
        }

        return name2TitleMap;
    }
}
