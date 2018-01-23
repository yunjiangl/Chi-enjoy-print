package com.zx.share.platform.zxservice.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exqoo.dao.SysRoleDao;
import com.exqoo.entity.SysRole;
import com.exqoo.service.SysRoleService;

@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleDao sysRoleDao;

	/**
	 * 查询用户组所以数据
	 */
	@Override
	public List<SysRole> selectRoleAll() {
		// TODO Auto-generated method stub
		return sysRoleDao.selectAll();
	}

	/**
	 * 单行查询
	 */

	@Override
	public SysRole selectRoleById(Long roleId) {
		return sysRoleDao.selectByPrimaryKey(roleId);
	}
	/**
	 * 添加用户组
	 */

	@Override
	public Integer insertRoll(SysRole sysRole) {
		// TODO Auto-generated method stub
		return sysRoleDao.insert(sysRole);
	}
	
	/**
	 * 修改数据
	 */
	@Override
	public Integer updateRole(SysRole sysRole) {
		// TODO Auto-generated method stub
		return sysRoleDao.updateByPrimaryKey(sysRole);
	}
	/**
	 * 模糊查询
	 */

	@Override
	public List<SysRole> selectDim(String roleName, Byte status, String time1, String time2) {
		// TODO Auto-generated method stub
		return sysRoleDao.selectDim(roleName, status, time1, time2);
	}
	
	
	
	

}
