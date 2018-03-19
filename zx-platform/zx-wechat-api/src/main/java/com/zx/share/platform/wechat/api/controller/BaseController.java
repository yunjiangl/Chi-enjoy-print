package com.zx.share.platform.wechat.api.controller;

import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.exception.BusinessException;
import com.zx.share.platform.exception.NeedLoginException;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by fenggang on 18/3/5.
 *
 * @author fenggang
 * @date 18/3/5
 */
public class BaseController {

    protected String servletPath = "";
    protected Logger logger = LoggerFactory.getLogger(getClass());
    protected final static String USER_LOGIN_CACHE_KEY = "ZX_USER_LOGIN_";


    /**
     * 处理登录验证异常
     */
    @ExceptionHandler({NeedLoginException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleLoginException() {
        DefaultResopnseBean<Boolean> responseData = new DefaultResopnseBean<>();
        responseData.jsonFill(ErrorsEnum.SYSTEM_NOT_LOGIN);
        return ResponseEntity.ok(responseData);
    }

    /**
     * 异常监听方法
     * controller中方法抛出异常时会执行此方法
     *
     * @param e 异常消息
     * @return 请求异常时的返回消息
     */
    @ExceptionHandler({BusinessException.class})
    @ResponseBody
    public DefaultResopnseBean<Object> handleException(Exception e) {
        DefaultResopnseBean<Object> result = new DefaultResopnseBean<Object>();
        e.printStackTrace();
        logger.error("error_{} :", servletPath, e);
        e.printStackTrace();
        result.jsonFill(ErrorsEnum.SYSTEM_BUSINESS_ERROR);
        return result;
    }
}
