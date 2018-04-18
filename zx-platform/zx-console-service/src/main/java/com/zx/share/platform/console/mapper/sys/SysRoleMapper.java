package com.zx.share.platform.console.mapper.sys;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zx.share.platform.common.mapper.PlatFormMapper;

@Repository
public interface SysRoleMapper extends PlatFormMapper<SysRole>{
	
	/**
	 * 查詢用戶组管理数据
	 */
	List<SysRole> selectRoleAll();
	/**
	 * 模糊查詢
	 * @param roleName
	 * @param status
	 * @param time1
	 * @param time2
	 * @return
	 */
	List<SysRole> selectDim(@Param("name") String name,
							@Param("perms") String perms,
							@Param("time1") Date  time1,
							@Param("time2") Date time2);
	/**
	 * 增添数据
	 */
	Integer insertRole(@Param("userId") Long userId,
						@Param("roleId") Long roleId,
						@Param("createTime") Date createTime);
}
