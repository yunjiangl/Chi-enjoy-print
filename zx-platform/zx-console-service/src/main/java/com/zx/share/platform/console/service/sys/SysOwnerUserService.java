package com.zx.share.platform.console.service.sys;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zx.share.platform.bean.sys.SysRole;
import com.zx.share.platform.bean.sys.SysUser;

public interface SysOwnerUserService {
	
	/**
	 * 查询出全部未删除的前台用户管理数据
	 * @return
	 */
	List<SysUser> selectOwnerUserAll(Long roleId);
	
	/**
	 * 禁用前台数据
	 */
	Integer updateOwnerUser(Long userId);
	
	/**
	 * 模糊查询
	 */
	List<SysUser> selectOwnerUserDim(@Param("name") String name,
										@Param("perms") String perms,
										@Param("time1") Date  time1,
										@Param("time2") Date time2);
	/**
	 * 修改物主用户管理数据
	 */
	Integer updateOwnerUserById(Long id,String userName,String salt,String password,String email,Boolean isLock,String comment,Long roleId);
}
