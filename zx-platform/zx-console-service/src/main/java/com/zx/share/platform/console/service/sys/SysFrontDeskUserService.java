package com.zx.share.platform.console.service.sys;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zx.share.platform.bean.sys.SysRole;
import com.zx.share.platform.bean.sys.SysUser;

public interface SysFrontDeskUserService {
	
	/**
	 * 查询出全部未删除的前台用户管理数据
	 * @return
	 */
	List<SysUser> selectFrontDeskUserAll(Long roleId);
	
	/**
	 * 禁用前台数据
	 */
	Integer updateFrontDeskUser(Long userId);
	
	/**
	 * 模糊查询
	 */
	List<SysUser> selectFrontDeskUserDim(@Param("name") String name,
										@Param("perms") String perms,
										@Param("time1") Date  time1,
										@Param("time2") Date time2);
}
