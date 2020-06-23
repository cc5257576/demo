package com.cc.common.enums;

public enum LoginType {

    ACCOUNT((short)1, "账号"),
    PHONE((short)2, "手机"),
    WECHAT((short)3, "微信"),
    QQ((short)4, "qq"),
    WEIBO((short)5, "微博");

    private Short type;

    private String desc;

    LoginType(Short type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static LoginType getLoginType(Short loginType){
        for (LoginType type :LoginType.values()) {
            if(type.getType().equals(loginType)){
                return type;
            }
        }
        return null;
    }

    public Short getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
