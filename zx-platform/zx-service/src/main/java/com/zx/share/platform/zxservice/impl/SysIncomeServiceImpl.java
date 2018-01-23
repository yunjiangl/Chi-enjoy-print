package com.zx.share.platform.zxservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exqoo.dao.SysIncomeDao;
import com.exqoo.entity.SysIncome;
import com.exqoo.service.SysIncomeService;

/**
 * 
 * @ClassName: SysIncomeServiceImpl
 * @Description: TODO(文件收益百分比业务实现类)
 * @author 芸江
 * @date 2018年1月15日 上午11:42:41
 *
 */
@Service
public class SysIncomeServiceImpl implements SysIncomeService {

	@Autowired
	private SysIncomeDao sysIncomeDao;

	@Transactional
	@Override
	public int updata(SysIncome record) {
		record.setId(1L);
		return sysIncomeDao.updateByPrimaryKey(record);
	}

	@Override
	public SysIncome query() {
		return sysIncomeDao.selectByPrimaryKey(1L);
	}

}
