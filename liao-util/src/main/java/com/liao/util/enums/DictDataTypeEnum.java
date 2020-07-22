package com.liao.util.enums;



import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 字典数据类型
 * Created by Jonathan on 2017/4/5.
 */
public enum DictDataTypeEnum implements TitleEnum{

    /** 字典数据类型：一般用于系统参数的设置  */
    SINGLE("单一值"),

    /** 字典数据类型：一般用于多项用途  */
    LIST("列表值");


    private String title;

    private DictDataTypeEnum(String title) {
        this.title = title;
    }

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return DictDataTypeEnum        对应的枚举值
     */
    public static DictDataTypeEnum getByEnumName(final String enumName) {
        for (DictDataTypeEnum element : values()) {
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

        for (DictDataTypeEnum element : values()) {
            name2TitleMap.put(element.name(),element.title);
        }

        return name2TitleMap;
    }
}
