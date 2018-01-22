package com.exqoo.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.exqoo.entity.SysRole;

import tk.mybatis.mapper.common.Mapper;

@Repository
public interface SysRoleDao extends Mapper<SysRole> {
	
	List<SysRole> selectDim(@Param("roleName") String roleName,
							@Param("status") Byte status,
							@Param("time1") String  time1,
							@Param("time2") String time2);
}
