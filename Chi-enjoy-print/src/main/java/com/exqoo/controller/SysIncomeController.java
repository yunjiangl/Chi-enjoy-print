package com.exqoo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exqoo.entity.SysIncome;
import com.exqoo.service.SysIncomeService;
import com.exqoo.utils.R;

/**
 * 
 * @ClassName: SysIncomeController
 * @Description: TODO(文件收益百分比控制层)
 * @author 芸江
 * @date 2018年1月15日 下午12:00:06
 *
 */
@RestController
public class SysIncomeController extends AbstractController {

	@Autowired
	private SysIncomeService sysIncomeService;

	@RequestMapping(value = "/manage/income/updata", method = RequestMethod.POST)
	public R updateIncome(SysIncome sysIncome) {
		sysIncomeService.updata(sysIncome);
		return R.ok();
	}

	@RequestMapping(value = "/manage/income/info", method = RequestMethod.GET)
	public R queryIncome() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", sysIncomeService.query());

		return R.ok(map);
	}

}
