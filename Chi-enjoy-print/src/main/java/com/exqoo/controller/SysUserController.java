package com.exqoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String selectUserBackStageById(@RequestParam("userId") Long userId) {
		System.out.println(userId);
		//需要传入参数
		//List<SysUser> list=sysUserService.selectUserLawyerById(3L);
		
		return null;
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
