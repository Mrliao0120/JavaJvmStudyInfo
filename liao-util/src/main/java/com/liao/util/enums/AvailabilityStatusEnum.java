package com.liao.util.enums;




import java.util.LinkedHashMap;
import java.util.Map;

/**房源状态
 * Created by Lhb on 2017/9/20.
 */
public enum  AvailabilityStatusEnum implements TitleEnum {


    FOR_SALE("待售"),
    SUBSCRIBED("已认购"),
    SIGNED("已签约"),
    IN_BACK_PAYMENT("回款中"),
    BACK_PAYMENT("已回款"),
    CONTRACT_ARRIVAL_DATE("签约到达约定日期"),
    MORTGAGE_ARRIVAL_DATE("按揭到达约定日期"),
    INSTALLMENT_ARRIVAL_DATE("分期到达约定日期"),
    HANDOVER_OF_JUSTICE("移交法务");



    private AvailabilityStatusEnum(final String title) {
        this.title = title;
    }

    private String title;

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return AuditStatusEnum        对应的枚举值
     */
    public static AvailabilityStatusEnum getByEnumName(final String enumName) {
        for (AvailabilityStatusEnum element : values()) {
            if (element.name().equals(enumName)) {
                return element;
            }
        }
        return null;
    }
    public static AvailabilityStatusEnum getByTitle(final String enumName) {
        for (AvailabilityStatusEnum element : values()) {
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

        for (AvailabilityStatusEnum element : values()) {
            name2TitleMap.put(element.name(), element.title);
        }

        return name2TitleMap;
    }
}
