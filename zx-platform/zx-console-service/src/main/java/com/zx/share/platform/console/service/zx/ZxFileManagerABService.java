package com.zx.share.platform.console.service.zx;

import java.util.Map;

import com.zx.share.platform.bean.zx.ZxFileManagerAB;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

public interface ZxFileManagerABService {

	/**
	 * 
	 * @Title: add
	 * @Description: 添加文件分类
	 * @param zxAB
	 *            添加文件分类
	 */
	public DefaultResopnseBean<Object> add(ZxFileManagerAB zxAB);
	
	/**
	 * 
	 * @Title: list
	 * @Description: 文件分类列表
	 * @Param query 查询参数
	 */
	public DefaultResopnseBean<PageResponseBean<ZxFileManagerAB>> list(Map<String, Object> params);
	
	/**
	 * 
	 * @param id
	 * @Description: 删除文件
	 * @return
	 */
	public DefaultResopnseBean<Object> delete(Long id);
}
