package com.exqoo.service;

import com.exqoo.entity.SysIncome;

/**
 * 
 * @ClassName: SysIncomeService
 * @Description: TODO(文件收益百分比业务接口类)
 * @author 芸江
 * @date 2018年1月15日 上午11:33:02
 *
 */
public interface SysIncomeService {

	/**
	 * 
	 * @Title: updata
	 * @Description: TODO(修改文件收益百分比)
	 * @param sysIncome
	 * @return int 返回类型
	 * 
	 */
	int updata(SysIncome sysIncome);
	
	/**
	 * 
	* @Title: query 
	* @Description: TODO(查询文件收益百分比)
	 */
	SysIncome query();

}
