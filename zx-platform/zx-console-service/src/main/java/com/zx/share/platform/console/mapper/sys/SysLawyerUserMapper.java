package com.zx.share.platform.console.mapper.sys;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zx.share.platform.common.mapper.PlatFormMapper;

@Repository
public interface SysLawyerUserMapper extends PlatFormMapper<SysUser> {

	/**
	 * 查询出全部未删除的律师用户管理数据
	 * 
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
	Integer updateLawyerUserById(Map<String, Object> params);
}
