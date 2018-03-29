package com.zx.share.platform.console.mapper.zx;

import java.util.List;

import com.zx.share.platform.bean.zx.ZxUserPrinterApply;
import com.zx.share.platform.common.mapper.PlatFormMapper;

public interface ZxUserPrinterApplyMapper extends PlatFormMapper<ZxUserPrinterApply>{

	
	List<ZxUserPrinterApply> selectNewsList( String userName,int status);
}
