package com.zx.share.platform.console.api.controller.zx;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zx.share.platform.bean.zx.ZxFileManagerCDE;
import com.zx.share.platform.console.service.zx.ZxFileManagerCDEService;
import com.zx.share.platform.util.annotation.ACSPermissions;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@RestController
@Api("后台文件管理cde接口")
@RequestMapping("zx/cde/")
public class ZxFileManagerCDEController {

	@Autowired
	private ZxFileManagerCDEService zxFileManagerCDEService;
	
	/**
	 * 
	 * @Title: list
	 * @Description: 文件分类cde列表
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ApiOperation(value = "文件分类列表cde", notes = "文件分类列表cde")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", dataType = "Map", name = "params", value = "查询信息", required = true) })
	@ACSPermissions(permissions = "zx:cde:list")
	public DefaultResopnseBean<PageResponseBean<ZxFileManagerCDE>> list(@RequestBody Map<String, Object> params) {
		return zxFileManagerCDEService.list(params);
	}
	
	/**
	 * 
	 * @param Id
	 * @Description: 删除文件cde
	 * @return
	 */
	@RequestMapping(value="/sys/deleteUserById",method=RequestMethod.GET)
	@ApiOperation(value="删除文件cde",notes="删除文件cde")
	@ACSPermissions(permissions = "zx:cde:delete")
	public DefaultResopnseBean<Object> delete(@RequestParam("Id") Long Id){
		return  zxFileManagerCDEService.delete(Id);
	}
	
	

}
