package com.zx.share.platform.console.service.sys;

import java.util.Map;

import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

public interface SysLawyerUserService {
	
	DefaultResopnseBean<Object> update(ZxUser zxUser);

	DefaultResopnseBean<PageResponseBean<ZxUser>> list(Map<String, Object> params);

	DefaultResopnseBean<Object> queryByZxPMId(Long id);
	

}
