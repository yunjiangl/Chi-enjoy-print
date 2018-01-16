package com.exqoo.controller;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exqoo.entity.SysRole;
import com.exqoo.service.SysRoleService;


@Controller
public class SysRoleController {
	@Autowired
	private SysRoleService sysRoleService;
	/**
	 * 查询用户组所以数据
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/sys/selectRoleAll", method = RequestMethod.GET)
	public String selectRoleAll(Model model) {
		List<SysRole> list=sysRoleService.selectRoleAll();
		System.out.println(list);
		model.addAttribute("RoleList", list);

		return null;
	}
	/**
	 * 添加用户组
	 */
	@RequestMapping(value = "/sys/insertRole", method = RequestMethod.GET)
	public String insertRole() {
		SysRole sysRole=new SysRole();
		sysRole.setRoleName("hello");
		sysRole.setStatus((byte) 1);
		sysRole.setCreateTime(new Date());
		sysRoleService.insertRoll(sysRole);
		return null;
	}
	/**
	 * 单行查询
	 */
	@RequestMapping(value="/sys/selectRoleById")
	public String selectRoleById() {
		SysRole sysRole=sysRoleService.selectRoleById(2L);
		System.out.println(sysRole);
		return null;
	}
	/**
	 * 修改数据
	 */
	@RequestMapping(value="/sys/updateRole")
	public String updateRole() {
		SysRole sysRole=new SysRole();
		sysRole.setRoleId(6L);
		sysRole.setRoleName("hello1");
		sysRole.setStatus((byte) 1);
		sysRole.setCreateTime(new Date());
		sysRoleService.updateRole(sysRole);
		return null;
	}
}
