package com.zx.share.platform.console.mapper.zx;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zx.share.platform.bean.zx.ZxOrder;
import com.zx.share.platform.common.mapper.PlatFormMapper;

/**
 * 
 * @ClassName: ZxOrderMapper
 * @author: 刘芸江
 * @date: 2018年3月27日 下午4:00:24
 *
 */
@Repository
public interface ZxOrderMapper extends PlatFormMapper<ZxOrder> {

	public List<ZxOrder> queryList(Map<String, Object> param);

	public ZxOrder queryByOrderId(Long id);
	
	
	Integer selectSum();

}
