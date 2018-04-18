package com.zx.share.platform.console.api.modules.sys.dao;

import com.zx.share.platform.bean.sys.SysDictionary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 系统配置信息
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2016年12月4日 下午6:46:16
 */
@Mapper
public interface SysConfigDao extends BaseDao<SysDictionary> {
	
	/**
	 * 根据key，查询value
	 */
	SysDictionary queryByKey(String paramKey);
	
	/**
	 * 根据key，更新value
	 */
	int updateValueByKey(@Param("key") String key, @Param("value") String value);
	
}
