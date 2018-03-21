package com.zx.share.platform.wechat.api.controller;

import com.zx.share.platform.util.response.DefaultResopnseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fenggang on 18/3/20.
 *
 * @author fenggang
 * @date 18/3/20
 */
@Api(value = "/Login", produces = "application/json", description = "登录退出接口")
@Controller
@RequestMapping("")
public class LoginController extends BaseController {

    @ApiOperation(value = "logout", notes = "logout")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public DefaultResopnseBean<Object> verification(HttpServletRequest request) {
        servletPath = request.getServletPath();
        DefaultResopnseBean<Object> resopnseBean = new DefaultResopnseBean<>();
        return resopnseBean;
    }
}
