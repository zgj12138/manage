package com.kevin.manage.base.tips;

/**
 * 返回给前端的错误提示
 * @author ZGJ
 * @date 2017/8/28 23:15
 **/
public class ErrorTip extends Tip{
    public ErrorTip(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
}
