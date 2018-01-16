package com.exqoo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.exqoo.entity.SysUser;

import tk.mybatis.mapper.common.Mapper;

@Repository
public interface SysUserDao extends Mapper<SysUser> {
		
	/**
	 * 查询律师组数据
	 */
	List<SysUser> selectUserLawyerById(Long roleId);
}
