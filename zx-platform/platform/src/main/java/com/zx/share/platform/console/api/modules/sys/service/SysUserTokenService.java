package com.zx.share.platform.console.api.modules.sys.service;

import com.zx.share.platform.console.api.common.utils.R;
import com.zx.share.platform.console.api.modules.sys.entity.SysUserTokenEntity;

/**
 * 用户Token
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2017-03-23 15:22:07
 */
public interface SysUserTokenService {

	SysUserTokenEntity queryByUserId(Long userId);

	void save(SysUserTokenEntity token);
	
	void update(SysUserTokenEntity token);

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	R createToken(long userId);

	/**
	 * 退出，修改token值
	 * @param userId  用户ID
	 */
	void logout(long userId);

}
