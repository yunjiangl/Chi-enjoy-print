package com.zx.share.platform.console.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exqoo.dao.SysUserDevDao;
import com.zx.share.platform.console.service.SysUserDevService;
import com.zx.share.platform.wechat.model.SysUserDev;

/**
 * 
* @ClassName: SysUserDevServiceImpl 
* @Description: 设备物主业务实现
* @author 芸江
* @date 2018年1月16日 下午3:06:13 
*
 */
@Service
public class SysUserDevServiceImpl implements SysUserDevService{

	@Autowired
	private SysUserDevDao sysUserDevDao;
	
	@Override
	public int add(SysUserDev record) {
		return sysUserDevDao.insert(record);
	}

}
