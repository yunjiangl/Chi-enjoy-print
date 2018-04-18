package com.zx.share.platform.console.api.controller.sys;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zx.share.platform.console.service.sys.SysFrontDeskUserService;
import com.zx.share.platform.util.annotation.ACSPermissions;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api("前台用户管理接口")
public class SysFrontDeskUserController {

	@Autowired
	private SysFrontDeskUserService sysFrontDeskUserService;

	/**
	 * 询出全部未删除的后台用户管理数据
	 */
	@RequestMapping(value = "/sys/selectFrontDeskUserAll", method = RequestMethod.GET)
	@ApiOperation(value = "查询前台用户管理所有数据", notes = "前台用户管理")
	@ACSPermissions(permissions = "user:list")
	public DefaultResopnseBean<PageResponseBean<SysUser>> selectFrontDeskUserAll(
			@ApiParam("第几页") @RequestParam(name = "page", required = false) Integer page,
			@ApiParam("每页多少条") @RequestParam(name = "pageSize", required = false) Integer pageSize) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("page", page);
		param.put("pageSize", pageSize);
		return sysFrontDeskUserService.selectFrontDeskUserAll(3L, param);
	}

	
	/**
	 * 禁用前台用户管理数据
	 */
	@RequestMapping(value = "/sys/updateFrontDeskUser", method = RequestMethod.POST)
	@ApiOperation(value = "禁用前台用户管理数据", notes = "前台用户管理")
	@ACSPermissions(permissions = "user:Integer")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "Long", name = "userId", value = "当前用户组ID", required = true) })
	public DefaultResopnseBean<Object> updateFrontDeskUser(Long userId) {
		Integer updateUserInt = sysFrontDeskUserService.updateFrontDeskUser(userId);
		return new DefaultResopnseBean<Object>("成功", 200, updateUserInt);
	}

	/**
	 * 用户组管理条件式查询（模糊查询） name 查询用户组的名字 perms 当前用户组状态（可用，禁用） time1 开始时间 time2 结束时间
	 */
	@RequestMapping(value = "/sys/selectFrontDeskUserDim", method = RequestMethod.POST)
	@ApiOperation(value = "模糊查询前台用户组管理数据", notes = "前台组管理")
	@ACSPermissions(permissions = "role:list")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "name", value = "查询用户组的名字", required = false),
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "perms", value = "当前用户组状态（可用，禁用）", required = false),
			@ApiImplicitParam(paramType = "query", dataType = "Date", name = "time1", value = "开始时间", required = false),
			@ApiImplicitParam(paramType = "query", dataType = "Date", name = "time2", value = "截至时间）", required = false)})
	public DefaultResopnseBean<PageResponseBean<SysUser>> selectFrontDeskUserDim(String name, String perms, Date time1,
			Date time2,@ApiParam("第几页") @RequestParam(name = "page", required = false) Integer page,
						@ApiParam("每页多少条") @RequestParam(name = "pageSize", required = false) Integer pageSize) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("page", page);
		param.put("pageSize", pageSize);
		
		
		return sysFrontDeskUserService.selectFrontDeskUserDim(name, perms, time1, time2,param);
	}
}
