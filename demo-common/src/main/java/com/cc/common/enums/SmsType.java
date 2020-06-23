package com.cc.common.enums;

public enum SmsType {

    LOGIN((short)1, "登陆"){
        @Override
        public String getSmsTemplate(String verifyCode) {
            StringBuffer sf = new StringBuffer();
            sf.append("你的验证码:").append(verifyCode);
            return sf.toString();
        }
    };

    private Short type;

    private String desc;

    SmsType(Short type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static SmsType getSmsType(Short smsType){
        for (SmsType type :SmsType.values()) {
            if(type.getType().equals(smsType)){
                return type;
            }
        }
        return null;
    }

    public abstract String getSmsTemplate(String verifyCode);

    public Short getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
