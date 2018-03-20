package com.zx.share.platform.wechat.api.controller.zx;

import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;
import com.zx.share.platform.vo.wechat.request.OrderFileSaveBean;
import com.zx.share.platform.vo.wechat.request.OrderQueryBean;
import com.zx.share.platform.vo.wechat.request.OrderSaveBean;
import com.zx.share.platform.vo.wechat.response.OrderResultBean;
import com.zx.share.platform.wechat.api.controller.BaseController;
import com.zx.share.platform.wechat.service.ZxOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(value = "/order", produces = "application/json", description = "订单接口")
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {

    @Autowired
    private ZxOrderService zxOrderService;

    @ApiOperation(value = "保存订单信息接口", notes = "保存订单信息接口")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public DefaultResopnseBean<String> save(OrderSaveBean saveBean,HttpServletRequest request) {
        servletPath = request.getServletPath();
        DefaultResopnseBean<String> resopnseBean = new DefaultResopnseBean<>();
        return resopnseBean;
    }

    @ApiOperation(value = "保存订单打印文件接口", notes = "保存订单打印文件接口")
    @RequestMapping(value = "/save/file", method = RequestMethod.POST)
    @ResponseBody
    public DefaultResopnseBean<String> saveFile(OrderFileSaveBean saveBean, HttpServletRequest request) {
        servletPath = request.getServletPath();
        DefaultResopnseBean<String> resopnseBean = new DefaultResopnseBean<>();
        return resopnseBean;
    }

    @ApiOperation(value = "获取订单信息接口", notes = "获取订单信息接口")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public DefaultResopnseBean<OrderResultBean> get(@RequestParam("code") String code, HttpServletRequest request) {
        servletPath = request.getServletPath();
        DefaultResopnseBean<OrderResultBean> resopnseBean = new DefaultResopnseBean<>();
        OrderResultBean resultBean = zxOrderService.findByOrderCode(code);
        resopnseBean.setData(resultBean);
        return resopnseBean;
    }

    @ApiOperation(value = "取消订单信息接口", notes = "取消订单信息接口")
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    @ResponseBody
    public DefaultResopnseBean<String> cancel(@ApiParam("订单code") @RequestParam("code") String code,
                                              HttpServletRequest request) {
        servletPath = request.getServletPath();
        DefaultResopnseBean<String> resopnseBean = new DefaultResopnseBean<>();
        Integer num = zxOrderService.cancel(code);
        resopnseBean.setData(num+"");
        return resopnseBean;
    }

    @ApiOperation(value = "订单列表信息接口", notes = "订单列表信息接口")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public DefaultResopnseBean<PageResponseBean<OrderResultBean>> list(@ApiParam("订单类型") @RequestParam("type") Integer type,
                                                                       @ApiParam("第几页") @RequestParam("page") Integer page,
                                                                       @ApiParam("每页多少条") @RequestParam("pageSize") Integer pageSize,
                                                                       HttpServletRequest request, HttpServletResponse response) {
        servletPath = request.getServletPath();
        DefaultResopnseBean<PageResponseBean<OrderResultBean>> resopnseBean = new DefaultResopnseBean<>();
        OrderQueryBean queryBean = new OrderQueryBean();
        queryBean.setPage(page);
        queryBean.setPageSize(pageSize);
        PageResponseBean<OrderResultBean> pageResponseBean = zxOrderService.page(queryBean);
        resopnseBean.setData(pageResponseBean);
        return resopnseBean;
    }
}