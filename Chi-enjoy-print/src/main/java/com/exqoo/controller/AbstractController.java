package com.exqoo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.exqoo.entity.SysUser;
import com.exqoo.utils.ShiroUtils;

/**
 * Controller公共组件
 * 
 */
public abstract class AbstractController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected SysUser getUser() {
		return ShiroUtils.getUserEntity();
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}
}
