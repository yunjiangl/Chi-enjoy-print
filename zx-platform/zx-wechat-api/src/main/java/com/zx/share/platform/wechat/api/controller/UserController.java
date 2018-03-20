package com.zx.share.platform.wechat.api.controller;

import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.vo.wechat.response.UserDetailsBean;
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
@Api(value = "/user", produces = "application/json", description = "用户接口")
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    @RequestMapping(value = "/details/info", method = RequestMethod.GET)
    @ResponseBody
    public DefaultResopnseBean<UserDetailsBean> info(HttpServletRequest request) {
        servletPath = request.getServletPath();
        DefaultResopnseBean<UserDetailsBean> resopnseBean = new DefaultResopnseBean<>();
        return resopnseBean;
    }

    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    @RequestMapping(value = "/details", method = RequestMethod.GET)
    @ResponseBody
    public DefaultResopnseBean<UserDetailsBean> details(@ApiParam("用户code") @RequestParam("userCode") String userCode,
                                                        HttpServletRequest request) {
        servletPath = request.getServletPath();
        DefaultResopnseBean<UserDetailsBean> resopnseBean = new DefaultResopnseBean<>();
        return resopnseBean;
    }

    @ApiOperation(value = "用户信息修改", notes = "用户信息修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public DefaultResopnseBean<UserDetailsBean> update(HttpServletRequest request) {
        servletPath = request.getServletPath();
        DefaultResopnseBean<UserDetailsBean> resopnseBean = new DefaultResopnseBean<>();
        return resopnseBean;
    }

    @ApiOperation(value = "找回密码-验证码发送", notes = "")
    @RequestMapping(value = "/forgetpassword/code", method = RequestMethod.POST)
    @ResponseBody
    public DefaultResopnseBean<Object> forgetpassword(@ApiParam("手机号") @RequestParam("mobile") String mobile,
                                                      HttpServletRequest request) {
        servletPath = request.getServletPath();
        DefaultResopnseBean<Object> resopnseBean = new DefaultResopnseBean<>();
        return resopnseBean;
    }

    @ApiOperation(value = "找回密码-验证", notes = "")
    @RequestMapping(value = "/forgetpassword/verification", method = RequestMethod.POST)
    @ResponseBody
    public DefaultResopnseBean<Object> verification(@ApiParam("手机号") @RequestParam("mobile") String mobile,
                                                    @ApiParam("验证码") @RequestParam("code") String code,
                                                    HttpServletRequest request) {
        servletPath = request.getServletPath();
        DefaultResopnseBean<Object> resopnseBean = new DefaultResopnseBean<>();
        return resopnseBean;
    }

    @ApiOperation(value = "找回密码-保存", notes = "")
    @RequestMapping(value = "/forgetpassword/save", method = RequestMethod.POST)
    @ResponseBody
    public DefaultResopnseBean<Object> updatePwd(@ApiParam("手机号") @RequestParam("mobile") String mobile,
                                                 @ApiParam("验证码") @RequestParam("code") String code,
                                                 @ApiParam("密码") @RequestParam("pwd") String pwd,
                                                 HttpServletRequest request) {
        servletPath = request.getServletPath();
        DefaultResopnseBean<Object> resopnseBean = new DefaultResopnseBean<>();
        return resopnseBean;
    }
}
