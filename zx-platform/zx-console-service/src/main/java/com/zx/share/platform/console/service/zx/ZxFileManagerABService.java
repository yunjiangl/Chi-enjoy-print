package com.zx.share.platform.console.service.zx;

import com.zx.share.platform.bean.zx.ZxFileManagerAB;
import com.zx.share.platform.bean.zx.ZxPrinterManager;
import com.zx.share.platform.util.response.DefaultResopnseBean;

public interface ZxFileManagerABService {

	/**
	 * 
	 * @Title: add
	 * @Description: 添加文件分类
	 * @param zxAB
	 *            添加文件分类
	 */
	public DefaultResopnseBean<Object> add(ZxFileManagerAB zxAB);
}
