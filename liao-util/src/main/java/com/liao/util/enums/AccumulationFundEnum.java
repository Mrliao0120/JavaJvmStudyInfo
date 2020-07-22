package com.liao.util.enums;



import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/18 0018.
 */
public enum AccumulationFundEnum  implements TitleEnum {

    PROVINCE_ACCUMULATION_FUND("省公积金"),

    CITY_ACCUMULATION_FUND("市公积金"),

    OTHER("其他");

    /**
     * 展示中文表述
     */

    private String title;

    private AccumulationFundEnum(String title) {
        this.title = title;
    }

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return AdminAreaTypeEnum        对应的枚举值
     */
    public static AccumulationFundEnum getByEnumName(final String enumName) {
        for (AccumulationFundEnum element : values()) {
            if (element.name().equals(enumName)) {
                return element;
            }
        }
        return null;
    }

    public static AccumulationFundEnum getByTitle(final String enumName) {
        for (AccumulationFundEnum element : values()) {
            if (element.getTitle().equals(enumName)) {
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

        for (AccumulationFundEnum element : values()) {
            name2TitleMap.put(element.name(), element.title);
        }

        return name2TitleMap;
    }
}
