package com.zx.share.platform.console.api.modules.order.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;


import com.zx.share.platform.console.api.common.utils.ExpostExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zx.share.platform.bean.sys.SysDictionary;
import com.zx.share.platform.bean.zx.ZxOrder;
import com.zx.share.platform.console.api.modules.order.service.ZxOrderService;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletResponse;

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
	 *
	 *
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

	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public void export(HttpServletResponse response) {
		List<String> listName = new ArrayList<>();
		listName.add("订单编号");
		listName.add("订单状态");
		listName.add("下单时间");
		listName.add("订单费用");
		listName.add("打印费");
		listName.add("服务费");
		listName.add("律师code");
		listName.add("用户code");
		listName.add("支付id");
		listName.add("支付时间");
		listName.add("支付方式");
		listName.add("设备编号");
		listName.add("导出时间");
		/*listName.add("设备物主");
		listName.add("线上管理员");
		listName.add("客户");
		listName.add("打印费");
		listName.add("服务费");
		listName.add("支付金额");
		listName.add("支付方式");
		listName.add("支付时间");
		listName.add("平台收益");
		listName.add("物主收益");*/

		List<String> listId = new ArrayList<>();
		Map<String, Object> param = new HashMap<String, Object>();

		ExpostExcel.hssfRow("标题",listName);
		// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		List<ZxOrder> zxOrderList = zxOrderService.list(param).getData().getContent();

		for (int i = 0; i < zxOrderList.size(); i++)
		{
			ExpostExcel.row = ExpostExcel.hssfShee.createRow((int) i + 1);
			ZxOrder zxOrder=zxOrderList.get(i);
			//Member stu = (Member) list.get(i);
			// 第四步，创建单元格，并设置值
			ExpostExcel.row.createCell((short) 0).setCellValue(zxOrder.getOrderNum());//订单编号
			ExpostExcel.row.createCell((short) 1).setCellValue(zxOrder.getStatus());//订单状态
			//row.createCell((short) 2).setCellValue(zxOrder.getCreateTime());//下单时间
			ExpostExcel.row.createCell((short) 3).setCellValue(zxOrder.getOrderAmount());//订单费用
			ExpostExcel.row.createCell((short) 4).setCellValue(zxOrder.getPrinterAmount());//打印费
			ExpostExcel.row.createCell((short) 5).setCellValue(zxOrder.getServiceAmount());//服务费
			//row.createCell((short) 6).setCellValue(zxOrder.getAttorneyCode());//律师code
			//row.createCell((short) 7).setCellValue(zxOrder.getOrderUserCode());//用户code
			//row.createCell((short) 8).setCellValue(zxOrder.getPayId());//支付id
			ExpostExcel.row.createCell((short) 9).setCellValue(zxOrder.getPayTime());//支付时间
			ExpostExcel.row.createCell((short) 10).setCellValue(zxOrder.getPayType());//支付类型
			ExpostExcel.row.createCell((short) 11).setCellValue(zxOrder.getPrinterCode());//打印机code
			ExpostExcel.cell = ExpostExcel.row.createCell((short) 12);

		}

		// 第六步，下载excel
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            String fileName = "enroll.xls";// 文件名
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename="
                    + URLEncoder.encode(fileName, "UTF-8"));
			response.flushBuffer();
			ExpostExcel.wb.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

	}

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
