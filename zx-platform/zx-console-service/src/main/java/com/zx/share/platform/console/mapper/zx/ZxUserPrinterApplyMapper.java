package com.zx.share.platform.console.mapper.zx;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zx.share.platform.bean.zx.ZxUserPrinterApply;
import com.zx.share.platform.common.mapper.PlatFormMapper;

public interface ZxUserPrinterApplyMapper extends PlatFormMapper<ZxUserPrinterApply>{

	
	List<ZxUserPrinterApply> selectNewsList(Map<String, Object> params);

}
