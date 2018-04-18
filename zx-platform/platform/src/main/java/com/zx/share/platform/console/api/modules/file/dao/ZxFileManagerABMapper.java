package com.zx.share.platform.console.api.modules.file.dao;

import java.util.List;
import java.util.Map;

import com.zx.share.platform.bean.sys.SysDictionary;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.zx.share.platform.bean.zx.ZxFileManagerAB;
import com.zx.share.platform.common.mapper.PlatFormMapper;

@Repository
@Mapper
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
