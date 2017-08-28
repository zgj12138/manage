package com.kevin.manage.base.tips;

/**
 * 返回给前端的提示，最终转换成json
 * @author ZGJ
 * @date 2017/8/28 23:15
 **/
public abstract class Tip {
    protected int code;
    protected String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
