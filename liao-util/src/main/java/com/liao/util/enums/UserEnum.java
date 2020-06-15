package com.liao.util.enums;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/6/15 16:08
 * @Version 1.0
 * @Description
 */
public enum UserEnum {
    SYSTEM_USER(0,"系统用户"),
    GENERAL_USER(1,"普通用户");

    UserEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    private Integer  code;

    private String  name;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserEnum{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
