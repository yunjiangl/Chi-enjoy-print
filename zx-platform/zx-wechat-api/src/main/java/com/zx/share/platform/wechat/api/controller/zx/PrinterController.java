package com.zx.share.platform.wechat.api.controller.zx;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zx.share.platform.bean.zx.ZxPrinterManager;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;
import com.zx.share.platform.vo.wechat.request.PrinterQueryBean;
import com.zx.share.platform.vo.wechat.response.PrinterResultBean;
import com.zx.share.platform.vo.wechat.response.UserDetailsBean;
import com.zx.share.platform.wechat.api.controller.BaseController;
import com.zx.share.platform.wechat.service.PrinterService;
import com.zx.share.platform.wechat.service.ZxUserPrinterApplyService;
import com.zx.share.platform.wechat.service.ZxUserPrinterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Created by fenggang on 18/3/9.
 *
 * @author fenggang
 * @date 18/3/9
 */
@Api(value = "/printer", produces = "application/json", description = "打印机接口")
@Controller
@RequestMapping("/printer")
public class PrinterController extends BaseController {

	@Autowired
	private PrinterService printerService;

	@Autowired
	private ZxUserPrinterApplyService zxUserPrinterApplyService;

	@Autowired
	private ZxUserPrinterService zxUserPrinterService;

	@ApiOperation(value = "所有打印机接口", notes = "所有打印机接口")
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public DefaultResopnseBean<List<PrinterResultBean>> all(HttpServletRequest request) {
		servletPath = request.getServletPath();
		DefaultResopnseBean<List<PrinterResultBean>> resopnseBean = new DefaultResopnseBean<>();
		List<PrinterResultBean> resultBeanList = printerService.all();
		resopnseBean.setData(resultBeanList);
		return resopnseBean;
	}

	@ApiOperation(value = "所有打印机分页接口", notes = "所有打印机分页接口")
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	@ResponseBody
	public DefaultResopnseBean<PageResponseBean<PrinterResultBean>> page(
			@ApiParam("第几页") @RequestParam("page") Integer page,
			@ApiParam("每页多少条") @RequestParam("pageSize") Integer pageSize, HttpServletRequest request) {
		servletPath = request.getServletPath();
		DefaultResopnseBean<PageResponseBean<PrinterResultBean>> resopnseBean = new DefaultResopnseBean<>();
		PrinterQueryBean queryBean = new PrinterQueryBean();
		queryBean.setPage(page);
		queryBean.setPageSize(pageSize);
		PageResponseBean<PrinterResultBean> pageResultBean = printerService.query(queryBean);
		resopnseBean.setData(pageResultBean);
		return resopnseBean;
	}

	@ApiOperation(value = "附近打印机接口", notes = "附近打印机接口")
	@RequestMapping(value = "/nearby", method = RequestMethod.GET)
	@ResponseBody
	public DefaultResopnseBean<List<PrinterResultBean>> nearby(
			@ApiParam("经度") @RequestParam("longitude") Double longitude,
			@ApiParam("纬度") @RequestParam("latitude") Double latitude, HttpServletRequest request) {
		servletPath = request.getServletPath();
		DefaultResopnseBean<List<PrinterResultBean>> resopnseBean = new DefaultResopnseBean<>();
		PrinterQueryBean queryBean = new PrinterQueryBean();
		queryBean.setLatitude(latitude);
		queryBean.setLongitude(longitude);
		List<PrinterResultBean> resultBeanList = printerService.nearby(queryBean);
		resopnseBean.setData(resultBeanList);
		return resopnseBean;
	}

	@ApiOperation(value = "打印机查询接口", notes = "打印机查询接口")
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public DefaultResopnseBean<PageResponseBean<PrinterResultBean>> query(
			@ApiParam("第几页") @RequestParam("page") Integer page,
			@ApiParam("每页多少条") @RequestParam("pageSize") Integer pageSize, HttpServletRequest request) {
		servletPath = request.getServletPath();
		DefaultResopnseBean<PageResponseBean<PrinterResultBean>> resopnseBean = new DefaultResopnseBean<>();
		PrinterQueryBean queryBean = new PrinterQueryBean();
		queryBean.setPage(page);
		queryBean.setPageSize(pageSize);
		PageResponseBean<PrinterResultBean> pageResultBean = printerService.query(queryBean);
		resopnseBean.setData(pageResultBean);
		return resopnseBean;
	}

