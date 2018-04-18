package com.zx.share.platform.console.mapper.zx;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zx.share.platform.bean.zx.ZxFileManagerAB;
import com.zx.share.platform.common.mapper.PlatFormMapper;

@Repository
public interface ZxFileManagerABMapper extends PlatFormMapper<ZxFileManagerAB>{

	/**
	 * 
	 * @Title: queryList
	 * @Description: 查询文件分类列表
	 */
	List<ZxFileManagerAB> queryList(Map<String, Object> params);
	
	List<ZxFileManagerAB> vagueList(Map<String , Object> params);

	List<SysDictionary> dictionaryList(Map<String, Object> params);
}
