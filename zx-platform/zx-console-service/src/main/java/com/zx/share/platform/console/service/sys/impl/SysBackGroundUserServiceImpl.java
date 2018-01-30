package com.zx.share.platform.console.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zx.share.platform.bean.sys.SysUser;
import com.zx.share.platform.console.mapper.sys.SysBackGroundUserMapper;
import com.zx.share.platform.console.service.sys.SysBackGroundUserService;

@Service
public class SysBackGroundUserServiceImpl implements SysBackGroundUserService {
	
	@Autowired
	private SysBackGroundUserMapper sysBackGroundUserMapper;
	
	
	/**
	 * 查询出全部未删除的后台用户管理数据
	 * @return
	 */
	@Override
	public List<SysUser> selectUserAll(Long roleId) {
		// TODO Auto-generated method stub
		return sysBackGroundUserMapper.selectUserAll(roleId);
	}
	
	
	
	
}
