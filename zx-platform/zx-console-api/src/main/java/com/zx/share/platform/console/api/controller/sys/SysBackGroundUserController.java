package com.zx.share.platform.console.api.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zx.share.platform.bean.sys.SysUser;
import com.zx.share.platform.console.service.sys.SysBackGroundUserService;
import com.zx.share.platform.util.annotation.ACSPermissions;

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
	public ResponseEntity<Map<String, Object>> selectUserAll(Long roleId){
		List<SysUser> list=sysBackGroundUserService.selectUserAll(roleId);
		Map<String, Object> map = new HashMap<>();
		map.put("selectUserAll", list);
		return ResponseEntity.ok(map);
	}
}
