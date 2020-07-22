/**
 * Zfounder.com Inc.
 * Copyright (c) 2013-2066 All Rights Reserved.
 */
package com.liao.util.enums;

/**
 * @author Jonathan.jin
 * @version $Id: ResultCodeEnum.java, v 0.1 2017/3/5 15:51 Jonathan.jin Exp $
 */
public enum ResultCodeEnum implements BaseResultCodeEnum{

    /** 处理成功 */
    EXECUTE_SUCCESS("001", "处理成功"),

    /** 未知异常 */
    UNKNOWN_EXCEPTION("002", "未知异常"),

    /** 数据库异常 */
    DATABASE_EXCEPTION("003", "数据库异常"),

    /** 反射异常 */
    REFLECT_EXCEPTION("004", "反射异常"),

    /** 系统内部错误 */
    INTERNAL_ERROR("005", "系统内部错误"),

    /** 值为空 */
    VALUE_CANNOT_NULL("006", "值为空"),

    /** 数字必须为正数 */
    NUM_MUST_POSITIVE("007", "数字必须为正数"),

    /** 页面Size超过限制 */
    PAGE_SIZE_EXCEED_LIMIT("008", "页面Size超过限制"),

    /** 参数非法 */
    ILLEGAL_PARAM("009", "参数非法"),

    /** 无操作权限 */
    NO_AUTHORITY("010","无操作权限"),

    /** 无操作权限 */
    STATUS_ERROR("011","状态异常"),

    /** 相应金额输入有误 */
    BIGDECIMAL_NUMBER_ERROR("012","相应金额输入有误"),

    /** 相应金额输入有误 */
    AREA_IS_NULL("013","区域不能为空"),

    /** 房源已存在 */
    HOUSE_HAS_EXIST("014","房源已存在"),

    /** 财务确认资料齐全后才能放款 */
    MORTGAGE_NOT_COMPLETE_INFORMATION("015","财务确认资料齐全后才能放款"),

    /** 请登录后访问系统 */
    UNAUTHORIZED("401", "请登录后访问系统"),



    /**用户不存在 */
    USER_NOT_EXIST("1001", "用户不存在"),
    /** 密码错误 */
    USER_PASSWORD_ERROR("1002","密码错误"),
    /** 名字不能为空 */
    NAME_CANNOT_BLANK("1003", "名字不能为空"),
    /**租户不存在 */
    TENANT_NOT_EXIST("1004", "租户不存在"),
    /** 资源不存在 */
    RESOURCE_NOT_EXIST("1005", "资源不存在"),
    /** 地址不存在 */
    ADMIN_AREA_NOT_EXIST("1006", "地址不存在"),
    /** 部门不存在 */
    ORG_NOT_EXIST("1007", "部门不存在"),
    /** 数据字典不存在 */
    DATADICT_NOT_EXIST("1008", "数据字典不存在"),
    /** 该字典固定，不允许删除或修改编码 */
    DATADICT_FIXED("1009", "该字典固定，不允许删除或修改编码"),
    /** 会员不存在 */
    MEMBER_NOT_EXIST("1010", "会员不存在"),
    /** 微信open_id不存在 */
    WX_OPEN_ID_NOT_EXIST("1011", "open id 不存在"),
    /** 用户账户不存在 */
    MEMBER_ACCOUNT_NOT_EXIST("1011", "用户账户不存在"),
    /** 电话号码格式不正确 */
    MOBILE_FORMAT_ERROR("1012","电话号码格式错误"),
    /** Excel无法解析 */
    EXCLE_PARSING_ERROR("1013","Excel解析失败"),
    /** 区域下面还有东西 */
    THERE_ARE_SUBCATEGORIES("1014","区域下面还存在子类，请先删除子类"),
    /** 案名下面有东西 */
    THERE_IS_A_SUBCLASS_BELOW("1015","案名下面还存在子类，请先删除子类"),
    /** 请上传Word文档 */
    THE_CURRENT_FILE_SUPPORTS_ONLY_THE_DOC("1016","请上传Word文档")
    ;

    ResultCodeEnum(final String code, final String desc) {
        this.code = code;
        this.desc = desc;
    }

    /** 结果码 */
    private String code;

    /**  结果码中文描述 */
    private String desc;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }

}
