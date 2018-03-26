package com.zx.share.platform.wechat.mapper.order;

import java.util.List;
import java.util.Map;

import com.zx.share.platform.vo.wechat.request.OrderQueryBean;
import com.zx.share.platform.vo.wechat.response.OrderResultBean;
import org.springframework.stereotype.Repository;

import com.zx.share.platform.bean.zx.ZxOrder;
import com.zx.share.platform.bean.zx.ZxPrinterManager;
import com.zx.share.platform.common.mapper.PlatFormMapper;

@Repository
public interface ZxOrderMapper extends PlatFormMapper<ZxOrder> {

	/**
	 * 
	 * @Title: queryList
	 * @Description: 查询订单数据
	 */
	List<ZxOrder> queryList(Map<String, Object> params);

	ZxOrder findByOrderCode(String orderCode);

	OrderResultBean getOrderCode(String orderCode);

	int updateOrderStatus(String orderCode, Integer status);

	List<OrderResultBean> page(OrderQueryBean queryBean);

	Integer pageCount(OrderQueryBean queryBean);

	List<ZxOrder> attorney(Map<String, Object> param);

	ZxOrder selectByCode(String code);
}
