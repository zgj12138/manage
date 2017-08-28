package com.kevin.manage.base.tips;

/**
 * 返回给前端的成功提示
 * @author ZGJ
 * @date 2017/8/28 23:17
 **/
public class SuccessTip extends Tip{
    public SuccessTip() {
        super.code = 200;
        super.message = "请求成功";
    }
}
