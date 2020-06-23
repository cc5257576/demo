package com.cc.common.enums;

public enum UserType {
    REAL((short)1, "真实用户"),
    BROWSE((short)2, "游客"),
    TEST((short)3, "测试用户"),
    VIRTUAL((short)4, "虚拟用户");

    private Short type;

    private String desc;

    UserType(Short type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Short getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
