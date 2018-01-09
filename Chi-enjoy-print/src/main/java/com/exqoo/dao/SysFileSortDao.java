package com.exqoo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.exqoo.entity.SysFileSort;

import tk.mybatis.mapper.common.Mapper;

/**
 * 
 * @author Administrator
 *
 */
@Repository
public interface SysFileSortDao extends Mapper<SysFileSort> {

	List<Map> selectSysFileSort(Map parm);
}
