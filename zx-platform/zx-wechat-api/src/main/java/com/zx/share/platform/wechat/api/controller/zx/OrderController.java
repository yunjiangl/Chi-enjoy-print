package com.zx.share.platform.wechat.api.controller.zx;

import com.zx.share.platform.wechat.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fenggang on 18/3/5.
 *
 * @author fenggang
 * @date 18/3/5
 */
@Api(value = "/order", produces = "application/json", description = "订单接口")
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController{

    @ApiOperation(value = "保存订单信息接口", notes = "保存订单信息接口")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public void save(HttpServletRequest request){
        servletPath = request.getServletPath();

    }

    @ApiOperation(value = "获取订单信息接口", notes = "获取订单信息接口")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public void get(HttpServletRequest request){
        servletPath = request.getServletPath();

    }

    @ApiOperation(value = "取消订单信息接口", notes = "取消订单信息接口")
    @RequestMapping(value = "/cancel",method = RequestMethod.POST)
    public void cancel(HttpServletRequest request){
        servletPath = request.getServletPath();

    }

    @ApiOperation(value = "订单列表信息接口", notes = "订单列表信息接口")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public void list(HttpServletRequest request){
        servletPath = request.getServletPath();

    }
}
