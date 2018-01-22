package com.exqoo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.exqoo.entity.SysOrder;

import tk.mybatis.mapper.common.Mapper;

/**
 * 
 * @ClassName: SysOrderDao
 * @Description: 订单数据库操作
 * @author 芸江
 * @date 2018年1月19日 下午2:38:41
 *
 */
@Repository
public interface SysOrderDao extends Mapper<SysOrder> {
	
	public List<SysOrder> queryList(Map<String, Object> map);

	public int selectTotal(Map<String, Object> params);

}
