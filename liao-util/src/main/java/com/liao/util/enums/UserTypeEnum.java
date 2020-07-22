package com.liao.util.enums;



import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 用户类型
 *
 * Created by 13336 on 2017/3/31.
 */
public enum UserTypeEnum implements TitleEnum {

    /** 平台小二，即平台管理员 */
    PLATFORM_SERVANT("platform_servant", "平台小二"),

    /** 租户的会员,通用的会员，一般就足够了，不再明细什么会员 */
    TENANT_MEMBER("tenant_member", "租户的会员"),

    /** 租户的个人会员 */
    TENANT_MEMBER_PERSONAL("tenant_member_personal", "租户的个人会员"),

    /** 租户的企业会员 */
    TENANT_MEMBER_COMPANY("tenant_member_company", "租户的企业会员"),

    /** 租户的同业会员 */
    TENANT_MEMBER_ORG("tenant_member_org", "租户的同业会员"),

    /** 平台系统引擎 */
    ENGINE_PLATFORM("system_engine", "平台系统引擎"),

     /** 租户系统引擎 */
    ENGINE_TENANT("system_engine", "租户系统引擎"),

     /** 会员系统引擎 */
    ENGINE_MEMBER("system_engine", "会员系统引擎"),

    /** 租户小二，即租户管理员 */
    TENANT_SERVANT("tenant_servant", "租户小二"),

    /** 通用用户，所有使用User表的记录 */
    COMMON_USER("common_user", "通用用户"),
    ;

    /**
     * 展示英文描述
     */
    private String key;

    /**
     * 展示中文表述
     */
    private String title;

    private UserTypeEnum(String key, String title) {
        this.key = key;
        this.title = title;
    }

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName                     枚举名称
     * @return UserTypeEnum        对应的枚举值
     */
    public static UserTypeEnum getByEnumName(final String enumName) {
        for (UserTypeEnum element : values()) {
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

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    /**
     * 获取枚举名称和title所有的映射
     *
     * @return
     */
    public static Map<String,String> getName2TitleMap(){

        Map<String,String> name2TitleMap = new LinkedHashMap <>();

        for (UserTypeEnum element : values()) {
            name2TitleMap.put(element.name(),element.title);
        }

        return name2TitleMap;
    }
}
