package com.zx.share.platform.wechat.api.controller.zx;

import com.zx.share.platform.wechat.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @ApiOperation(value = "获取登录用户信息接口", notes = "获取登录用户信息接口")
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public void userInfo(HttpServletRequest request, HttpServletResponse response){
        servletPath = request.getServletPath();
    }

    @ApiOperation(value = "修改登录用户信息接口", notes = "修改登录用户信息接口")
    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    public void userUpdate(HttpServletRequest request, HttpServletResponse response){
        servletPath = request.getServletPath();
    }


}
