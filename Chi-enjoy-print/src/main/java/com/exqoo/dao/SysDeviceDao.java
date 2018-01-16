package com.exqoo.dao;

import org.springframework.stereotype.Repository;

import com.exqoo.entity.SysDevice;

import tk.mybatis.mapper.common.Mapper;

/**
 * 
 * @ClassName: SysDeviceDao
 * @Description: 设备数据库操作
 * @author 芸江
 * @date 2018年1月16日 上午10:52:15
 *
 */
@Repository
public interface SysDeviceDao extends Mapper<SysDevice>{

}
