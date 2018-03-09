package com.zx.share.platform.console.api.controller.zx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zx.share.platform.bean.zx.ZxFileManagerAB;
import com.zx.share.platform.bean.zx.ZxPrinterManager;
import com.zx.share.platform.console.service.zx.ZxFileManagerABService;
import com.zx.share.platform.util.annotation.ACSPermissions;
import com.zx.share.platform.util.response.DefaultResopnseBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("后台文件管理接口")
@RequestMapping("zx/ab/")
public class ZxFileManagerABController {

	@Autowired
	private ZxFileManagerABService zxFileManagerABService;
	
	/**
	 * 
	 * @Title: add
	 * @Description: 添加设备
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ApiOperation(value = "添加文件管理分类", notes = "添加文件管理分类")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", dataType = "ZxFileManagerAB", name = "zxAB", value = "文件分类管理", required = true) })
	@ACSPermissions(permissions = "zx:ab:add")
	public DefaultResopnseBean<Object> add(@RequestBody ZxFileManagerAB zxAB) {
		 return  zxFileManagerABService.add(zxAB);
	}
}
