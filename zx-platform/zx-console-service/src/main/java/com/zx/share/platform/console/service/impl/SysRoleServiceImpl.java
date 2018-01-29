package com.zx.share.platform.console.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zx.share.platform.bean.sys.SysRole;
import com.zx.share.platform.console.mapper.SysRoleMapper;
import com.zx.share.platform.console.service.SysRoleService;

@Service
public class SysRoleServiceImpl implements SysRoleService{
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@Override
	public List<SysRole> selectRoleAll() {
		// TODO Auto-generated method stub
		return sysRoleMapper.selectAll();
	}
}
