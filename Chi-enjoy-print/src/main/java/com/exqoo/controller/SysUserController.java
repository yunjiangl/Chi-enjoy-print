package com.exqoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.exqoo.entity.SysUser;
import com.exqoo.service.SysUserService;
/**
 * 
 * @ClassName:  SysUserController   
 * @Description:TODO(操作用户管理表)   
 * @author: 郭晓朋 
 * @date:   2018年1月16日 上午10:59:03   
 *     
 * @Copyright: 2018 
 *
 */
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
		
		return null;
	}
	/**
	 * 律师组禁用功能
	 */
	@RequestMapping(value="/sys/updateLawyerUser")
	public String updateLawyerUser() {
		sysUserService.updateLawyerUser(4L);
		
		return null;
	}
	/**
	 * 查询后台组数据
	 */
	@RequestMapping(value="/sys/selectUserBackStageById",method=RequestMethod.GET)
	public String selectUserBackStageById(Model model,@RequestParam("roleId") Long roleId) {
		//需要传入参数
		List<SysUser> list=sysUserService.selectUserLawyerById(roleId);
		model.addAttribute("UserList", list);
		
		return "/manage/admin-role";
	}
	/**
	 * 后台数据单行查询
	 */
	@RequestMapping(value="/sys/selectUserById")
	public String selectUserById(Model model,@RequestParam("userId") Long userId) {
		SysUser sysUser=sysUserService.selectUserById(userId);
		model.addAttribute("sysUser", sysUser);
		return "/manage/add-background-user";
	}
	/**
	 * 后台数据修改
	 */
	@RequestMapping(value="/sys/updateUserBackstage")
	public String updateUserBackstage(Model model,
									  @RequestParam("userId") Long userId,
									  @RequestParam("username") String username,
									  @RequestParam("nickname") String nickname,
									  @RequestParam("password") String password,
									  @RequestParam("email") String email,
									  @RequestParam("status") Byte status,
									  @RequestParam("remarks") String remarks) {
		SysUser sysUser=new SysUser();
		sysUser.setUserId(userId);
		sysUser.setUsername(username);
		sysUser.setNickname(nickname);
		sysUser.setPassword(password);
		sysUser.setEmail(email);
		sysUser.setStatus(status);
		sysUser.setRemarks(remarks);
		sysUserService.updateBackstage(sysUser);
		List<SysUser> list=sysUserService.selectUserLawyerById(3L);
		model.addAttribute("UserList", list);
		return "/manage/admin-role";
	}
	/**
	 * 后台组禁用功能
	 */
	@RequestMapping(value="/sys/updateBackstage")
	public String updateBackstage(Model model,@RequestParam("userId") Long userId) {
		sysUserService.updateLawyerUser(userId);
		List<SysUser> list=sysUserService.selectUserLawyerById(3L);
		model.addAttribute("UserList", list);
		return "/manage/admin-role";
	}
	/**
	 * 查询前台组数据
	 */
	@RequestMapping(value="/sys/selectUserReceptionById",method=RequestMethod.GET)
	public String selectUserReceptionById() {
		//需要传入参数
		List<SysUser> list=sysUserService.selectUserLawyerById(4L);
		
		return null;
	}
	/**
	 * 查询物主组数据
	 */
	@RequestMapping(value="/sys/selectUserOwnerById",method=RequestMethod.GET)
	public String selectUserOwnerById() {
		//需要传入参数
		List<SysUser> list=sysUserService.selectUserLawyerById(5L);
		
		return null;
	}
}
