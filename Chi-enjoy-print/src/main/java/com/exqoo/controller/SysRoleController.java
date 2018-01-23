package com.exqoo.controller;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.exqoo.entity.SysRole;
import com.exqoo.service.SysRoleService;
/**
 * 
 * @ClassName:  SysRoleController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 郭晓朋 
 * @date:   2018年1月16日 下午2:06:39   
 *     
 * @Copyright: 2018 
 *
 */

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
		model.addAttribute("RoleList", list);

		return "/manage/admin-list";
	}
	/**
	 * 添加用户组
	 */
	@RequestMapping(value = "/sys/insertRole", method = RequestMethod.GET)
	public String insertRole(Model model,
							 @RequestParam("roleName") String roleName,
							 @RequestParam("status") Byte status) {
		SysRole sysRole=new SysRole();
		sysRole.setRoleName(roleName);
		sysRole.setStatus(status);
		Date time=new Date();
		/**
		 * 此处有BUG  时间问题
		 */
		sysRole.setCreateTime(time+"");
		sysRoleService.insertRoll(sysRole);
		List<SysRole> list=sysRoleService.selectRoleAll();
		model.addAttribute("RoleList", list);
		return "/manage/admin-list";
	}
	/**
	 * 跳转到updateUser.jsp
	 */
	@RequestMapping(value="/sys/updateUser")
	public String updateUser(@RequestParam("roleId") Long roleId) {
		System.out.println(roleId);
		System.out.println(111);
		return "/manage/updateUser";
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
	public String updateRole(Model model,@RequestParam("roleId") Long roleId) {
		SysRole sysRole=sysRoleService.selectRoleById(roleId);
		model.addAttribute("sysRole", sysRole);
		//SysRole sysRole=new SysRole();
		//sysRole.setRoleId(6L);
		//sysRole.setRoleName("hello1");
		//sysRole.setStatus((byte) 1);
		//sysRole.setCreateTime(new Date());
		//sysRoleService.updateRole(sysRole);
		return "/manage/updateUser";
	}
	@RequestMapping(value="/sys/updateData")
	public String updateData(Model model,@RequestParam("roleId") Long roleId,
										 @RequestParam("roleName") String roleName,
										 @RequestParam("status") Byte status,
										 @RequestParam("createTime") String createTime) {
		
		SysRole sysRole=new SysRole();
		sysRole.setRoleId(roleId);
		sysRole.setRoleName(roleName);
		sysRole.setStatus(status);
		sysRole.setCreateTime(createTime);
		sysRoleService.updateRole(sysRole);
		List<SysRole> list=sysRoleService.selectRoleAll();
		model.addAttribute("RoleList", list);
		return "/manage/admin-list";
	}
	/**
	 * 跳转设置权限
	 */
	@RequestMapping(value="/sys/jurisdiction")
	public String jurisdiction() {
		
		return "/manage/user-power";
	}
	/**
	 * 模糊查询
	 */
	@RequestMapping(value="/sys/selectDim")
	public String selectDim(Model model,@Param("roleName") String roleName,
										@Param("status") Byte status,
										@Param("time1") String time1,
										@Param("time2") String time2) {
		List<SysRole> list=sysRoleService.selectDim(roleName, status, time1, time2);
		model.addAttribute("RoleList", list);
		return "/manage/admin-list";
	}
}
