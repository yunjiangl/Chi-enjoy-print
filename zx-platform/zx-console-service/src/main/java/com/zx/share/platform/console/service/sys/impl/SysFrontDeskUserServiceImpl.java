package com.zx.share.platform.console.service.sys.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zx.share.platform.bean.sys.SysRole;
import com.zx.share.platform.bean.sys.SysUser;
import com.zx.share.platform.console.mapper.sys.SysBackGroundUserMapper;
import com.zx.share.platform.console.mapper.sys.SysFrontDeskUserMapper;
import com.zx.share.platform.console.service.sys.SysBackGroundUserService;
import com.zx.share.platform.console.service.sys.SysFrontDeskUserService;

@Service
public class SysFrontDeskUserServiceImpl implements SysFrontDeskUserService {

	@Autowired
	private SysFrontDeskUserMapper sysFrontDeskUserMapper;

	/**
	 * 查询出全部未删除的前台用户管理数据
	 * 
	 * @return
	 */
	@Override
	public List<SysUser> selectFrontDeskUserAll(Long roleId) {
		// TODO Auto-generated method stub
		return sysFrontDeskUserMapper.selectFrontDeskUserAll(roleId);
	}
	
	/**
	 * 禁用前台数据
	 */
	@Override
	public Integer updateFrontDeskUser(Long userId) {
		// TODO Auto-generated method stub
		return sysFrontDeskUserMapper.updateFrontDeskUser(userId);
	}
	/**
	 * 模糊查询
	 */

	@Override
	public List<SysUser> selectFrontDeskUserDim(String name, String perms, Date time1, Date time2) {
		// TODO Auto-generated method stub
		return sysFrontDeskUserMapper.selectFrontDeskUserDim(name, perms, time1, time2);
	}

}
