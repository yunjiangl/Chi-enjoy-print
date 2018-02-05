package com.zx.share.platform.console.api.controller.zx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zx.share.platform.bean.zx.ZxUserPrinter;
import com.zx.share.platform.console.service.zx.ZxUserPrinterService;
import com.zx.share.platform.util.annotation.ACSPermissions;
import com.zx.share.platform.util.response.DefaultResopnseBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName: ZxUserPrinterController
 * @Description: 设备线上管理员接口
 * @author 芸江
 * @date 2018年2月1日 上午10:14:10
 *
 */
@RestController
@Api("设备线上管理员接口")
@RequestMapping("zx/up/")
public class ZxUserPrinterController {

	@Autowired
	private ZxUserPrinterService zxUserPrinterService;

	/**
	 * 
	 * @Title: update
	 * @Description: 改变线上管理员信息
	 */
	@RequestMapping(value = "updata", method = RequestMethod.PUT)
	@ApiOperation(value = "修改线上管理员信息", notes = "修改线上管理员信息")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", dataType = "ZxUserPrinter", name = "zxUP", value = "线上管理员信息", required = true) })
	@ACSPermissions(permissions = "zx:up:updata")
	public DefaultResopnseBean<Object> update(@RequestBody ZxUserPrinter zxUP) {

		return zxUserPrinterService.update(zxUP);

	}

	/**
	 * 
	 * @Title: add
	 * @Description: 添加线上管理员
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ApiOperation(value = "添加线上管理员", notes = "添加线上管理员信息")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", dataType = "ZxUserPrinter", name = "zxUP", value = "线上管理员信息", required = true) })
	@ACSPermissions(permissions = "zx:up:add")
	public DefaultResopnseBean<Object> add(@RequestBody ZxUserPrinter zxUP) {

		return zxUserPrinterService.add(zxUP);

	}

	/**
	 * 
	 * @Title: querByZxUP
	 * @Description: 查询线上管理信息
	 */
	@RequestMapping(value = "query", method = RequestMethod.POST)
	@ApiOperation(value = "查询", notes = "查询线上管理员信息")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", dataType = "ZxUserPrinter", name = "zxUP", value = "查询条件", required = true) })
	@ACSPermissions(permissions = "zx:up:info")
	public DefaultResopnseBean<Object> querByZxUP(@RequestBody ZxUserPrinter zxUP) {

		return zxUserPrinterService.query(zxUP);

	}

}
