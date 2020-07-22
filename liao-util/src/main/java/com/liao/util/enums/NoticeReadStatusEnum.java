package com.liao.util.enums;



import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 通知阅读状态
 *
 * Created by 13336 on 2017/3/31.
 */
public enum NoticeReadStatusEnum implements TitleEnum {

    /** 通知阅读状态：已阅  */
    READ("已阅"),

    /** 通知阅读状态：未阅  */
    UNREAD("未阅");

    /**
     * 展示中文表述
     */

    private String title;

    private NoticeReadStatusEnum(String title) {
        this.title = title;
    }

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return NoticeReadStatusEnum        对应的枚举值
     */
    public static NoticeReadStatusEnum getByEnumName(final String enumName) {
        for (NoticeReadStatusEnum element : values()) {
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

        Map<String,String> name2TitleMap = new LinkedHashMap <>();

        for (NoticeReadStatusEnum element : values()) {
            name2TitleMap.put(element.name(),element.title);
        }

        return name2TitleMap;
    }
}
