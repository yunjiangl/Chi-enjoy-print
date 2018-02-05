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
import com.zx.share.platform.console.mapper.sys.SysOwnerUserMapper;
import com.zx.share.platform.console.service.sys.SysBackGroundUserService;
import com.zx.share.platform.console.service.sys.SysFrontDeskUserService;
import com.zx.share.platform.console.service.sys.SysOwnerUserService;

@Service
public class SysOwnerUserServiceImpl implements SysOwnerUserService {

	@Autowired
	private SysOwnerUserMapper SysOwnerUserMapper;

	/**
	 * 查询出全部未删除的前台用户管理数据
	 * 
	 * @return
	 */
	@Override
	public List<SysUser> selectOwnerUserAll(Long roleId) {
		// TODO Auto-generated method stub
		return SysOwnerUserMapper.selectOwnerUserAll(roleId);
	}
	
	/**
	 * 禁用前台数据
	 */
	@Override
	public Integer updateOwnerUser(Long userId) {
		// TODO Auto-generated method stub
		return SysOwnerUserMapper.updateOwnerUser(userId);
	}
	/**
	 * 模糊查询
	 */

	@Override
	public List<SysUser> selectOwnerUserDim(String name, String perms, Date time1, Date time2) {
		// TODO Auto-generated method stub
		return SysOwnerUserMapper.selectOwnerUserDim(name, perms, time1, time2);
	}
	
	/**
	 * 修改物主用户管理数据
	 */
	@Override
	public Integer updateOwnerUserById(Long id, String userName, String salt, String password, String email, Boolean isLock,
			String comment, Long roleId) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		params.put("userName", userName);
		params.put("salt", salt);
		params.put("password", password);
		params.put("email", email);
		params.put("isLock", isLock);
		params.put("comment", comment);
		params.put("roleId", roleId);
		return SysOwnerUserMapper.updateOwnerUserById(params);
	}
}
