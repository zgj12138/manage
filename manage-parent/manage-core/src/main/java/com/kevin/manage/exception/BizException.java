package com.kevin.manage.exception;

/**
 * 业务异常
 * @author ZGJ
 * @date 2017/8/28 23:21
 **/
public class BizException extends RuntimeException{

    //友好提示的code码
    protected int code;

    //友好提示
    protected String message;

    //业务异常跳转的页面
    protected String urlPath;

    public BizException(int friendlyCode, String friendlyMsg, String urlPath) {
        this.setValues(friendlyCode, friendlyMsg, urlPath);
    }

    public BizException(BizExceptionEnum bizExceptionEnum) {
        this.setValues(bizExceptionEnum.getCode(), bizExceptionEnum.getMessage()
                , bizExceptionEnum.getUrlPath());
    }

    private void setValues(int friendlyCode, String friendlyMsg, String urlPath) {
        this.code = friendlyCode;
        this.message = friendlyMsg;
        this.urlPath = urlPath;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }
}
