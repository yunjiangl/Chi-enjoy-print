package com.zx.share.platform.console.mapper.sys;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zx.share.platform.bean.sys.SysRole;
import com.zx.share.platform.bean.sys.SysUser;
import com.zx.share.platform.common.mapper.PlatFormMapper;

@Repository
public interface SysOwnerUserMapper extends PlatFormMapper<SysUser> {

	/**
	 * 查询出全部未删除的物主用户管理数据
	 * 
	 * @return
	 */
	List<SysUser> selectOwnerUserAll(Long roleId);

	/**
	 * 禁用物主数据
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
	Integer updateOwnerUserById(Map<String, Object> params);
}
