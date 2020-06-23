package com.cc.common.enums;

public enum UserStatus {

    NORMAL((short)1, "正常"),
    INACTIVATE((short)2, "未激活"),
    DISABLE((short)3, "冻结");

    private Short status;

    private String desc;

    UserStatus(Short status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Short getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
