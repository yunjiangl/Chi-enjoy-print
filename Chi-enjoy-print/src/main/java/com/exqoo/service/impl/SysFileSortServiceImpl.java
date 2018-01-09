package com.exqoo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exqoo.dao.SysFileSortDao;
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

}
