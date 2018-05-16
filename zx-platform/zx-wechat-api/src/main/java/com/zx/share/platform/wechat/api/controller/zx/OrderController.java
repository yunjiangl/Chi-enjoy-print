package com.zx.share.platform.wechat.api.controller.zx;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zx.share.platform.common.service.MemcachedService;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.constants.OrderStatusEnum;
import com.zx.share.platform.util.StringUtil;
import com.zx.share.platform.util.email.StoreMail;
import com.zx.share.platform.vo.wechat.request.OrderSaveBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zx.share.platform.bean.zx.ZxOrder;
import com.zx.share.platform.common.bean.UserCache;
import com.zx.share.platform.common.service.TokenCacheService;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;
import com.zx.share.platform.vo.wechat.request.OrderQueryBean;
import com.zx.share.platform.vo.wechat.response.OrderResultBean;
import com.zx.share.platform.vo.wechat.response.UserDetailsBean;
import com.zx.share.platform.wechat.api.controller.BaseController;
import com.zx.share.platform.wechat.service.UserService;
import com.zx.share.platform.wechat.service.ZxOrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

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

	@Autowired
	private TokenCacheService tokenCacheService;
	@Autowired
	private MemcachedService memcachedService;
	@Autowired
	private UserService userService;

	@ApiOperation(value = "保存订单信息接口", notes = "保存订单信息接口")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public DefaultResopnseBean<String> save(@ApiParam("客户code") @RequestParam("customerCode") String customerCode,
			@ApiParam("律师code") @RequestParam("attorneyCode") String attorneyCode,
			@ApiParam("打印机code") @RequestParam("printerCode") String printerCode,
			@ApiParam("文件code(多个文件中间用英文逗号分隔)") @RequestParam("fileCodes") String fileCodes,
			@ApiParam("纸张类型") @RequestParam("paperType") Long paperType,
			@ApiParam("打印数量") @RequestParam("printerNum") Integer printerNum,
			@ApiParam("纸张颜色") @RequestParam("paperColcor") Long paperColcor,
			@ApiParam("纸张使用") @RequestParam("paperUsage") Long paperUsage,
			@ApiParam("服务费") @RequestParam("serviceAmout") Double serviceAmout,
			@ApiParam("文件类型(在字典数据库没有变动的情况下，4为ab类文件，5为cde类文件)") @RequestParam("fileType") Long fileType,
			HttpServletRequest request) {
		servletPath = request.getServletPath();
		DefaultResopnseBean<String> resopnseBean = new DefaultResopnseBean<>();
		OrderSaveBean orderSaveBean = new OrderSaveBean();
		orderSaveBean.setAttorneyCode(attorneyCode);
		orderSaveBean.setCustomerCode(customerCode);
		orderSaveBean.setFileCodes(fileCodes);
		orderSaveBean.setPaperColcor(paperColcor);
		orderSaveBean.setServiceAmout(serviceAmout);
		orderSaveBean.setPrinterNum(printerNum);
		orderSaveBean.setPrinterCode(printerCode);
		orderSaveBean.setPaperUsage(paperUsage);
		orderSaveBean.setPaperType(paperType);
		orderSaveBean.setFileType(fileType);
		zxOrderService.saveOrder(orderSaveBean);
		return resopnseBean;
	}

	@ApiOperation(value = "修改订单接口", notes = "修改订单接口")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public DefaultResopnseBean<String> update(@ApiParam("订单code") @RequestParam("orderCode") String orderCode,
			@ApiParam("客户code") @RequestParam("customerCode") String customerCode,
			@ApiParam("律师code") @RequestParam("attorneyCode") String attorneyCode,
			@ApiParam("打印机code") @RequestParam("printerCode") String printerCode,
			@ApiParam("文件code(多个文件中间用英文逗号分隔)") @RequestParam("fileCodes") String fileCodes,
			@ApiParam("纸张类型") @RequestParam("paperType") Long paperType,
			@ApiParam("打印数量") @RequestParam("printerNum") Integer printerNum,
			@ApiParam("纸张颜色") @RequestParam("paperColcor") Long paperColcor,
			@ApiParam("纸张使用") @RequestParam("paperUsage") Long paperUsage,
			@ApiParam("服务费") @RequestParam("serviceAmout") Double serviceAmout, HttpServletRequest request) {
		servletPath = request.getServletPath();
		DefaultResopnseBean<String> resopnseBean = new DefaultResopnseBean<>();
		OrderSaveBean orderSaveBean = new OrderSaveBean();
		orderSaveBean.setAttorneyCode(attorneyCode);
		orderSaveBean.setCustomerCode(customerCode);
		orderSaveBean.setFileCodes(fileCodes);
		orderSaveBean.setPaperColcor(paperColcor);
		orderSaveBean.setServiceAmout(serviceAmout);
		orderSaveBean.setPrinterNum(printerNum);
		orderSaveBean.setPrinterCode(printerCode);
		orderSaveBean.setPaperUsage(paperUsage);
		orderSaveBean.setPaperType(paperType);
		orderSaveBean.setOrderCode(orderCode);
		zxOrderService.saveOrder(orderSaveBean);
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
		resopnseBean.setData(num + "");
		return resopnseBean;
	}

	@ApiOperation(value = "订单列表信息接口", notes = "订单列表信息接口")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public DefaultResopnseBean<PageResponseBean<OrderResultBean>> list(
			@ApiParam(value = "用户类型") @RequestParam(name = "type",required = false) Integer type,
			@ApiParam(value = "用户code") @RequestParam(name = "userCode", required = true) String userCode,
			@ApiParam(value = "订单状态") @RequestParam(name = "status", required = false) Integer status,
			@ApiParam("第几页") @RequestParam("page") Integer page,
			@ApiParam("每页多少条") @RequestParam("pageSize") Integer pageSize, HttpServletRequest request,
			HttpServletResponse response) {
		servletPath = request.getServletPath();
		DefaultResopnseBean<PageResponseBean<OrderResultBean>> resopnseBean = new DefaultResopnseBean<>();
		OrderQueryBean queryBean = new OrderQueryBean();
		queryBean.setPage(page);
		queryBean.setPageSize(pageSize);
		queryBean.setOrderStatus(status);
		queryBean.setUserType(type);
		queryBean.setUserCode(userCode);
		PageResponseBean<OrderResultBean> pageResponseBean = zxOrderService.page(queryBean);
		resopnseBean.setData(pageResponseBean);
		return resopnseBean;
	}

	@ApiOperation(value = "律师完成订单接口", notes = "律师完成订单接口")
	@RequestMapping(value = "/attorney", method = RequestMethod.GET)
	@ResponseBody
	public DefaultResopnseBean<List<ZxOrder>> attorney(
			@ApiParam(value = "用户code") @RequestParam(name = "userCode", required = true) String userCode,
			@ApiParam(value = "设备物主/设备编码") @RequestParam(name = "nameOrCode", required = false) String nameOrCode,
			@ApiParam(value = "订单完成时间") @RequestParam(name = "timeo", required = false) String timeo,
			HttpServletRequest request) throws Exception {
		servletPath = request.getServletPath();
		//UserCache userCache = tokenCacheService.getCacheUser(request); // 得到当前登录用户
		//System.out.println(userCache);
		UserDetailsBean userDetailsBean= userService.details(userCode);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		Date time=null;
		if(timeo!=null) {
			time=sdf.parse(timeo);
		}
		Map<String, Object> param = new HashMap<>();
		param.put("nameOrCode", nameOrCode);
		param.put("time", time);
		param.put("attorneyId", userDetailsBean.getId());
		List<ZxOrder> data = zxOrderService.attorney(param);

		DefaultResopnseBean<List<ZxOrder>> resopnseBean = new DefaultResopnseBean<List<ZxOrder>>();
		resopnseBean.setData(data);
		return resopnseBean;
	}

	@ApiOperation(value = "律师完成订单详细信息", notes = "律师完成订单详细信息")
	@RequestMapping(value = "/info/{code}", method = RequestMethod.GET)
	@ResponseBody
	public DefaultResopnseBean<ZxOrder> Orderinfo(@ApiParam("订单code") @PathVariable("code") String code,
			HttpServletRequest request) {

		servletPath = request.getServletPath();

		ZxOrder data = zxOrderService.orderInfo(code);
		DefaultResopnseBean<ZxOrder> resopnseBean = new DefaultResopnseBean<ZxOrder>();
		resopnseBean.setData(data);
		return resopnseBean;
	}

	@ApiOperation(value = "打印订单文件", notes = "打印订单文件")
	@RequestMapping(value = "/printer/{code}", method = RequestMethod.GET)
	@ResponseBody
	public DefaultResopnseBean<Object> printer(@ApiParam("订单code") @PathVariable("code") String code,
												  HttpServletRequest request) {
		servletPath = request.getServletPath();
		DefaultResopnseBean<Object> resopnseBean = new DefaultResopnseBean<>();
		String codes = memcachedService.get("zx_platform_order")+"";
		if(codes.indexOf(code)>=0){
			resopnseBean.jsonFill(ErrorsEnum.SYSTEM_CUSTOM_ERROR.code,"打印出错，不能重复发送打印请求");
			return resopnseBean;
		}
		boolean result = zxOrderService.printer(code);
		if(!result){
			resopnseBean.jsonFill(ErrorsEnum.SYSTEM_CUSTOM_ERROR.code,"打印出错，请联系管理员");
		}
		return resopnseBean;
	}

	@Scheduled(cron = "0 0/1 * * * ?")
	public void emailCallBack(){
		this._emailCallBack();
	}

	private synchronized void _emailCallBack(){
		String codes = memcachedService.get("zx_platform_order")+"";
		try {
			if(StringUtil.isNotBlank(codes)){
				StringBuffer mCode = new StringBuffer(",");
				List<Map<String,Object>> emailList = StoreMail.emailInbox();
				String[] codeList = codes.split(",");
				for (String code:codeList) {
					if(StringUtil.isNotBlank(code)){
						continue;
					}
					int count = 0;
					if(emailList!=null && !emailList.isEmpty()){
						for (Map<String,Object> map:emailList) {
							String content = map.get("content")+"";
							System.out.println(content);
							if(content.indexOf(code)>=0){
								count = 1;
								if(map.get("subject").toString().indexOf("成功打印")>=0){
									zxOrderService.updateOrderStatus1(code, OrderStatusEnum.ZX_ORDER_STATUS_PRINTER_OK.code);
									break;
								}else if(map.get("subject").toString().indexOf("成功打印")>=0){
									zxOrderService.updateOrderStatus1(code, OrderStatusEnum.ZX_ORDER_STATUS_PRINTER.code);
									break;
								}else{
									zxOrderService.updateOrderStatus1(code, OrderStatusEnum.ZX_ORDER_STATUS_PRINTER_ERROR.code);
									break;
								}
							}
						}
					}
					if(count==0){
						mCode.append(code+",");
					}
				}
				memcachedService.set("zx_platform_order",60*60*24*100,mCode.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}