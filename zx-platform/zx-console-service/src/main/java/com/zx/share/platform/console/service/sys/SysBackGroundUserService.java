package com.zx.share.platform.console.service.sys;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

public interface SysBackGroundUserService {
	
	/**
	 * 查询出全部未删除的后台用户管理数据
	 * @return
	 */
	DefaultResopnseBean<PageResponseBean<SysUser>> selectUserAll(Long roleId,Map<String, Object> param);
	
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
	Integer insertUsers(String userName,String realName,String password,String email,Boolean isLock,String comment);
	
	/**
	 * 单行查询
	 */
	SysUser Select(String userName);

	
}
