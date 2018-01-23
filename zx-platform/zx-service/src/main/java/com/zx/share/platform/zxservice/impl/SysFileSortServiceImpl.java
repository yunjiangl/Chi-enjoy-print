package com.zx.share.platform.zxservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exqoo.dao.SysFileSortDao;
import com.exqoo.entity.SysFileSort;
import com.exqoo.service.SysFileSortService;

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
