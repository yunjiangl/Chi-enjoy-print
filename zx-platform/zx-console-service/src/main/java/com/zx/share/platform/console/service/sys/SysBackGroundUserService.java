package com.zx.share.platform.console.service.sys;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zx.share.platform.bean.sys.SysRole;
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
	Integer updateUserById(Long id,String userName,String realName,String password,String email,Boolean isLock,String comment,Long roleId);
	
	/**
	 * 刪除后台用户管理数据
	 */
	Integer deleteUserById(Long userId);
	
	/**
	 * 模糊查询
	 */
	List<SysUser> selectUserDim(String name, Boolean isLock, Date time1, Date time2);
	/**
	 * 后台用户管理增添用户
	 */
	Integer insertUsers(String userName,String realName,String password,String email,Boolean isLock,Boolean isDel,String comment);
	
	/**
	 * 单行查询
	 */
	SysUser Select(String userName);

	
}
