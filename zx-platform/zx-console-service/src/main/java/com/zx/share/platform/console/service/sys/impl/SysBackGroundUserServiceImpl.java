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
import com.zx.share.platform.console.service.sys.SysBackGroundUserService;

@Service
public class SysBackGroundUserServiceImpl implements SysBackGroundUserService {

	@Autowired
	private SysBackGroundUserMapper sysBackGroundUserMapper;

	/**
	 * 查询出全部未删除的后台用户管理数据
	 * 
	 * @return
	 */
	@Override
	public List<SysUser> selectUserAll(Long roleId) {
		// TODO Auto-generated method stub
		return sysBackGroundUserMapper.selectUserAll(roleId);
	}

	/**
	 * 修改后台用户管理数据
	 */
	@Override
	public Integer updateUserById(Long id, String userName, String salt, String password, String email, Boolean isLock,
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
		return sysBackGroundUserMapper.updateUserById(params);
	}
	
	/**
	 * 刪除后台用户管理数据
	 */
	@Override
	public Integer deleteUserById(Long userId) {
		// TODO Auto-generated method stub
		return sysBackGroundUserMapper.deleteUserById(userId);
	}
	/**
	 * 模糊查询
	 */

	@Override
	public List<SysUser> selectUserDim(String name, Boolean isLock, Date time1, Date time2) {
		// TODO Auto-generated method stub
		return sysBackGroundUserMapper.selectUserDim(name, isLock, time1, time2);
	}
	/**
	 * 后台用户管理增添用户
	 */
	@Override
	public Integer insertUsers(String userName, String realName, String password, String email, Boolean isLock,
			String comment) {
		// TODO Auto-generated method stub
		return sysBackGroundUserMapper.insertUsers(userName, realName, password, email, isLock, comment);
	}
	
	/**
	 * 单行查询
	 */
	@Override
	public SysUser Select(String userName) {
		// TODO Auto-generated method stub
		return sysBackGroundUserMapper.Select(userName);
	}
	
	
	

}
