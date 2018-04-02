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
import com.zx.share.platform.console.service.sys.SysRoleService;
import com.zx.share.platform.util.DateUtil;
import com.zx.share.platform.util.annotation.ACSPermissions;
import com.zx.share.platform.util.response.DefaultResopnseBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("后台用户管理接口")
public class SysBackGroundUserController {

	@Autowired
	private SysBackGroundUserService sysBackGroundUserService;
	@Autowired
	private SysRoleService sysRoleService;
	
	/**
	 * 询出全部未删除的后台用户管理数据
	 */
	@RequestMapping(value="/sys/selectUserAll",method=RequestMethod.GET)
	@ApiOperation(value="查询后台用户管理所有数据",notes="后台用户管理")
	@ACSPermissions(permissions = "user:list")
	@ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long", name = "roleId", value = "用户组ID", required = true)})
	public DefaultResopnseBean<List<SysUser>> selectUserAll(Long roleId){
		List<SysUser> list=sysBackGroundUserService.selectUserAll(roleId);
		return new DefaultResopnseBean<List<SysUser>>("成功",200,list);
	}
	
	/**
	 * 修改后台用户管理数据
	 */
	@RequestMapping(value="/sys/updateUserById",method=RequestMethod.POST)
	@ApiOperation(value="修改后台用户管理数据",notes="后台用户管理")
	@ACSPermissions(permissions = "user:Integer")
	@ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "当前用户组ID", required = true),
						@ApiImplicitParam(paramType = "query", dataType = "String", name = "userName", value = "用户名", required = true),
						@ApiImplicitParam(paramType = "query", dataType = "String", name = "realName", value = "昵称", required = false),
						@ApiImplicitParam(paramType = "query", dataType = "String", name = "password", value = "密码", required = true),
						@ApiImplicitParam(paramType = "query", dataType = "String", name = "email", value = "邮箱", required = false),
						@ApiImplicitParam(paramType = "query", dataType = "Boolean", name = "isLock", value = "状态", required = true),
						@ApiImplicitParam(paramType = "query", dataType = "String", name = "comment", value = "备注", required = true),
						@ApiImplicitParam(paramType = "query", dataType = "Long", name = "roleId", value = "所属用户组", required = true)})
	public DefaultResopnseBean<Object> updateUserById(Long id,String userName,String realName,String password,String email,Boolean isLock,
															  String comment,Long roleId){
		Integer updateUserInt=sysBackGroundUserService.updateUserById(id, userName, realName, password, email, isLock, comment, roleId);
		return new DefaultResopnseBean<Object>("成功",200,updateUserInt);
	}
	
	/**
	 * 增添后台用户管理数据
	 */
	@RequestMapping(value="/sys/insertUsers",method=RequestMethod.POST)
	@ApiOperation(value="增添后台用户管理数据",notes="后台用户管理")
	@ACSPermissions(permissions = "user:Integer")
	@ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "userName", value = "用户名", required = true),
						@ApiImplicitParam(paramType = "query", dataType = "String", name = "realName", value = "昵称", required = true),
						@ApiImplicitParam(paramType = "query", dataType = "String", name = "password", value = "密码", required = false),
						@ApiImplicitParam(paramType = "query", dataType = "String", name = "email", value = "邮箱", required = false),
						@ApiImplicitParam(paramType = "query", dataType = "Boolean", name = "isLock", value = "状态", required = true),
						@ApiImplicitParam(paramType = "query", dataType = "Boolean", name = "isDel", value = "删除状态(falase显示true不显示)", required = true),
						@ApiImplicitParam(paramType = "query", dataType = "String", name = "comment", value = "备注", required = true),
						@ApiImplicitParam(paramType = "query", dataType = "Long", name = "roleId", value = "所属用户组", required = true)})
	public DefaultResopnseBean<Object> insertUsers(String userName,String realName,String password,String email,Boolean isLock,Boolean isDel,
															  String comment,Long roleId){
		
		Integer updateUserInt=sysBackGroundUserService.insertUsers(userName, realName, password, email, isLock, isDel,comment);
		SysUser sysUser=sysBackGroundUserService.Select(userName);
		Long userId=sysUser.getId();
		System.out.println(userId);
		System.out.println(roleId);
		Date createTime=new Date();
		sysRoleService.insertRole(userId, roleId, createTime);
		return new DefaultResopnseBean<Object>("成功",200,updateUserInt);
	}
	/**
	 * 刪除后台用户管理数据
	 * 
	 * 修改后台数据is_del
	 */
	@RequestMapping(value="/sys/deleteUserById",method=RequestMethod.GET)
	@ApiOperation(value="删除后台用户管理数据",notes="用户组管理")
	@ACSPermissions(permissions = "role:Integer")
	public DefaultResopnseBean<Object> deleteUserById(@RequestParam("userId") Long userId){
		
		Integer deleteUserInt=sysBackGroundUserService.deleteUserById(userId);
		return new DefaultResopnseBean<Object>("成功",200,deleteUserInt);
	}
	/**
	 * 用户组管理条件式查询（模糊查询）
	 * name 查询用户组的名字
	 * perms 当前用户组状态（可用，禁用）
	 * time1 开始时间
	 * time2 结束时间
	 */
	@RequestMapping(value="/sys/selectUserDim",method=RequestMethod.GET)
	@ApiOperation(value="模糊查询后台用户组管理数据",notes="用户组管理")
	@ACSPermissions(permissions = "role:list")
	@ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "name", value = "查询用户组的名字", required = false),
						@ApiImplicitParam(paramType = "query", dataType = "Boolean", name = "isLock", value = "当前用户组状态（可用，禁用）", required = false),
						@ApiImplicitParam(paramType = "query", dataType = "String", name = "time3", value = "开始时间", required = false),
						@ApiImplicitParam(paramType = "query", dataType = "String", name = "time4", value = "截至时间）", required = false)})
	public DefaultResopnseBean<List<SysUser>> selectUserDim(String name,Boolean isLock,String time3,String time4){
		Date time1=DateUtil.getDateFromStr(time3);
		Date time2=DateUtil.getDateFromStr(time4);
		List<SysUser> list=sysBackGroundUserService.selectUserDim(name, isLock, time1, time2);
		return new DefaultResopnseBean<List<SysUser>>("成功",200,list);
	}
}
