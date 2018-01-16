package com.exqoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exqoo.entity.SysUser;
import com.exqoo.service.SysUserService;

@Controller
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;
	/**
	 * 查询律师组数据
	 * @return
	 */
	@RequestMapping(value="/sys/selectUserLawyerById",method=RequestMethod.GET)
	public String selectUserLawyerById() {
		//需要传入参数
		List<SysUser> list=sysUserService.selectUserLawyerById(2L);
		System.out.println(list);
		return null;
	}
}
