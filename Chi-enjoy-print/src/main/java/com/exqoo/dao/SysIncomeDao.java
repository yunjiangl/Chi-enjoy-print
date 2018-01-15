package com.exqoo.dao;

import org.springframework.stereotype.Repository;

import com.exqoo.entity.SysIncome;

import tk.mybatis.mapper.common.Mapper;

/**
 * 
 * @ClassName: SysIncomeDao
 * @Description: TODO(文件收益百分比数据库操作)
 * @author 芸江
 * @date 2018年1月15日 上午11:30:52
 *
 */
@Repository
public interface SysIncomeDao extends Mapper<SysIncome>{

}
