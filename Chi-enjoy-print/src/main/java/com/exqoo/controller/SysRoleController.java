package com.exqoo.controller;

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
}
