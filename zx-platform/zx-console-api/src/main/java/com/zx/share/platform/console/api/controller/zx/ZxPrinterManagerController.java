package com.zx.share.platform.console.api.controller.zx;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zx.share.platform.bean.zx.ZxPrinterManager;
import com.zx.share.platform.console.service.zx.ZxPrinterManagerService;
import com.zx.share.platform.util.annotation.ACSPermissions;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName: ZxPrinterManagerController
 * @Description: 打印机管理接口
 * @author 芸江
 * @date 2018年1月30日 上午9:25:38
 *
 */
@RestController
@Api("打印机管理接口")
@RequestMapping("zx/pm/")
public class ZxPrinterManagerController {

	@Autowired
	private ZxPrinterManagerService zxPrinterManagerService;

	/**
	 * 
	 * @Title: add
	 * @Description: 添加设备
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ApiOperation(value = "添加打印机设备", notes = "添加打印机设备")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", dataType = "ZxPrinterManager", name = "zxPM", value = "设备信息", required = true) })
	@ACSPermissions(permissions = "zx:pm:add")
	public DefaultResopnseBean<Object> add(@RequestBody ZxPrinterManager zxPM) {
		
		 
		 return  zxPrinterManagerService.add(zxPM);
	}

	/**
	 * 
	 * @Title: list
	 * @Description: 设备列表
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ApiOperation(value = "设备列表", notes = "设备列表")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", dataType = "Map", name = "params", value = "查询信息", required = true) })
	@ACSPermissions(permissions = "zx:pm:list")
	public DefaultResopnseBean<PageResponseBean<ZxPrinterManager>> list(@RequestBody Map<String, Object> params) {
		return zxPrinterManagerService.list(params);
	}
	
	/**
	 * 
	 * @Title: info
	 * @Description: 设备信息
	 */
	@RequestMapping(value = "info/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "设备信息", notes = "设备信息")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path", dataType = "Long", name = "id", value = "设备id", required = true) })
	@ACSPermissions(permissions = "zx:pm:info")
	public DefaultResopnseBean<Object> info(@PathVariable(name = "id") Long id){
		return zxPrinterManagerService.queryByZxPMId(id);
	}
}
