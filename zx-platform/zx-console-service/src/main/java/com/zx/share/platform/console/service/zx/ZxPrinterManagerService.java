package com.zx.share.platform.console.service.zx;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.zx.share.platform.bean.zx.ZxPrinterManager;

/**
 * 
 * @ClassName: ZxPrinterManagerService
 * @Description: 设备业务接口类
 * @author 芸江
 * @date 2018年1月30日 上午10:49:01
 *
 */
public interface ZxPrinterManagerService {

	/**
	 * 
	 * @Title: add
	 * @Description: 添加设备
	 * @param zxPM
	 *            设备信息
	 * @param hostname
	 *            设备物主
	 */
	public Map<String, Object> add(ZxPrinterManager zxPM);

	/**
	 * 
	 * @Title: list
	 * @Description: 设备列表
	 * @Param query 查询参数
	 */
	public PageInfo list(Map<String, Object> params);
}
