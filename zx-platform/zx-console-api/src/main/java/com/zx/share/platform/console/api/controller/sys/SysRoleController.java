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
import com.zx.share.platform.console.service.sys.SysRoleService;
import com.zx.share.platform.util.annotation.ACSPermissions;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("用户組管理接口")
public class SysRoleController {

	@Autowired
	private SysRoleService sysRoleService;
	
	/**
	 * 查询用户组管理所有数据
	 * @return
	 */
	@RequestMapping(value = "/sys/selectRoleAll", method = RequestMethod.GET)
	@ApiOperation(value = "获取用户組管理列表", notes = "用户組管理")
	@ACSPermissions(permissions = "role:list")
	public ResponseEntity<Map<String, Object>> selectRoleAll() {
		List<SysRole> list = sysRoleService.selectRoleAll();
		list.get(0).getModifyTime();
		Map<String, Object> map = new HashMap<>();
		map.put("data", list);
		return ResponseEntity.ok(map);
	}
	
	/**
	 * 单行查询用户组管理数据
	 */
	@RequestMapping(value="/sys/selectRoleById",method=RequestMethod.GET)
	@ApiOperation(value="获取用户组管理单行数据", notes="用户组管理")
	@ACSPermissions(permissions = "role:Sysrole")
	public  ResponseEntity<Map<String, Object>> selectRoleById(@RequestParam("roleId") Long roleId){
		SysRole sysRole=sysRoleService.selectRoleById(roleId);
		Map<String, Object> map = new HashMap<>();
		map.put("singleRole", sysRole);
		return ResponseEntity.ok(map);
		
	}
	/**
	 * 添加用户组管理数据
	 * name 用户组名称
	 * perms 当前用户组状态（启用，停用）
	 * remark 备注
	 */
	@RequestMapping(value="/sys/insertRoll",method=RequestMethod.POST)
	@ApiOperation(value="添加用户组管理数据",notes="用户组管理")
	@ACSPermissions(permissions = "role:Integer")
	public ResponseEntity<Map<String, Object>> insertRoll(@RequestParam("name") String name,
														  @RequestParam("perms") String perms,
														  @RequestParam("remark") String remark){
		SysRole sysRole=new SysRole();
		sysRole.setCreateTime(new Date());
		sysRole.setRemark(remark);
		sysRole.setName(name);
		sysRole.setPerms(perms);
		Integer insertRoleInt=sysRoleService.insertRoll(sysRole);
		Map<String, Object> map = new HashMap<>();
		map.put("insertRole", insertRoleInt);
		return ResponseEntity.ok(map);
	}
	/**
	 * 修改用户组管理数据
	 * id 当前用户组id
	 * name 需要修改的名字
	 * perms 当前用户组状态（可用，禁用）
	 * remark 备注
	 * createTime 单行查询出的创建时间 不可更改
	 */
	@RequestMapping(value="/sys/updateRole",method=RequestMethod.POST)
	@ApiOperation(value="修改用户组管理数据",notes="用户组管理")
	@ACSPermissions(permissions = "role:Integer")
	public ResponseEntity<Map<String, Object>> updateRole(@RequestParam("id") Long id,
														  @RequestParam("name") String name,
														  @RequestParam("perms") String perms,
														  @RequestParam("remark") String remark,
														  @RequestParam("createTime") Date createTime){
		SysRole sysRole=new SysRole();
		sysRole.setCreateTime(createTime);
		sysRole.setId(id);
		sysRole.setRemark(remark);
		sysRole.setName(name);
		sysRole.setPerms(perms);
		sysRole.setModifyTime(new Date());
		Integer updateRoleInt=sysRoleService.updateRole(sysRole);
		Map<String, Object> map = new HashMap<>();
		map.put("insertRole", updateRoleInt);
		return ResponseEntity.ok(map);
	}
	/**
	 * 用户组管理条件式查询（模糊查询）
	 * name 查询用户组的名字
	 * perms 当前用户组状态（可用，禁用）
	 * time1 开始时间
	 * time2 结束时间
	 */
	@RequestMapping(value="/sys/selectDim",method=RequestMethod.GET)
	@ApiOperation(value="模糊查询用户组管理数据",notes="用户组管理")
	@ACSPermissions(permissions = "role:list")
	@ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "name", value = "查询用户组的名字", required = false),
						@ApiImplicitParam(paramType = "query", dataType = "String", name = "perms", value = "当前用户组状态（可用，禁用）", required = false),
						@ApiImplicitParam(paramType = "query", dataType = "Date", name = "time1", value = "开始时间", required = false),
						@ApiImplicitParam(paramType = "query", dataType = "Date", name = "time2", value = "截至时间）", required = false)})
	public ResponseEntity<Map<String, Object>> selectDim(String name,String perms,Date time1,Date time2){
		List<SysRole> list=sysRoleService.selectDim(name, perms, time1, time2);
		Map<String, Object> map = new HashMap<>();
		map.put("singleList", list);
		return ResponseEntity.ok(map);
	}
}
