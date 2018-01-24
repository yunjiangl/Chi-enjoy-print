package com.zx.share.platform.console.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exqoo.dao.SysOrderDao;
import com.zx.share.platform.console.service.SysDeviceService;
import com.zx.share.platform.console.service.SysOrderService;
import com.zx.share.platform.wechat.model.SysDevice;
import com.zx.share.platform.wechat.model.SysOrder;

/**
 * 
 * @ClassName: SysOrderServiceImpl
 * @Description: 订单业务实现类
 * @author 芸江
 * @date 2018年1月19日 下午2:52:53
 *
 */
@Service
public class SysOrderServiceImpl implements SysOrderService {

	@Autowired
	private SysOrderDao sysOrderDao;

	@Autowired
	private SysDeviceService sysDeviceService;

	@Override
	public List<SysOrder> list(Map<String, Object> map) {

		/**
		 * 设备物主条件
		 */
		if (map.get("deviceHost") != null) {
			SysDevice device = sysDeviceService.queryByDeviceHsot((String) map.get("deviceHost"));

			map.put("deviceHost", device.getDeviceId());
		}

		List<SysOrder> orders = sysOrderDao.queryList(map);

		for (SysOrder order : orders) {
			order.getSysDevice()
					.setSysUser(sysDeviceService.queryByDeviceId(order.getSysDevice().getDeviceId()).getSysUser());
			order.setPayMoney(order.getPrintFee().add(order.getServiceFee()));
		}

		return orders;
	}

	@Override
	public int queryTotal(Map<String, Object> params) {
		/**
		 * 设备物主条件
		 */
		if (params.get("deviceHost") != null) {
			SysDevice device = sysDeviceService.queryByDeviceHsot((String) params.get("deviceHost"));

			params.put("deviceHost", device.getDeviceId());
		}

		return sysOrderDao.selectTotal(params);
	}

}
