package com.exqoo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exqoo.entity.SysOrder;
import com.exqoo.service.SysOrderService;
import com.exqoo.utils.PageUtils;
import com.exqoo.utils.Query;
import com.exqoo.utils.R;
import com.exqoo.utils.annotation.SysLog;

/**
 * 
 * @ClassName: SysOrderController
 * @Description: 订单控制器
 * @author 芸江
 * @date 2018年1月19日 下午3:35:26
 *
 */
@RestController
@RequestMapping("sys/order/")
public class SysOrderController extends AbstractController {

	@Autowired
	private SysOrderService sysOrderService;

	@SysLog("订单列表")
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public R list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<SysOrder> orders = sysOrderService.list(params);
		int total =  sysOrderService.queryTotal(params);
		PageUtils pageUtil = new PageUtils(orders, total, query.getLimit(), query.getPage());
		return R.ok().put("page", pageUtil);
	}

}
