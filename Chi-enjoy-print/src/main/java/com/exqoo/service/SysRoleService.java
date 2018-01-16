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
	 * 查询用户组管理数据
	 */
	SysRole selectRoleById(Long roleId);
}
