package com.zx.share.platform.console.api.modules.file.service;

import java.util.Map;

import com.zx.share.platform.bean.zx.ZxFileManagerCDE;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

public interface ZxFileManagerCDEService {

	/**
	 * 
	 * @Title: list
	 * @Description: 文件分类列表cde
	 * @Param query 查询参数
	 */
	public DefaultResopnseBean<PageResponseBean<ZxFileManagerCDE>> list(Map<String, Object> params);
	
	/**
	 * 
	 * @param id
	 * @Description: 删除文件
	 * @return
	 */
	public DefaultResopnseBean<Object> delete(Long ids);
	
	/**
	 * 查看文件信息
	 * @param id
	 * @return
	 */
	public DefaultResopnseBean<Object> show(Long id);
}
