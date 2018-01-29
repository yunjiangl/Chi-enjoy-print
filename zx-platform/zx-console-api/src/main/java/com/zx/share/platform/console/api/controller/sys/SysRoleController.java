package com.zx.share.platform.console.api.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zx.share.platform.bean.sys.SysRole;
import com.zx.share.platform.console.service.sys.SysRoleService;
import com.zx.share.platform.util.annotation.ACSPermissions;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("用户組管理接口")
public class SysRoleController {

	@Autowired
	private SysRoleService sysRoleService;

	@RequestMapping(value = "/sys/selectRoleAll", method = RequestMethod.GET)
	@ApiOperation(value = "用户組管理", notes = "获取用户組管理列表")
	@ACSPermissions(permissions = "role:list")
	public ResponseEntity<Map<String, Object>> selectRoleAll() {
		List<SysRole> list = sysRoleService.selectRoleAll();
		list.get(0).getModifyTime();
		System.out.println(list);
		Map<String, Object> map = new HashMap<>();
		map.put("data", list);
		return ResponseEntity.ok(map);
	}
}
