package com.zx.share.platform.console.api.modules.order.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zx.share.platform.bean.sys.SysDictionary;
//import com.zx.share.platform.bean.sys.export;
import com.zx.share.platform.bean.zx.ZxOrder;
import com.zx.share.platform.console.api.modules.order.service.ZxOrderService;
//import com.zx.share.platform.util.ExportBeanExcel;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName: OrderController
 * @author: 刘芸江
 * @date: 2018年3月27日 上午9:33:00
 *
 */
@RestController
@RequestMapping("/zx/order/")
public class OrderController {

	@Autowired
	private ZxOrderService zxOrderService;

	/**
	 * 
	 * @Title: list
	 * @Description: 订单列表
	 */
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public DefaultResopnseBean<PageResponseBean<ZxOrder>> list(@RequestParam Map<String, Object> params) {
		return zxOrderService.list(params);
	}
	@RequestMapping(value = "/lawyer/page", method = RequestMethod.GET)
	public DefaultResopnseBean<PageResponseBean<ZxOrder>> lawyer(@RequestParam Map<String, Object> params) {
		return zxOrderService.lawyer(params);
	}
	@RequestMapping(value = "/lawyer/update", method = RequestMethod.GET)
	public DefaultResopnseBean<Object> lawyerUpdate(String filePath,String orderCode){
		DefaultResopnseBean<Object> resopnseBean = new DefaultResopnseBean<>();
		zxOrderService.lawyerUpdate(filePath,orderCode);
		return resopnseBean;
	}

	/**
	 * 导出
	 *//*
		 * @ApiOperation(value = "导出", notes = "导出")
		 * 
		 * @RequestMapping(value = "/export", method = RequestMethod.GET) public String
		 * export(){ List<String> listName = new ArrayList<>(); listName.add("订单号");
		 * listName.add("设备物主"); listName.add("设备编号"); listName.add("线上管理员");
		 * listName.add("客户"); listName.add("打印费"); listName.add("服务费");
		 * listName.add("支付金额"); listName.add("支付方式"); listName.add("支付时间");
		 * listName.add("平台收益"); listName.add("物主收益"); List<String> listId = new
		 * ArrayList<>(); Map<String, Object> param = new HashMap<String, Object>();
		 * List<ZxOrder> list1=zxOrderService.list(param).getData().getContent();
		 * ExportBeanExcel<export> exportBeanExcelUtil = new ExportBeanExcel();
		 * exportBeanExcelUtil.exportExcel("测试POI导出EXCEL文档", listName, listId, list1);
		 * return null; }
		 */
	/**
	 * 
	 * @Title: info
	 * @Description: 订单信息
	 */
	@RequestMapping(value = "info/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "订单信息", notes = "订单信息")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path", dataType = "Long", name = "id", value = "订单id", required = true) })
	public DefaultResopnseBean<ZxOrder> info(@PathVariable(name = "id") Long id) {

		DefaultResopnseBean<ZxOrder> resopnseBean = new DefaultResopnseBean<ZxOrder>();

		ZxOrder data = zxOrderService.orderInfo(id);

		resopnseBean.setData(data);

		return resopnseBean;
	}

	/**
	 * 
	 * @Title: paperInfo   
	 * @Description: 查询纸张信息
	 */
	@RequestMapping(value = "paperInfo", method = RequestMethod.GET)
	public DefaultResopnseBean<List<SysDictionary>> paperInfo(@RequestParam Long paperTypeId, @RequestParam Long paperColcorId, @RequestParam Long paperUsageId) {
		DefaultResopnseBean<List<SysDictionary>> resopnseBean = new DefaultResopnseBean<List<SysDictionary>>();
		Long[] Ids = new Long[3];
		Ids[0] = paperTypeId;
		Ids[1] = paperColcorId;
		Ids[2] = paperUsageId;
		List<SysDictionary> data = zxOrderService.paperInfo(Ids);

		resopnseBean.setData(data);

		return resopnseBean;
	}

	/**
	 * 
	 * @Title:
	 * @Description: 查询总金额以及总条数
	 */
	@RequestMapping(value = "selectCount", method = RequestMethod.GET)
	public Integer selectCount() {

		Integer count = zxOrderService.selectCount();

		return count;
	}

	/**
	 * 
	 * @Title:
	 * @Description: 查询总金额以及总条数
	 */
	@RequestMapping(value = "selectSum", method = RequestMethod.GET)
	public Integer selectSum() {

		Integer sum = zxOrderService.selectSum();

		return sum;
	}
}
