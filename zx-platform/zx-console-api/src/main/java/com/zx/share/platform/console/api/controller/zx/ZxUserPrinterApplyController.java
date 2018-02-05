package com.zx.share.platform.console.api.controller.zx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zx.share.platform.bean.zx.ZxUserPrinterApply;
import com.zx.share.platform.console.service.zx.ZxUserPrinterApplyService;
import com.zx.share.platform.util.annotation.ACSPermissions;
import com.zx.share.platform.util.response.DefaultResopnseBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName: ZxUserPrinterApplyController
 * @Description: 设备线上管理员申请控制器
 * @author 芸江
 * @date 2018年2月5日 上午9:32:43
 *
 */
@RestController
@RequestMapping("zx/upa/")
@Api("设备线上管理员申请接口")
public class ZxUserPrinterApplyController {

	@Autowired
	private ZxUserPrinterApplyService zxUserPrinterApplyService;

	/**
	 * 
	 * @Title: update
	 * @Description: 改变线上管理员申请信息
	 */
	@RequestMapping(value = "updata", method = RequestMethod.PUT)
	@ApiOperation(value = "修改", notes = "修改线上管理员申请信息")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", dataType = "ZxUserPrinterApply", name = "zxUPA", value = "线上管理员申请信息", required = true) })
	@ACSPermissions(permissions = "zx:upa:updata")
	public DefaultResopnseBean<Object> update(@RequestBody ZxUserPrinterApply zxUPA) {

		return zxUserPrinterApplyService.update(zxUPA);

	}

	/**
	 * 
	 * @Title: add
	 * @Description: 添加线上管理员申请
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ApiOperation(value = "添加", notes = "添加线上管理员申请信息")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", dataType = "ZxUserPrinterApply", name = "zxUPA", value = "线上管理员申请信息", required = true) })
	@ACSPermissions(permissions = "zx:upa:add")
	public DefaultResopnseBean<Object> add(@RequestBody ZxUserPrinterApply zxUPA) {

		return zxUserPrinterApplyService.add(zxUPA);

	}

	/**
	 * 
	 * @Title: querByZxUP
	 * @Description: 查询线上管理信息
	 */
	@RequestMapping(value = "query", method = RequestMethod.POST)
	@ApiOperation(value = "查询", notes = "查询线上管理员申请信息")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", dataType = "ZxUserPrinterApply", name = "zxUPA", value = "查询条件", required = true) })
	@ACSPermissions(permissions = "zx:upa:info")
	public DefaultResopnseBean<Object> querByZxUP(@RequestBody ZxUserPrinterApply zxUPA) {

		return zxUserPrinterApplyService.query(zxUPA);

	}

}