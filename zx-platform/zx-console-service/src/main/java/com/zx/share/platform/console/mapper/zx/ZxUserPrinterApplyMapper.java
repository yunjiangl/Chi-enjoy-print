package com.zx.share.platform.console.mapper.zx;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zx.share.platform.bean.zx.ZxUserPrinterApply;
import com.zx.share.platform.common.mapper.PlatFormMapper;

public interface ZxUserPrinterApplyMapper extends PlatFormMapper<ZxUserPrinterApply>{

	
	List<ZxUserPrinterApply> selectNewsList(@Param(value = "userName") String userName,@Param(value = "status") int status);
}
