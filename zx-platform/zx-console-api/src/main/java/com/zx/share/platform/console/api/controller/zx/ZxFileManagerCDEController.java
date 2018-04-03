package com.zx.share.platform.console.api.controller.zx;

import java.util.HashMap;
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
import io.swagger.annotations.ApiParam;


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
	public DefaultResopnseBean<PageResponseBean<ZxFileManagerCDE>> list(
			@ApiParam("第几页") @RequestParam(name = "pageNum", required = false) Integer pageNum,
			@ApiParam("每页多少条数据") @RequestParam(name = "pageSize", required = false) Integer pageSize,
			@ApiParam("线上管理员") @RequestParam(name = "userName", required = false) String userName,
			@ApiParam("标题") @RequestParam(name = "fileName", required = false) String fileName,
			@ApiParam("开始时间") @RequestParam(name = "createTime", required = false) String createTime,
			@ApiParam("结束时间") @RequestParam(name = "updateTime", required = false) String updateTime
			) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageNum", pageNum);
		params.put("pageSize", pageSize);
		params.put("userName", userName);
		params.put("fileName", fileName);
		params.put("createTime", createTime);
		params.put(" updateTime",  updateTime);
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
	public DefaultResopnseBean<Object> delete(@RequestParam("ids") Long ids){
		return  zxFileManagerCDEService.delete(ids);
	}
	
	

}
