package com.exqoo.dao;

import org.springframework.stereotype.Repository;

import com.exqoo.entity.SysUser;

import tk.mybatis.mapper.common.Mapper;

@Repository
public interface SysUserDao extends Mapper<SysUser> {

}
