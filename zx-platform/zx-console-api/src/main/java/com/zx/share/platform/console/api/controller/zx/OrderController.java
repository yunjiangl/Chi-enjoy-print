package com.zx.share.platform.console.api.controller.zx;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zx.share.platform.bean.sys.export;
import com.zx.share.platform.bean.zx.ZxOrder;
import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.console.service.zx.ZxOrderService;
import com.zx.share.platform.util.ExportBeanExcel;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * @ClassName: OrderController
 * @author: 刘芸江
 * @date: 2018年3月27日 上午9:33:00
 *
 */
@RestController
@Api("订单管理接口")
@RequestMapping("zx/order/")
public class OrderController {
	
	@Autowired
	private ZxOrderService zxOrderService;

	/**
	 * 
	 * @Title: list
	 * @Description: 订单列表
	 */
	@ApiOperation(value = "所有订单分页接口", notes = "所有订单分页接口")
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public DefaultResopnseBean<PageResponseBean<ZxOrder>> list(
			@ApiParam("第几页") @RequestParam(name = "page", required = false) Integer page,
			@ApiParam("每页多少条") @RequestParam(name = "pageSize", required = false) Integer pageSize,
			@ApiParam("设备编码") @RequestParam(name = "printCode", required = false) String printCode,
			@ApiParam("设备物主") @RequestParam(name = "printName", required = false) String printName,
			@ApiParam("设备物主id") @RequestParam(name = "printHostId", required = false) Long printHostId,
			@ApiParam("律师用户名") @RequestParam(name = "lawyerName", required = false) String lawyerName,
			@ApiParam("订单支付时间1") @RequestParam(name = "time1", required = false) String time1,
			@ApiParam("订单支付时间2") @RequestParam(name = "time2", required = false) String time2) {
		
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("page", page);
		param.put("pageSize", pageSize);
		param.put("printCode", printCode);
		param.put("printName", printName);
		param.put("printHostId", printHostId);
		param.put("lawyerName", lawyerName);
		param.put("time1", time1);
		param.put("time2", time2);
		return zxOrderService.list(param);
	}
	/**
	 * 导出
	 *//*
	@ApiOperation(value = "导出", notes = "导出")
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public String export(){
		List<String> listName = new ArrayList<>();
        listName.add("订单号");
        listName.add("设备物主");
        listName.add("设备编号");
        listName.add("线上管理员");
        listName.add("客户");
        listName.add("打印费");
        listName.add("服务费");
        listName.add("支付金额");
        listName.add("支付方式");
        listName.add("支付时间");
        listName.add("平台收益");
        listName.add("物主收益");
        List<String> listId = new ArrayList<>();
        Map<String, Object> param = new HashMap<String, Object>();
        List<ZxOrder> list1=zxOrderService.list(param).getData().getContent();  
        ExportBeanExcel<export> exportBeanExcelUtil = new ExportBeanExcel();
        exportBeanExcelUtil.exportExcel("测试POI导出EXCEL文档", listName, listId, list1);
		return null;
	}*/
	/**
	 * 
	 * @Title: info
	 * @Description: 订单信息
	 */
	@RequestMapping(value = "info/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "订单信息", notes = "订单信息")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path", dataType = "Long", name = "id", value = "订单id", required = true) })
	public DefaultResopnseBean<ZxOrder> info(@PathVariable(name = "id") Long id){
		
		DefaultResopnseBean<ZxOrder> resopnseBean = new DefaultResopnseBean<ZxOrder>();
		
		ZxOrder data = zxOrderService.orderInfo(id);
		
		resopnseBean.setData(data);
		
		return resopnseBean;
	}
}
