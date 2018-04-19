package com.zx.share.platform.console.api.modules.file.service;

import java.util.List;
import java.util.Map;

import com.zx.share.platform.bean.sys.SysDictionary;
import org.springframework.web.multipart.MultipartFile;

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
	public DefaultResopnseBean<Object> add(ZxFileManagerAB zxAB,MultipartFile multipartFile);
	
	/**
	 * 单条数据展示
	 * @param Id
	 * @return
	 */
	public ZxFileManagerAB selectId(Long Id);
	
	/**
	 * 
	 * @Title: update
	 * @Description: 修改文件分类
	 * @param zxAB
	 *            修改文件分类
	 */
	public void update(ZxFileManagerAB zxFileManagerAB);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteAll(Long[] ids);
	
	/**
	 * 
	 * @Title: list
	 * @Description: 文件分类列表
	 * @Param query 查询参数
	 */
	public DefaultResopnseBean<PageResponseBean<ZxFileManagerAB>> list(Map<String, Object> params);
	
	/**
	 * 模糊查询A文件
	 * @param params
	 * @return
	 */
	public DefaultResopnseBean<PageResponseBean<ZxFileManagerAB>> vagueList(Map<String, Object> params);
	/**
	 * 
	 * @param id
	 * @Description: 删除文件
	 * @return
	 */
	public DefaultResopnseBean<Object> delete(Long id);

	public List<SysDictionary> dictionaryList(Map<String, Object> params);
}
