package com.liao.util.enums;



import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 资源类型
 *
 * Created by 13336 on 2017/3/31.
 */
public enum ResourceTypeEnum implements TitleEnum {

    /**  资源类型：模块 */
    MODULE("模块"),

    /**  资源类型：菜单 */
    MENU("菜单"),

    /**  资源类型：操作 */
    OPERATION("操作");

    /**
     * 展示中文表述
     */
    private String title;

    private ResourceTypeEnum(String title) {
        this.title = title;
    }

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return ResourceTypeEnum        对应的枚举值
     */
    public static ResourceTypeEnum getByEnumName(final String enumName) {
        for (ResourceTypeEnum element : values()) {
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

        for (ResourceTypeEnum element : values()) {
            name2TitleMap.put(element.name(),element.title);
        }

        return name2TitleMap;
    }
}
