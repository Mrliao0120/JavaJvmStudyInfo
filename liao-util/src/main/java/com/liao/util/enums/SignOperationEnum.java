package com.liao.util.enums;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/18 0018.
 */
public enum SignOperationEnum implements TitleEnum{


    SIGN_CONTACT("签约"),

    RETURN_MONEY("退订"),

    UNRETURN_MONEY("挞定"),

    OVERDUE("逾期"),

    GIVE_TACIT_CONSENT_TO("无"),

    SEND_LETTER("发函");

    private SignOperationEnum(final String title) {
        this.title = title;
    }

    private String title;

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return AuditStatusEnum        对应的枚举值
     */
    public static SignOperationEnum getByEnumName(final String enumName) {
        for (SignOperationEnum element : values()) {
            if (element.name().equals(enumName)) {
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

        for (SignOperationEnum element : values()) {
            name2TitleMap.put(element.name(), element.title);
        }

        return name2TitleMap;
    }

}
