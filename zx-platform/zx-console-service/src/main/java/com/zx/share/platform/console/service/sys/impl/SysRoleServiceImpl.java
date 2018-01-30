package com.zx.share.platform.console.service.sys.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zx.share.platform.bean.sys.SysRole;
import com.zx.share.platform.console.mapper.sys.SysRoleMapper;
import com.zx.share.platform.console.service.sys.SysRoleService;

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
	
	/**
	 * 单行查询
	 */

	@Override
	public SysRole selectRoleById(Long roleId) {
		return sysRoleMapper.selectByPrimaryKey(roleId);
	}
	/**
	 * 添加用户组
	 */

	@Override
	public Integer insertRoll(SysRole sysRole) {
		// TODO Auto-generated method stub
		return sysRoleMapper.insert(sysRole);
	}
	
	/**
	 * 修改数据
	 */
	@Override
	public Integer updateRole(SysRole sysRole) {
		// TODO Auto-generated method stub
		return sysRoleMapper.updateByPrimaryKey(sysRole);
	}
	/**
	 * 模糊查询
	 */

	@Override
	public List<SysRole> selectDim(String name, String perms, Date time1, Date time2) {
		// TODO Auto-generated method stub
		return sysRoleMapper.selectDim(name, perms, time1, time2);
	}
}
