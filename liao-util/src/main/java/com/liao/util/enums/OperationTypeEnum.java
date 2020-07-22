package com.liao.util.enums;



import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by zhang.wen.chao on 2017/7/24 15:36.
 */
public enum OperationTypeEnum implements TitleEnum {
    LOGIN("登陆","登陆成功"),
    LOGOUT("退出","退出成功");

    OperationTypeEnum(String title,String reason) {
        this.title = title;
        this.reason = reason;
    }


    private String title;

    private String reason;


    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName 枚举名称
     * @return AuctionTypeEnum        对应的枚举值
     */
    public static OperationTypeEnum getByEnumName(final String enumName) {
        for (OperationTypeEnum element : values()) {
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

    public String getReason() {
        return reason;
    }

    /**
     * 获取枚举名称和title所有的映射
     *
     * @return
     */
    public static Map<String, String> getName2TitleMap() {

        Map<String, String> name2TitleMap = new LinkedHashMap<>();

        for (OperationTypeEnum element : values()) {
            name2TitleMap.put(element.name(), element.title);
        }

        return name2TitleMap;
    }
}
