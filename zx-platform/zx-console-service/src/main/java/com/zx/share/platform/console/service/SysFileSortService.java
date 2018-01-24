package com.zx.share.platform.console.service;

import java.util.List;

import com.zx.share.platform.wechat.model.SysFileSort;

/**
 * 
 * @author Administrator
 *
 */
public interface SysFileSortService {

	/**
	 * 查询所有
	 * @return list
	 */
	List selectAll();
	
	/**
	 * 新增
	 * @param sysFileSort
	 * @return
	 */
	int add(SysFileSort sysFileSort);
	
	/**
	 * 根据主键查询单行数据
	 * @param id
	 * @return
	 */
	SysFileSort selectByPrimaryKey(int id);
	
	/**
	 * 修改
	 * @param sysFileSort
	 * @return
	 */
	int update(SysFileSort sysFileSort);
}
