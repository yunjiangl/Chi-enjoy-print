package com.zx.share.platform.wechat.service;

import java.util.Map;

import com.zx.share.platform.bean.zx.ZxOrder;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

public interface ZxOrderService {

	

	/**
	 * 
	 * @Title: list
	 * @Description: 订单查询
	 * @Param query 查询参数
	 */
	public DefaultResopnseBean<PageResponseBean<ZxOrder>> list(Map<String, Object> params);
}
