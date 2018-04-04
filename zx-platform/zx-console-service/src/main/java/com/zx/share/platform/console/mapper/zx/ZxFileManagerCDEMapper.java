package com.zx.share.platform.console.mapper.zx;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zx.share.platform.bean.zx.ZxFileManagerCDE;
import com.zx.share.platform.common.mapper.PlatFormMapper;
import com.zx.share.platform.util.response.DefaultResopnseBean;

@Repository
public interface ZxFileManagerCDEMapper extends PlatFormMapper<ZxFileManagerCDE> {

	/**
	 * 
	 * @Title: queryList
	 * @Description: 查询文件分类列表cde
	 */
	List<ZxFileManagerCDE> queryList(Map<String, Object> params);
	
	void delectList(Long ids);
	
}
