package com.cc.common.enums;

public enum AccountType {

    USER((short)1, "会员");

    private Short type;

    private String desc;

    AccountType(Short type, String desc) {
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
