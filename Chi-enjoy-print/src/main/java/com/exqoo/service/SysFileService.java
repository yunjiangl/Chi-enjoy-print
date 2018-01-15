package com.exqoo.service;

import java.util.List;

import com.exqoo.entity.SysFile;

/**
 * 
 * @author Administrator
 *
 */
public interface SysFileService {

	/**
	 * 查询所有
	 * @return List
	 */
	List selectAll();
	
	/**
	 * 新增
	 * @param sysFile
	 * @return int
	 */
	int add(SysFile sysFile);
	
	/**
	 * 删除
	 * @param id
	 * @return int
	 */
	int deleteById(int id);
}
