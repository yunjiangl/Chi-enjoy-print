package com.zx.share.platform.console.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exqoo.dao.SysFileSortDao;
import com.zx.share.platform.console.service.SysFileSortService;
import com.zx.share.platform.wechat.model.SysFileSort;

/**
 * 
 * @author Administrator
 *
 */
@Service
public class SysFileSortServiceImpl implements SysFileSortService {

	@Autowired
	private SysFileSortDao sysFileSortDao;
	
	@Override
	public List selectAll() {
		return sysFileSortDao.selectAll();
	}

	@Override
	@Transactional
	public int add(SysFileSort sysFileSort) {
		return sysFileSortDao.insert(sysFileSort);
	}

	@Override
	@Transactional
	public int update(SysFileSort sysFileSort) {
		return sysFileSortDao.updateByPrimaryKey(sysFileSort);
	}

	@Override
	public SysFileSort selectByPrimaryKey(int id) {
		return sysFileSortDao.selectByPrimaryKey(id);
	}


}
