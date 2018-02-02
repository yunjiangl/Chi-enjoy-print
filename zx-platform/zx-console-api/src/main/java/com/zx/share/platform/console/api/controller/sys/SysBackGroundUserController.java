package com.zx.share.platform.console.api.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zx.share.platform.bean.sys.SysUser;
import com.zx.share.platform.console.service.sys.SysBackGroundUserService;
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
						@ApiImplicitParam(paramType = "query", dataType = "String", name = "salt", value = "昵称", required = false),
						@ApiImplicitParam(paramType = "query", dataType = "String", name = "password", value = "密码", required = true),
						@ApiImplicitParam(paramType = "query", dataType = "String", name = "email", value = "邮箱", required = false),
						@ApiImplicitParam(paramType = "query", dataType = "Boolean", name = "isLock", value = "状态", required = true),
						@ApiImplicitParam(paramType = "query", dataType = "String", name = "comment", value = "备注", required = true),
						@ApiImplicitParam(paramType = "query", dataType = "Long", name = "roleId", value = "所属用户组", required = true)})
	public DefaultResopnseBean<Object> updateUserById(Long id,String userName,String salt,String password,String email,Boolean isLock,
															  String comment,Long roleId){
		Integer updateUserInt=sysBackGroundUserService.updateUserById(id, userName, salt, password, email, isLock, comment, roleId);
		return new DefaultResopnseBean<Object>("成功",200,updateUserInt);
	}
}
