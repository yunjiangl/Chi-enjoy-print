package com.zx.share.platform.wechat.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zx.share.platform.bean.zx.ZxPrinterManager;
import com.zx.share.platform.bean.zx.ZxUserPrinterApply;
import com.zx.share.platform.common.bean.UserCache;
import com.zx.share.platform.common.service.TokenCacheService;
import com.zx.share.platform.wechat.mapper.ZxUserPrinterApplyMapper;
import com.zx.share.platform.wechat.service.PrinterService;
import com.zx.share.platform.wechat.service.ZxUserPrinterApplyService;

/**
 * 
 * @ClassName: ZxUserPrinterApplyServiceImpl
 * @author: 刘芸江
 * @date: 2018年3月24日 上午10:54:38
 *
 */
@Service
public class ZxUserPrinterApplyServiceImpl implements ZxUserPrinterApplyService {

	@Autowired
	private ZxUserPrinterApplyMapper zxUserPrinterApplyMapper;

	@Autowired
	private PrinterService printerService;

	@Autowired
	private TokenCacheService tokenCacheService;

	@Override
	public boolean add(String code, HttpServletRequest request) {

		ZxPrinterManager printer = printerService.prinerInfo(code);

		ZxUserPrinterApply printerApply = new ZxUserPrinterApply();

		try {
			UserCache userCache = tokenCacheService.getCacheUser(request); // 得到当前登录用户
			
			printerApply.setUserId(userCache.getId());
			printerApply.setPrinterId(printer.getId());
			printerApply.setCreateTime(new Date());
			printerApply.setStatus(0);
			printerApply.setCreateId(userCache.getId());
			zxUserPrinterApplyMapper.insertSelective(printerApply);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public int update(ZxUserPrinterApply zxUserPrinterApply) {
		
		return zxUserPrinterApplyMapper.updateByPrimaryKeySelective(zxUserPrinterApply);
	}

}
