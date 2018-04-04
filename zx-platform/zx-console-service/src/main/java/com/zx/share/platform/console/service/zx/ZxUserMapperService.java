package com.zx.share.platform.console.service.zx;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;


public interface ZxUserMapperService {
	
	/**
	 * 设备管理添加线上管理员遍历
	 */
	List<ZxUser> selectOnlineAdmin();
	/**
	 * 设备列表添加线上管理员查看功能 
	 */
	ZxUser selectOnlineAdminById(Long id);
	/**
	 * 
	 * @设备线上管理员分页遍历
	 * @return
	 */
	DefaultResopnseBean<PageResponseBean<ZxUser>> selectAdminByPage(Map<String, Object> params);
	/**
	 * 设备管理线上管理员查看接口
	 */
	ZxUser selectZxAdminById(Long id);
	
	

}
