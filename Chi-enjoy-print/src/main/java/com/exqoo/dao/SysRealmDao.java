package com.exqoo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.exqoo.entity.SysRealm;

import tk.mybatis.mapper.common.Mapper;

@Repository
public interface SysRealmDao extends Mapper<SysRealm> {

	/**
	 * 查询用户的所有权限
	 * 
	 * @param userId
	 * @return
	 */
	List<String> getUserPermissions(Long userId);
}
