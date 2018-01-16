package com.exqoo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.exqoo.entity.SysRole;

import tk.mybatis.mapper.common.Mapper;

@Repository
public interface SysRoleDao extends Mapper<SysRole> {
	
}
