package com.liao.util.enums;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/18 0018.
 */
public enum ReturnedMoneyEnum implements TitleEnum{
    AUDIT_LOANS_INFO("审核贷款信息"),

    TERM_LOAN("放款"),

    MAKE_COLLECTIONS("收款"),

    TOTAL_PAYMENT("全款收清"),

    CHECK_OUT_HOUSE("退房"),

    HAND_OVER_LAW("移交法务"),

    SEND_LETTER("发函"),

    RETURN_SIGN("退回签约状态");

    private ReturnedMoneyEnum(final String title) {
        this.title = title;
    }

    private String title;

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return AuditStatusEnum        对应的枚举值
     */
    public static ReturnedMoneyEnum getByEnumName(final String enumName) {
        for (ReturnedMoneyEnum element : values()) {
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

        for (ReturnedMoneyEnum element : values()) {
            name2TitleMap.put(element.name(), element.title);
        }

        return name2TitleMap;
    }

}
