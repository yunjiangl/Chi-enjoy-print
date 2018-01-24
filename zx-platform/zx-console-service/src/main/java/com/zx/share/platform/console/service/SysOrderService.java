package com.zx.share.platform.console.service;

import java.util.List;
import java.util.Map;

import com.zx.share.platform.zxbean.SysOrder;

/**
 * 
 * @ClassName: SysOrderService
 * @Description: 订单业务接口类
 * @author 芸江
 * @date 2018年1月19日 下午2:52:04
 *
 */
public interface SysOrderService {

	/**
	 * 
	 * @Title: list
	 * @Description: 订单列表
	 */
	public List<SysOrder> list(Map<String, Object> map);

	public int queryTotal(Map<String, Object> params);
}
