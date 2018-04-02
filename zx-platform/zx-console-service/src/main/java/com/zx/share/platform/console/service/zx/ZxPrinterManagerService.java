package com.zx.share.platform.console.service.zx;

import java.util.Map;

import com.zx.share.platform.bean.zx.ZxPrinterManager;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

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
	public DefaultResopnseBean<Object> add(ZxPrinterManager zxPM);
	

	/**
	 * 
	 * @Title: list
	 * @Description: 设备列表
	 * @Param query 查询参数
	 */
	public DefaultResopnseBean<PageResponseBean<ZxPrinterManager>> list(Map<String, Object> params);

	/**
	 * 
	 * @Title: queryByZcPMId
	 * @Description: 查询单个设备信息（多表查询）
	 */
	public DefaultResopnseBean<Object> queryByZxPMId(Long id);
	/**
	 * 
	 * @Title: update
	 * @Description: 修改设备
	 * @param zxPM
	 *            设备信息
	 * @param hostname
	 *            设备物主
	 */
	public DefaultResopnseBean<Object> update(ZxPrinterManager zxPM);
}
