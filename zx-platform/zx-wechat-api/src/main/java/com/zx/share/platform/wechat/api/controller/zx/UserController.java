package com.zx.share.platform.wechat.api.controller.zx;

import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.vo.user.UserResultBean;
import com.zx.share.platform.vo.wechat.response.UserDetailsBean;
import com.zx.share.platform.wechat.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fenggang on 18/3/5.
 *
 * @author fenggang
 * @date 18/3/5
 */
@Api(value = "/user", produces = "application/json", description = "用户接口")
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

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


}
