package com.cc.common.base;

import com.cc.common.enums.ResultCode.CommonCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/17 17:02
 * Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultBean<T> implements Serializable {

    private String code;

    private String msg;

    private T data;

    public ResultBean(T data) {
        this.code = CommonCode.SUCCESS.getCode();
        this.msg = CommonCode.SUCCESS.getMsg();
        this.data = data;
    }

    public ResultBean(Throwable e) {
        super();
        this.msg = e.toString();
        this.code = CommonCode.FAIL.getCode();
    }

    public ResultBean(String code, String msg) {
        super();
        this.code = code;
        this.msg = msg;

    }

    public static ResultBean ok (){
        return new ResultBean(CommonCode.SUCCESS.getCode(), CommonCode.SUCCESS.getMsg());
    }

    public static <T> ResultBean<T> ok(T data) {
        return new ResultBean(data);
    }

    public static ResultBean fail(){
        return new ResultBean(CommonCode.FAIL.getCode(), CommonCode.FAIL.getMsg(), null);
    }

    public static ResultBean is(int num){
        return num > 0 ? ok() : fail();
    }
}
