package com.zx.share.platform.console.service.zx.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.bean.zx.ZxUserPrinter;
import com.zx.share.platform.console.mapper.zx.ZxUserMapper;
import com.zx.share.platform.console.mapper.zx.ZxUserPrinterMapper;
import com.zx.share.platform.console.service.zx.ZxUserMapperService;
import com.zx.share.platform.console.service.zx.ZxUserPrinterService;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.response.DefaultResopnseBean;


@Service
public class ZxUserMapperServiceImpl implements ZxUserMapperService {

	@Autowired
	private ZxUserMapper zxUserMapper;
	
	/**
	 * 设备管理添加线上管理员遍历
	 */
	@Override
	public List<ZxUser> selectOnlineAdmin() {
		// TODO Auto-generated method stub
		return zxUserMapper.selectOnlineAdmin();
	}
	
	/**
	 * 设备列表添加线上管理员查看功能 
	 */
	@Override
	public ZxUser selectOnlineAdminById(Long id) {
		// TODO Auto-generated method stub
		return zxUserMapper.selectOnlineAdminById(id);
	}

	

}
