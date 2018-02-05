package com.zx.share.platform.console.service.zx;

import com.zx.share.platform.bean.zx.ZxUserPrinterApply;
import com.zx.share.platform.util.response.DefaultResopnseBean;

/**
 * 
 * @ClassName: ZxUserPrinterApplyService
 * @Description: 设备线上管理员申请业务接口类
 * @author 芸江
 * @date 2018年2月2日 下午2:42:14
 *
 */
public interface ZxUserPrinterApplyService {

	/**
	 * 
	 * @Title: add
	 * @Description: 添加设备线上管理员申请
	 */
	public DefaultResopnseBean<Object> add(ZxUserPrinterApply zxUPA);

	/**
	 * 
	 * @Title: updata
	 * @Description: 修改设备线上管理员申请信息
	 */
	public DefaultResopnseBean<Object> update(ZxUserPrinterApply zxUPA);

	/**
	 * 
	 * @Title: query
	 * @Description: 通过设备线上管理员申请属性查询设备线上管理员申请信息
	 */
	public DefaultResopnseBean<Object> query(ZxUserPrinterApply zxUPA);

}
