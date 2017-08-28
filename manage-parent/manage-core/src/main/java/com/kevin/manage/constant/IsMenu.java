package com.kevin.manage.constant;

/**
 * 是否是菜单的枚举
 * @author ZGJ
 * @date 2017/8/29 0:16
 **/
public enum IsMenu {

    YES(1, "是"),
    NO(0, "不是");

    int code;
    String message;

    IsMenu(int code, String message) {
        this.code = code;
        this.message = message;
    }

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

    public static String valueOf(Integer status) {
        if(status == null) {
            return "";
        } else {
            for(IsMenu s : IsMenu.values()) {
                if(s.getCode() == status) {
                    return s.getMessage();
                }
            }
            return "";
        }
    }
}
