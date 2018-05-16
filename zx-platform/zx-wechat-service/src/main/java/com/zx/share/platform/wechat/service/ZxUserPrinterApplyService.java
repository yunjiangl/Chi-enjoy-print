package com.zx.share.platform.wechat.service;

import javax.servlet.http.HttpServletRequest;

import com.zx.share.platform.bean.zx.ZxUserPrinterApply;

/**
 * 
 * @ClassName: ZxUserPrinterApplyService
 * @author: 刘芸江
 * @date: 2018年3月24日 上午10:52:40
 *
 */
public interface ZxUserPrinterApplyService {
	
	public boolean add(String userCode,String code,HttpServletRequest request);
	
	public int update(ZxUserPrinterApply zxUserPrinterApply);
	
}
