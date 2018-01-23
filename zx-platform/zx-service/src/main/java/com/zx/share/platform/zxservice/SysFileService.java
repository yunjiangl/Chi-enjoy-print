package com.zx.share.platform.zxservice;

import java.util.List;

import com.zx.share.platform.zxbean.SysFile;

/**
 * com.zx.share.platform.zxservice
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
