package com.zx.share.platform.console.service;

import java.util.List;
import java.util.Map;

import com.zx.share.platform.wechat.model.SysDevice;

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
	 * @Title: add 返回0代表失败，返回1代表成功
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
	public List<SysDevice> list(Map<String, Object> map);

	/**
	 * 
	 * @param params
	 * @Title: queryTotal
	 * @Description: 查询数据总数
	 */
	public int queryTotal(Map<String, Object> params);

	/**
	 * 
	 * @Title: queryByDeviceHsot
	 * @Description: 通过设备物主查询设备信息
	 */
	public SysDevice queryByDeviceHsot(String deviceHost);
	
	/**
	 * 
	* @Title: queryByDeviceId 
	* @Description: 通过设备id查询物主信息
	 */
	public SysDevice queryByDeviceId(Long deviceId);

}
