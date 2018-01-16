package com.exqoo.service;
/**
 * 用户组管理
 * @author GXP
 *
 */

import java.util.List;

import com.exqoo.entity.SysRole;

public interface SysRoleService {
	/**
	 * 查询用户组所以数据
	 */
	List<SysRole> selectRoleAll();

	/**
	 * 单行查询
	 */
	SysRole selectRoleById(Long roleId);
	/**
	 * 添加用户组
	 */
	Integer insertRoll(SysRole sysRole);
	/**
	 * 修改数据
	 */
	Integer updateRole(SysRole sysRole);
}
