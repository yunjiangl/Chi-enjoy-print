package com.exqoo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.exqoo.entity.SysUser;

import tk.mybatis.mapper.common.Mapper;

@Repository
public interface SysUserDao extends Mapper<SysUser> {
		
	/**
	 * 查询管理组数据
	 */
	List<SysUser> selectUserLawyerById(Long roleId);
	/**
	 * 禁用功能
	 */
	Integer updateLawyerUser(Long userId);
	/**
	 * 用户后台数据修改
	 */
	Integer updateBackstage(SysUser sysUser);
	/**
	 * 后台组模糊查询
	 */
	List<SysUser> BackstageDim(@Param("username") String username,
			   				   @Param("status") Byte status,
			   				   @Param("time1") String time1,
			   				   @Param("time2") String time2,
			   				   @Param("roleId") Long roleId);
}
