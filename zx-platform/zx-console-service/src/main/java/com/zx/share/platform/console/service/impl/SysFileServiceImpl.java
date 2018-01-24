package com.zx.share.platform.console.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exqoo.dao.SysFileDao;
import com.exqoo.entity.SysFile;
import com.exqoo.service.SysFileService;


/**
 * 
 * @author Administrator
 *
 */
@Service
public class SysFileServiceImpl implements SysFileService{

	@Autowired
	private SysFileDao sysFileDao;
	
	@Override
	public List selectAll() {
		return sysFileDao.selectAll();
	}

	@Override
	@Transactional
	public int add(SysFile sysFile) {
		return sysFileDao.insert(sysFile);
	}

	@Override
	public int deleteById(int id) {
		return sysFileDao.deleteByPrimaryKey(id);
	}

}
