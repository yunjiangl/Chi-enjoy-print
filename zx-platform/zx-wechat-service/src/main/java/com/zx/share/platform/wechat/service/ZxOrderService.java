package com.zx.share.platform.wechat.service;

import java.util.List;
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
	 * 
	 * @param orderCode
	 * @return
	 */
	Map<String, Object> payUnifiedorder(String orderCode,String body,String openId,String ip);

	/**
	 * 手动支付回调
	 * 
	 * @param map
	 * @return
	 */
	Map<String, Object> paycallback_manual(Map<String, Object> map);

	/**
	 * 自动支付回调
	 * 
	 * @param map
	 * @return
	 */
	Map<String, Object> paycallback_automation(Map<String, Object> map);

	/**
	 * 订单生成
	 * 
	 * @return
	 */
	int saveOrder(OrderSaveBean orderSaveBean);

	/**
	 * 订单打印文件修改
	 * 
	 * @return
	 */
	int updateOrderFile(OrderFileSaveBean fileSaveBean);

	OrderResultBean findByOrderCode(String orderCode);

	/**
	 * 关闭订单
	 * 
	 * @param orderCode
	 * @return
	 */
	int cancel(String orderCode);

	PageResponseBean<OrderResultBean> page(OrderQueryBean queryBean);

	List<ZxOrder> attorney(Map<String, Object> param);
	
	ZxOrder orderInfo(String code);

	/**
	 * 打印回调方法
	 */
	void orderCallBack();

	/**
	 * 打印订单文件
	 * @param code
	 * @return
	 */
	boolean printer(String code);

	/**
	 * 支付回调
	 * @param orderCode
	 * @param payCode
	 * @param status
	 */
	void manualCallback(String orderCode,String payCode,Integer status,String error);
}
