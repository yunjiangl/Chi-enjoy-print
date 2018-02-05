package com.zx.share.platform.console.api.controller.sys;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zx.share.platform.bean.sys.SysRole;
import com.zx.share.platform.bean.sys.SysUser;
import com.zx.share.platform.console.service.sys.SysBackGroundUserService;
import com.zx.share.platform.console.service.sys.SysFrontDeskUserService;
import com.zx.share.platform.console.service.sys.SysOwnerUserService;
import com.zx.share.platform.util.annotation.ACSPermissions;
import com.zx.share.platform.util.response.DefaultResopnseBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("物主用户管理接口")
public class SysOwnerUserController {

	@Autowired
	private SysOwnerUserService sysOwnerUserService;
	
	/**
	 * 查询出全部未删除的物主用户管理数据
	 */
	@RequestMapping(value="/sys/selectOwnerUserAll",method=RequestMethod.GET)
	@ApiOperation(value="查询物主用户管理所有数据",notes="物主用户管理")
	@ACSPermissions(permissions = "user:list")
	public DefaultResopnseBean<List<SysUser>> selectOwnerUserAll(){
		List<SysUser> list=sysOwnerUserService.selectOwnerUserAll(4L);
		return new DefaultResopnseBean<List<SysUser>>("成功",200,list);
	}
	
	/**
	 * 禁用物主用户管理数据
	 */
	@RequestMapping(value="/sys/updateOwnerUser",method=RequestMethod.POST)
	@ApiOperation(value="禁用物主用户管理数据",notes="物主用户管理")
	@ACSPermissions(permissions = "user:Integer")
	@ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long", name = "userId", value = "当前用户组ID", required = true)})
	public DefaultResopnseBean<Object> updateOwnerUser(Long userId){
		Integer updateUserInt=sysOwnerUserService.updateOwnerUser(userId);
		return new DefaultResopnseBean<Object>("成功",200,updateUserInt);
	}
	/**
	 * 物主管理条件式查询（模糊查询）
	 * name 查询用户组的名字
	 * perms 当前用户组状态（可用，禁用）
	 * time1 开始时间
	 * time2 结束时间
	 */
	@RequestMapping(value="/sys/selectOwnerUserDim",method=RequestMethod.POST)
	@ApiOperation(value="模糊查询物主用户组管理数据",notes="物主组管理")
	@ACSPermissions(permissions = "role:list")
	@ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "name", value = "查询用户组的名字", required = false),
						@ApiImplicitParam(paramType = "query", dataType = "String", name = "perms", value = "当前用户组状态（可用，禁用）", required = false),
						@ApiImplicitParam(paramType = "query", dataType = "Date", name = "time1", value = "开始时间", required = false),
						@ApiImplicitParam(paramType = "query", dataType = "Date", name = "time2", value = "截至时间）", required = false)})
	public DefaultResopnseBean<List<SysUser>> selectOwnerUserDim(String name,String perms,Date time1,Date time2){
		List<SysUser> list=sysOwnerUserService.selectOwnerUserDim(name, perms, time1, time2);
		return new DefaultResopnseBean<List<SysUser>>("成功",200,list);
	}
	/**
	 * 修改物主用户管理数据
	 */
	@RequestMapping(value="/sys/updateOwnerUserById",method=RequestMethod.POST)
	@ApiOperation(value="修改后台用户管理数据",notes="后台用户管理")
	@ACSPermissions(permissions = "user:Integer")
	@ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "当前用户组ID", required = true),
						@ApiImplicitParam(paramType = "query", dataType = "String", name = "userName", value = "用户名", required = true),
						@ApiImplicitParam(paramType = "query", dataType = "String", name = "salt", value = "昵称", required = false),
						@ApiImplicitParam(paramType = "query", dataType = "String", name = "password", value = "密码", required = true),
						@ApiImplicitParam(paramType = "query", dataType = "String", name = "email", value = "邮箱", required = false),
						@ApiImplicitParam(paramType = "query", dataType = "Boolean", name = "isLock", value = "状态", required = true),
						@ApiImplicitParam(paramType = "query", dataType = "String", name = "comment", value = "备注", required = true),
						@ApiImplicitParam(paramType = "query", dataType = "Long", name = "roleId", value = "所属用户组", required = true)})
	public DefaultResopnseBean<Object> updateOwnerUserById(Long id,String userName,String salt,String password,String email,Boolean isLock,
															  String comment,Long roleId){
		Integer updateUserInt=sysOwnerUserService.updateOwnerUserById(id, userName, salt, password, email, isLock, comment, roleId);
		return new DefaultResopnseBean<Object>("成功",200,updateUserInt);
	}
}
