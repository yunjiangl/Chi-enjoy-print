package com.zx.share.platform.console.service.zx;

import com.zx.share.platform.bean.zx.ZxUserPrinter;
import com.zx.share.platform.util.response.DefaultResopnseBean;

/**
 * 
 * @ClassName: ZxUserPrinterService
 * @Description: 设备线上管理员业务接口类
 * @author 芸江
 * @date 2018年2月1日 上午10:03:26
 *
 */
public interface ZxUserPrinterService {

	/**
	 * 
	 * @Title: update
	 * @Description: 改变线上管理员信息
	 */
	public DefaultResopnseBean<Object> update(ZxUserPrinter zxUP);

	/**
	 * 
	 * @Title: add
	 * @Description: 添加线上管理员信息
	 */
	public DefaultResopnseBean<Object> add(ZxUserPrinter zxUP);

	/**
	 * 
	 * @Title: query
	 * @Description: 通过实体类属性查询线上管理员信息（单表查询）
	 */
	public DefaultResopnseBean<Object> query(ZxUserPrinter record);
}
