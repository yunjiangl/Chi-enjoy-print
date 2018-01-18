package com.exqoo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exqoo.entity.SysDevice;
import com.exqoo.service.SysDeviceService;
import com.exqoo.utils.PageUtils;
import com.exqoo.utils.Query;
import com.exqoo.utils.R;
import com.exqoo.utils.annotation.SysLog;

/**
 * 
 * @ClassName: SysDeviceController
 * @Description: 设备控制器
 * @author 芸江
 * @date 2018年1月17日 下午3:56:19
 *
 */
@RestController
@RequestMapping("sys/manage/device/")
public class SysDeviceController extends AbstractController {

	@Autowired
	private SysDeviceService sysDeviceService;

	@SysLog("添加设备")
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public R add(SysDevice sysDevice, String nickName) {
		int code = sysDeviceService.add(sysDevice, nickName);
		if (code == 1) {
			return R.ok();
		}
		return R.error();
	}

	@SysLog("设备列表")
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public R deviceList(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<SysDevice> devices = sysDeviceService.list(params);

		int total = sysDeviceService.queryTotal(params);
		PageUtils pageUtil = new PageUtils(devices, total, query.getLimit(), query.getPage());
		return R.ok().put("page", pageUtil);
	}

}
