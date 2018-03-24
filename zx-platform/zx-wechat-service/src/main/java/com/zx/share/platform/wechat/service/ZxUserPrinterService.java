package com.zx.share.platform.wechat.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @ClassName: ZxUserPrinterService
 * @author: 刘芸江
 * @date: 2018年3月24日 下午3:58:37
 *
 */
public interface ZxUserPrinterService {

	boolean update(String code, HttpServletRequest request);

}
