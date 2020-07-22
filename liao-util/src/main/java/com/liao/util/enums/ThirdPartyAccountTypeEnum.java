package com.liao.util.enums;



import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by mu.jie on 2017/5/11.
 */
public enum ThirdPartyAccountTypeEnum implements TitleEnum{
    WX("微信"), WB("微博"), QQ("QQ"),WX_PUB("微信公众号"),MSN("msn");
    /**
     * 展示中文表述
     */

    private String title;

    ThirdPartyAccountTypeEnum(String title) {
        this.title = title;
    }

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return SystemModuleEnum        对应的枚举值
     */
    public static ThirdPartyAccountTypeEnum getByEnumName(final String enumName) {
        for (ThirdPartyAccountTypeEnum element : values()) {
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

        for (ThirdPartyAccountTypeEnum element : values()) {
            name2TitleMap.put(element.name(),element.title);
        }

        return name2TitleMap;
    }

}
