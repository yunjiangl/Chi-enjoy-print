package com.zx.share.platform.console.api.modules.sys.controller;

import com.zx.share.platform.bean.sys.SysUser;
import com.zx.share.platform.util.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Controller公共组件
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2016年11月9日 下午9:42:26
 */
public abstract class AbstractController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected SysUser getUser() {
		return (SysUser) SecurityUtils.getSubject().getPrincipal();
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}

	/**
	 * 判断是否物主
	 * @return
	 */
	protected boolean checkOwner(){
		SysUser user = getUser();
		if(StringUtil.isNotBlank(user.getUserType()) && user.getUserType()==2){
			return true;
		}
		return false;
	}

	/**
	 * 往条件中加入当前用户id
	 * @param params
	 * @return
	 */
	protected Map<String, Object> checkOwnerParams(Map<String, Object> params){
		if(checkOwner()){
			params.put("createId",getUserId());
		}
		return params;
	}
}
