package com.exqoo.service;

import java.util.List;
import java.util.Map;

import com.exqoo.entity.SysDevice;

/**
 * 
 * @ClassName: SysDevice
 * @Description: 设备业务接口类
 * @author 芸江
 * @date 2018年1月16日 上午10:55:53
 *
 */
public interface SysDeviceService {

	/**
	 * 
	 * @Title: add
	 * @Description: 添加设备信息
	 * @Param sysDevice
	 * @Param nickName
	 */
	public int add(SysDevice sysDevice, String nickName);

	/**
	 * 
	 * @Title: list
	 * @Description: 设备列表
	 */
	public List list(Map<String, Object> map);

}
