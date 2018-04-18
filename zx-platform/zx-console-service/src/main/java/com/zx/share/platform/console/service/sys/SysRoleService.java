package com.zx.share.platform.console.service.sys;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

public interface SysRoleService {
	
	/**
	 * 查询全部数据
	 * @return
	 */
	DefaultResopnseBean<PageResponseBean<SysRole>> selectRoleAll(Map<String, Object> param);

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
	List<SysRole> selectDim(@Param("name") String name,
						    @Param("perms") String perms,
						    @Param("time1") Date  time1,
						    @Param("time2") Date time2);
	/**
	 * 增添数据
	 */
	Integer insertRole(Long userId,Long roleId,Date createTime);
}
