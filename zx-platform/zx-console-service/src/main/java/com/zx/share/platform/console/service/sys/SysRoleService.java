package com.zx.share.platform.console.service.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zx.share.platform.bean.sys.SysRole;

public interface SysRoleService {
	
	/**
	 * 查询全部数据
	 * @return
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
	/**
	 * 模糊查询
	 */
	List<SysRole> selectDim(@Param("roleName") String roleName,
							@Param("status") Byte status,
							@Param("time1") String time1,
							@Param("time2") String time2);
}
