package com.zx.share.platform.wechat.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zx.share.platform.bean.zx.ZxUserPrinter;
import com.zx.share.platform.common.bean.UserCache;
import com.zx.share.platform.common.service.TokenCacheService;
import com.zx.share.platform.wechat.mapper.ZxUserPrinterMapper;
import com.zx.share.platform.wechat.service.ZxUserPrinterService;

/**
 * 
 * @ClassName: ZxUserPrinterServiceImpl
 * @author: 刘芸江
 * @date: 2018年3月24日 下午4:00:15
 *
 */
@Service
public class ZxUserPrinterServiceImpl implements ZxUserPrinterService {

	@Autowired
	private ZxUserPrinterMapper zxUserPrinterMapper;

	@Autowired
	private TokenCacheService tokenCacheService;

	@Transactional
	@Override
	public boolean update(String code, HttpServletRequest request) {

		try {
			//UserCache userCache = tokenCacheService.getCacheUser(request); // 得到当前登录用户
			ZxUserPrinter record = new ZxUserPrinter();
			record.setPrinterCode(code);
			//record.setUserCode(userCache.getUserCode());
			ZxUserPrinter zxUserPrinter = zxUserPrinterMapper.selectOne(record);
			System.out.println(zxUserPrinter.getUserCode());
			zxUserPrinterMapper.delete(zxUserPrinter);
			zxUserPrinter.setStatus(0);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
