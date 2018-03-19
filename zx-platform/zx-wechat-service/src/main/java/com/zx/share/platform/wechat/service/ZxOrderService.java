package com.zx.share.platform.wechat.service;

import java.util.Map;

import com.zx.share.platform.bean.zx.ZxOrder;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;
import com.zx.share.platform.vo.wechat.request.OrderFileSaveBean;
import com.zx.share.platform.vo.wechat.request.OrderQueryBean;
import com.zx.share.platform.vo.wechat.request.OrderSaveBean;
import com.zx.share.platform.vo.wechat.response.OrderResultBean;

/**
 * @author fenggang
 */
public interface ZxOrderService {

	/**
	 * 
	 * @Title: list
	 * @Description: 订单查询
	 * @Param query 查询参数
	 */
	DefaultResopnseBean<PageResponseBean<ZxOrder>> list(Map<String, Object> params);

	/**
	 * 订单支付下单
	 * @param orderCode
	 * @return
	 */
	Map<String,Object> payUnifiedorder(String orderCode);


	/**
	 * 手动支付回调
	 * @param map
	 * @return
	 */
	Map<String,Object> paycallback_manual(Map<String,Object> map);

	/**
	 * 自动支付回调
	 * @param map
	 * @return
	 */
	Map<String,Object> paycallback_automation(Map<String,Object> map);

	/**
	 * 订单生成
	 * @return
	 */
	int saveOrder(OrderSaveBean orderSaveBean);

	/**
	 * 订单打印文件修改
	 * @return
	 */
	int updateOrderFile(OrderFileSaveBean fileSaveBean);

	OrderResultBean findByOrderCode(String orderCode);

	/**
	 * 关闭订单
	 * @param orderCode
	 * @return
	 */
	int cancel(String orderCode);

	PageResponseBean<OrderResultBean> page(OrderQueryBean queryBean);
}
