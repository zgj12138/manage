package com.kevin.manage.aop;

import com.kevin.manage.base.tips.ErrorTip;
import com.kevin.manage.exception.BizException;
import com.kevin.manage.exception.BizExceptionEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 * @author ZGJ
 * @date 2017/8/28 23:12
 **/
@RestControllerAdvice
public class BaseControllerExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(BaseControllerExceptionHandler.class);

    @ExceptionHandler(BizException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorTip notFount(BizException e) {
        logger.error("业务异常", e);
        return new ErrorTip(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorTip notFount(RuntimeException e) {
        logger.error("运行时异常", e);
        return new ErrorTip(BizExceptionEnum.SERVER_ERROR.getCode(), BizExceptionEnum.SERVER_ERROR.getMessage());
    }
}
