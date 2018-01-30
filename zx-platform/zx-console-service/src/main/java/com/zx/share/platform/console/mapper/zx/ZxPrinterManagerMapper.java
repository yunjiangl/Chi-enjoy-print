package com.zx.share.platform.console.mapper.zx;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zx.share.platform.bean.zx.ZxPrinterManager;
import com.zx.share.platform.common.mapper.PlatFormMapper;

@Repository
public interface ZxPrinterManagerMapper extends PlatFormMapper<ZxPrinterManager> {

	/**
	 * 
	 * @Title: queryList
	 * @Description: 查询设备列表数据
	 */
	List<ZxPrinterManager> queryList(Map<String, Object> params);

}
