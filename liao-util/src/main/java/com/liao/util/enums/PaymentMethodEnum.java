package com.liao.util.enums;



import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/18 0018.
 */
public enum PaymentMethodEnum  implements TitleEnum {

    ONE_OFF("一次性付款"),

    BUSINESS_LOANS("商业贷款"),

    ACCUMULATION_FUND_LOANS("公积金贷款"),

    COMBINATION_LOANS("组合贷款"),

    INSTALLMENT("分期付款");

    /** 展示中文表述  */

    private String title;

    private PaymentMethodEnum(String title) {
        this.title = title;
    }

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return OrderPayMethodEnum        对应的枚举值
     */
    public static PaymentMethodEnum getByEnumName(final String enumName) {
        for (PaymentMethodEnum element : values()) {
            if (element.name().equals(enumName)) {
                return element;
            }
        }
        return null;
    }

    public static PaymentMethodEnum getByTitle(final String enumName) {
        for (PaymentMethodEnum element : values()) {
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
    public static Map<String,String> getName2TitleMap(){

        Map<String,String> name2TitleMap = new LinkedHashMap<>();

        for (PaymentMethodEnum element : values()) {
            name2TitleMap.put(element.name(),element.title);
        }

        return name2TitleMap;
    }
}
