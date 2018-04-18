package com.zx.share.platform.console.api.modules.order.service;

import java.util.Map;

import com.zx.share.platform.bean.zx.ZxOrder;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

/**
 * 
 * @ClassName: ZxOrderService
 * @author: 刘芸江
 * @date: 2018年3月27日 下午3:56:57
 *
 */
public interface ZxOrderService {

	/**
	 * 
	 * @Title: list
	 * @Description: 分页查询
	 */
	public DefaultResopnseBean<PageResponseBean<ZxOrder>> list(Map<String, Object> param);

	/**
	 * 
	 * @Title: orderInfo
	 * @Description: 单个信息查询
	 */
	public ZxOrder orderInfo(Long id);
	
	Integer selectCount();	
	Integer selectSum();

}
