package com.liao.util.enums;



import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/18 0018.
 */
public enum MortgageCaseEnum implements TitleEnum {

    COMPLETE_INFORMATION("资料齐全"),

    LACK_INFORMATION("缺资料"),

    UN_TRANSACTION("未办理");

    /**
     * 展示中文表述
     */

    private String title;

    private MortgageCaseEnum(String title) {
        this.title = title;
    }

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName 枚举名称
     * @return PictureFolderTypeEnum        对应的枚举值
     */
    public static MortgageCaseEnum getByEnumName(final String enumName) {
        for (MortgageCaseEnum element : values()) {
            if (element.name().equals(enumName)) {
                return element;
            }
        }
        return null;
    }
    public static MortgageCaseEnum getByTitle(final String enumName) {
        for (MortgageCaseEnum element : values()) {
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

        for (MortgageCaseEnum element : values()) {
            name2TitleMap.put(element.name(), element.title);
        }

        return name2TitleMap;
    }
}
