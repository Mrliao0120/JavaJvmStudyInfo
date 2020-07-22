package com.liao.util.enums;



import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/18 0018.
 */
public enum AvailabilityEnum implements TitleEnum{
    RESIDENCE("住宅"),
    SHOP("商铺"),
    CARPORT("车位"),
    SERVICEDAPARTMENT("酒店式公寓"),
    OFFICEBUILDING("写字楼"),
    SUPPORTING("配套");

    private AvailabilityEnum(final String title) {
        this.title = title;
    }

    private String title;

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return AuditStatusEnum        对应的枚举值
     */
    public static AvailabilityEnum getByEnumName(final String enumName) {
        for (AvailabilityEnum element : values()) {
            if (element.name().equals(enumName)) {
                return element;
            }
        }
        return null;
    }
    public static AvailabilityEnum getByTitle(final String enumName) {
        for (AvailabilityEnum element : values()) {
            if (element.getTitle().equals(enumName)) {
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

        for (AvailabilityEnum element : values()) {
            name2TitleMap.put(element.name(), element.title);
        }

        return name2TitleMap;
    }

}
