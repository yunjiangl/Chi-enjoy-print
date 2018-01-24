package com.zx.share.platform.console.service;

import com.zx.share.platform.wechat.model.SysUserDev;

/**
 * 
 * @ClassName: SysUserDevService
 * @Description: 设备物主业务接口
 * @author 芸江
 * @date 2018年1月16日 下午3:04:11
 *
 */
public interface SysUserDevService {

	/**
	 * 
	 * @Title: add
	 * @Description: 添加设备物主关系
	 * @Param record
	 */
	public int add(SysUserDev record);

}
