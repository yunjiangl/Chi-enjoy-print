package com.zx.share.platform.console.service.sys;

import java.util.List;

import com.zx.share.platform.bean.sys.SysUser;

public interface SysBackGroundUserService {
	
	/**
	 * 查询出全部未删除的后台用户管理数据
	 * @return
	 */
	List<SysUser> selectUserAll(Long roleId);
	
	/**
	 * 修改后台用户管理数据
	 */
	Integer updateUserById(Long id,String userName,String salt,String password,String email,Boolean isLock,String comment,Long roleId);
}