	@ApiOperation(value = "我的打印机接口", notes = "我的打印机接口")
	@RequestMapping(value = "/my", method = RequestMethod.GET)
	@ResponseBody
	public DefaultResopnseBean<PageResponseBean<PrinterResultBean>> my(
			@ApiParam("第几页") @RequestParam("page") Integer page,
			@ApiParam("每页多少条") @RequestParam("pageSize") Integer pageSize, HttpServletRequest request) {
		servletPath = request.getServletPath();
		DefaultResopnseBean<PageResponseBean<PrinterResultBean>> resopnseBean = new DefaultResopnseBean<>();
		PrinterQueryBean queryBean = new PrinterQueryBean();
		queryBean.setPage(page);
		queryBean.setPageSize(pageSize);
		PageResponseBean<PrinterResultBean> pageResultBean = printerService.my(queryBean);
		resopnseBean.setData(pageResultBean);
		return resopnseBean;
	}

	@ApiOperation(value = "打印机关联律师接口", notes = "打印机关联律师")
	@RequestMapping(value = "/attorney", method = RequestMethod.GET)
	@ResponseBody
	public DefaultResopnseBean<PageResponseBean<UserDetailsBean>> attorney(
			@ApiParam("第几页") @RequestParam("page") Integer page,
			@ApiParam("每页多少条") @RequestParam("pageSize") Integer pageSize,
			@ApiParam("打印机code") @RequestParam("code") String code, HttpServletRequest request) {
		servletPath = request.getServletPath();
		DefaultResopnseBean<PageResponseBean<UserDetailsBean>> resopnseBean = new DefaultResopnseBean<>();
		PrinterQueryBean queryBean = new PrinterQueryBean();
		queryBean.setPage(page);
		queryBean.setPageSize(pageSize);
		queryBean.setPrinterCode(code);
		PageResponseBean<UserDetailsBean> pageResultBean = printerService.attorneyPage(queryBean);
		resopnseBean.setData(pageResultBean);
		return resopnseBean;
	}

	@ApiOperation(value = "打印机详细信息", notes = "打印机详细信息")
	@RequestMapping(value = "/info/{code}", method = RequestMethod.GET)
	@ResponseBody
	public DefaultResopnseBean<ZxPrinterManager> PrinterInfo(@ApiParam("打印机code") @PathVariable("code") String code,
			HttpServletRequest request) {

		servletPath = request.getServletPath();
		DefaultResopnseBean<ZxPrinterManager> resopnseBean = new DefaultResopnseBean<ZxPrinterManager>();
		resopnseBean.setData(printerService.prinerInfo(code));
		return resopnseBean;
	}

	@ApiOperation(value = "打印机加入申请", notes = "打印机加入申请")
	@RequestMapping(value = "/apply/{code}", method = RequestMethod.GET)
	@ResponseBody
	public DefaultResopnseBean<Object> printApply(@ApiParam("打印机code") @PathVariable("code") String code,
			HttpServletRequest request) {
		servletPath = request.getServletPath();
		DefaultResopnseBean<Object> resopnseBean = new DefaultResopnseBean<Object>();

		if (!zxUserPrinterApplyService.add(code, request)) {
			resopnseBean.setCode(ErrorsEnum.SYSTEM_CUSTOM_ERROR.code);
			resopnseBean.setMessage(ErrorsEnum.SYSTEM_CUSTOM_ERROR.label);
		}
		return resopnseBean;
	}

	@ApiOperation(value = "退出打印机", notes = "退出打印机")
	@RequestMapping(value = "/out/{code}", method = RequestMethod.GET)
	@ResponseBody
	public DefaultResopnseBean<Object> printOut(@ApiParam("打印机code") @PathVariable("code") String code,
			HttpServletRequest request) {
		servletPath = request.getServletPath();
		DefaultResopnseBean<Object> resopnseBean = new DefaultResopnseBean<Object>();

		if (!zxUserPrinterService.update(code, request)) {
			resopnseBean.setCode(ErrorsEnum.SYSTEM_CUSTOM_ERROR.code);
			resopnseBean.setMessage(ErrorsEnum.SYSTEM_CUSTOM_ERROR.label);
		}

		return resopnseBean;
	}
}
