package com.zx.share.platform.wechat.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.zx.share.platform.bean.zx.ZxOrderPay;
import com.zx.share.platform.constants.OrderStatusEnum;
import com.zx.share.platform.constants.PayStatusEnum;
import com.zx.share.platform.vo.wechat.request.OrderFileSaveBean;
import com.zx.share.platform.vo.wechat.request.OrderQueryBean;
import com.zx.share.platform.vo.wechat.request.OrderSaveBean;
import com.zx.share.platform.vo.wechat.response.OrderResultBean;
import com.zx.share.platform.wechat.api.pay.service.WeCharPayService;
import com.zx.share.platform.wechat.mapper.order.ZxOrderPayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.zx.share.platform.bean.zx.ZxOrder;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;
import com.zx.share.platform.wechat.mapper.order.ZxOrderMapper;
import com.zx.share.platform.wechat.service.ZxOrderService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ZxOrderServiceImpl implements ZxOrderService {

	@Autowired
	private ZxOrderMapper zxOrderMapper;
	@Autowired
	private ZxOrderPayMapper zxOrderPayMapper;
	@Autowired
	private WeCharPayService weCharPayService;
	
	@Override
	public DefaultResopnseBean<PageResponseBean<ZxOrder>> list(Map<String, Object> params) {
		// TODO Auto-generated method stub
		Integer pageNum = params.get("pageNum") != null ? Integer.parseInt(params.get("pageNum").toString()) : 1;
		Integer pageSize = params.get("pageSize") != null ? Integer.parseInt(params.get("pageSize").toString()) : 10;
		PageHelper.startPage(pageNum, pageSize, true);
		List<ZxOrder> list = zxOrderMapper.queryList(params);
		return null;
	}

	@Transactional(readOnly = false)
	@Override
	public Map<String, Object> payUnifiedorder(String orderCode) {
		ZxOrder zxOrder = zxOrderMapper.findByOrderCode(orderCode);
		if(zxOrder!=null){
			Date date = new Date();
			Map<String,Object> payMap = weCharPayService.payUnifiedorder("","",zxOrder.getAmount().intValue(),
					"ip",orderCode,"openid","JSAPI");

			ZxOrderPay orderPay = new ZxOrderPay();
			orderPay.setCreateTime(date);
			orderPay.setPayStatus(PayStatusEnum.ZX_PAY_STATUS_USERPAYING.code);
			orderPay.setCreateId(zxOrder.getOrderUserId());
			orderPay.setOrderId(zxOrder.getId());
			orderPay.setPayCode("");

			zxOrder.setPayCode(orderPay.getPayCode());
			zxOrder.setStatus(OrderStatusEnum.ZX_ORDER_STATUS_USERPAYING.code);
			zxOrder.setUpdateId(zxOrder.getOrderUserId());
			zxOrder.setUpdateTime(date);

		}
		return null;
	}

	@Override
	public Map<String, Object> paycallback_manual(Map<String, Object> map) {
		return null;
	}

	@Override
	public Map<String, Object> paycallback_automation(Map<String, Object> map) {
		return null;
	}

	@Override
	public int saveOrder(OrderSaveBean orderSaveBean) {
		return 0;
	}

	@Override
	public int updateOrderFile(OrderFileSaveBean fileSaveBean) {
		return 0;
	}

	@Override
	public OrderResultBean findByOrderCode(String orderCode) {
		return zxOrderMapper.getOrderCode(orderCode);
	}

	@Override
	public int cancel(String orderCode) {
		return zxOrderMapper.updateOrderStatus(orderCode,OrderStatusEnum.ZX_ORDER_STATUS_CLOSE.code);
	}

	@Override
	public PageResponseBean<OrderResultBean> page(OrderQueryBean queryBean) {
		Integer count = zxOrderMapper.pageCount(queryBean);
		List<OrderResultBean> resultBeans = zxOrderMapper.page(queryBean);
		PageResponseBean<OrderResultBean> pageResponseBean = new PageResponseBean<>(queryBean,count);
		pageResponseBean.setContent(resultBeans);
		return pageResponseBean;
	}

}
