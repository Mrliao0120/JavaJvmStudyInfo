package com.liao.util.utils;

/**
 * 把混淆 基础值相关放到配置库中。
 */
public class CommonConstants {
    public static final String ROLE_PREFIX = "ROLE_";
    public static final Long   PLATFORM_ID = 1l;

    public static final String PWD_RETRY_CACHE = "passwordRetryCache";

    public static final String SESSION_NAME_PF_MNG      = "pf.mng.session.name";
    public static final String SESSION_NAME_INSURER_MNG = "insurer.mng.session.name";
    public static final String SESSION_NAME_SHOP_MNG    = "shop.mng.session.name";

    public static final String PROP_FILE_NAME_COMMON = "common.properties";
    public static final String PROP_FILE_NAME_TASK   = "task.properties";

    /** 平台mng的配置文件  *、
    public static final String PROP_FILE_NAME_PF_MNG = "pf_mng.properties";

    /** 枚举类package名配置文件  */
    public static final String PROP_FILE_NAME_ENUM_CONF = "enum-conf.properties";

    /**
     * 只有两层结构 北京 天津 上海 重庆  台湾 香港 澳门(990000 除外)
     */
    public static final String ADMIN_AREA_TWO_LEVEL_ID_JOINT = "110000_120000_310000_500000_710000_810000_820000";

    /**
     * 很多地方的状态原因、描述、或详情中填写的是json，其中的key
     */
    public static final String JSON_KEY_ACTION_TYPE = "actionType";

    /**
     * 默认图片id
     */
    public static final long DEFAULT_PIC_ID = 1l;

    /**
     * 用于数据库实体的基类中 新增人 修改人的类型
     *
     */
    public static final String USER_TYPE_COMMON = "user";

    /**
     * 用于数据库实体的基类中 新增人 修改人的类型
     *
     */
    public static final String USER_TYPE_MEMBER = "TENANT_MEMBER";

    /** 平台租户默认id为1 */
    public static final Long PLATFORM_TENANT_ID = 1l;

    public static final String ENUM_SPLIT_STR = "#";
}


