package com.cc.common.enums;

public class ResultCode {

    public enum CommonCode{
        SUCCESS("200", "success"),
        FAIL("400", "fail"),
        UNAUTHORIZED("401", "unauthorized"),
        NOT_FOUND("404", "not_found"),
        INTERNAL_SERVER_ERROR("500", "internal_server_error");

        private String code;

        private String msg;

        CommonCode(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    public enum DataValidateCode{

        NULL("000001", "参数对象不能为空");

        private String code;

        private String msg;

        DataValidateCode(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    public enum UserInfoCode{
        PHONE_NO_NULL("000100", "手机号码不能为空"),
        VERIFY_CODE_NULL("000101", "验证码不能为空"),
        LOGIN_TYPE_NULL("000102", "登陆类型不能为空"),
        VERIFY_CODE_ERROR("000103", "验证码效验失败"),
        SMS_TYPE_NULL("000104", "短信类型不能为空"),
        USER_INFO_NULL("000105", "会员不能为空");
        private String code;

        private String msg;

        UserInfoCode(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }
}
