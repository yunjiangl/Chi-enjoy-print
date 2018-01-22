package com.exqoo.dao;

import org.springframework.stereotype.Repository;

import com.exqoo.entity.SysUserDev;

import tk.mybatis.mapper.common.Mapper;

/**
 * 
 * @ClassName: SysUserDevDao
 * @Description: 设备物主数据库操作
 * @author 芸江
 * @date 2018年1月16日 下午3:02:22
 *
 */
@Repository
public interface SysUserDevDao extends Mapper<SysUserDev>{

}
