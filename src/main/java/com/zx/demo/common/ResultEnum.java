package com.zx.demo.common;

public enum ResultEnum {
    SUCCESS(200, ""), ERROR(500, "内部错误"),
    VALIDATE_FAILED(400, "参数错误")
    ;

    private int code;

    private String msg;
    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
    private ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
