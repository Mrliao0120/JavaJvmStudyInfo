package com.liao.util.enums;



import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 三方支付渠道
 *
 * Created by 13336 on 2017/3/31.
 */
public enum OrderPayMethodEnum implements TitleEnum {

    /** 三方支付渠道：支付宝 */
    ALIPAY("支付宝"),

    /** 三方支付渠道：财付通 */
    TENPAY("财付通"),

    /** 三方支付渠道：微信支付 */
    WECHAT("微信支付"),

    /** 三方支付渠道：系统免费 */
    FREE("系统免费");

    /** 展示中文表述  */

    private String title;

    private OrderPayMethodEnum(String title) {
        this.title = title;
    }

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return OrderPayMethodEnum        对应的枚举值
     */
    public static OrderPayMethodEnum getByEnumName(final String enumName) {
        for (OrderPayMethodEnum element : values()) {
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

        for (OrderPayMethodEnum element : values()) {
            name2TitleMap.put(element.name(),element.title);
        }

        return name2TitleMap;
    }
}
