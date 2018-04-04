package com.zx.share.platform.console.service.sys;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zx.share.platform.bean.sys.SysRole;
import com.zx.share.platform.bean.sys.SysUser;

public interface SysLawyerUserService {
	
	/**
	 * 查询出全部未删除的律师用户管理数据
	 * @return
	 */
	List<SysUser> selectLawyerUserAll();
	
	/**
	 * 禁用律师数据
	 */
	Integer updateLawyerUser(Long userId);
	
	/**
	 * 模糊查询
	 */
	List<SysUser> selectLawyerUserDim(@Param("name") String name,
										@Param("perms") String perms,
										@Param("time1") Date  time1,
										@Param("time2") Date time2);
	/**
	 * 修改律师用户管理数据
	 */
	Integer updateLawyerUserById(Long id,String userName,String salt,String password,String email,Boolean isLock,String comment,Long roleId);
}
