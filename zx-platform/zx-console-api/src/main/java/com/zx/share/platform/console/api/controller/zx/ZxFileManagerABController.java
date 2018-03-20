package com.zx.share.platform.console.api.controller.zx;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zx.share.platform.bean.zx.ZxFileManagerAB;
import com.zx.share.platform.bean.zx.ZxPrinterManager;
import com.zx.share.platform.console.service.zx.ZxFileManagerABService;
import com.zx.share.platform.util.annotation.ACSPermissions;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

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
	 * @Description: 添加文件分类
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ApiOperation(value = "添加文件管理分类", notes = "添加文件管理分类")
	@ApiImplicitParams({
	@ApiImplicitParam(paramType = "body", dataType = "ZxFileManagerAB", name = "zxAB", value = "文件分类管理", required = true) })
	@ACSPermissions(permissions = "zx:ab:add")
	public DefaultResopnseBean<Object> add(@RequestBody ZxFileManagerAB zxAB) {
		 return  zxFileManagerABService.add(zxAB);
	}
	
	/**
	 * 
	 * @Title: list
	 * @Description: 文件分类列表
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ApiOperation(value = "文件分类列表", notes = "文件分类列表")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", dataType = "Map", name = "params", value = "查询信息", required = true) })
	@ACSPermissions(permissions = "zx:ab:list")
	public DefaultResopnseBean<PageResponseBean<ZxFileManagerAB>> list(@RequestBody Map<String, Object> params) {
		return zxFileManagerABService.list(params);
	}
	
	/**
	 * 
	 * @param Id
	 * @Description: 删除文件
	 * @return
	 */
	@RequestMapping(value="/sys/deleteUserById",method=RequestMethod.GET)
	@ApiOperation(value="删除文件",notes="删除文件")
	@ACSPermissions(permissions = "zx:ab:delete")
	public DefaultResopnseBean<Object> delete(@RequestParam("Id") Long Id){
		return  zxFileManagerABService.delete(Id);
	}
}
