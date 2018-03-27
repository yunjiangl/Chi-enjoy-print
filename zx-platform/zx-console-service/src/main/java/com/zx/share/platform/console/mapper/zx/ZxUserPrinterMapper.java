package com.zx.share.platform.console.mapper.zx;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zx.share.platform.bean.zx.ZxUserPrinter;
import com.zx.share.platform.common.mapper.PlatFormMapper;

@Repository
public interface ZxUserPrinterMapper extends PlatFormMapper<ZxUserPrinter>{
	
	/**
	 * 物主端设备列表禁用功能
	 */
	Integer updateOwenByCode(@Param("printerCode") String printerCode);
}
