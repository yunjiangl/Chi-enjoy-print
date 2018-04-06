package com.zx.share.platform.console.service.zx;

import java.util.Map;

import com.zx.share.platform.bean.zx.ZxPrinterManager;
import com.zx.share.platform.bean.zx.ZxUserPrinterApply;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

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
	
	/**
	 * 消息通知
	 * @param userName
	 * @param status
	 * @return
	 */
	public DefaultResopnseBean<PageResponseBean<ZxUserPrinterApply>> selectNewsList(Map<String, Object> params);
	
	public DefaultResopnseBean<Object> addNews(int Id);

	public DefaultResopnseBean<PageResponseBean<ZxUserPrinterApply>> list(Map<String, Object> params);

}
