package com.zx.share.platform.console.service.sys;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zx.share.platform.bean.sys.SysRole;
import com.zx.share.platform.bean.sys.SysUser;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

public interface SysFrontDeskUserService {
	
	/**
	 * 查询出全部未删除的前台用户管理数据
	 * @return
	 */
	DefaultResopnseBean<PageResponseBean<SysUser>> selectFrontDeskUserAll(Long roleId,Map<String, Object> param);
	
	/**
	 * 禁用前台数据
	 */
	Integer updateFrontDeskUser(Long userId);
	
	/**
	 * 模糊查询
	 */
	DefaultResopnseBean<PageResponseBean<SysUser>> selectFrontDeskUserDim(@Param("name") String name,
										@Param("perms") String perms,
										@Param("time1") Date  time1,
										@Param("time2") Date time2,
										Map<String, Object> param);
}
