package com.zx.share.platform.console.api.modules.file.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.zx.share.platform.bean.zx.ZxFileManagerCDE;
import com.zx.share.platform.common.mapper.PlatFormMapper;

@Repository
@Mapper
public interface ZxFileManagerCDEMapper extends PlatFormMapper<ZxFileManagerCDE> {

	/**
	 * 
	 * @Title: queryList
	 * @Description: 查询文件分类列表cde
	 */
	List<ZxFileManagerCDE> queryList(Map<String, Object> params);
	
	void delectList(Long ids);
	
}
