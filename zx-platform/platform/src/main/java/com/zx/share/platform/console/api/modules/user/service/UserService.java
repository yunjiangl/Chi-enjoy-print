package com.zx.share.platform.console.api.modules.user.service;

import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.console.api.modules.user.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户
 * 
 * @author Andy
 * @email andyeasons@163.com
 * @date 2017-10-23 21:23:54
 */
public interface UserService {

	ZxUser queryObject(Long userId);
	
	List<ZxUser> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ZxUser userEntity);

	void save(String mobile, String password);

	void update(ZxUser user);
	
	void delete(Long userId);

	/**
	 * 删除，只修改用户状态
	 * @param userIds
	 */
	void deleteBatch(Long[] userIds);

	ZxUser queryByMobile(String mobile);

	/**
	 * 用户登录
	 * @param mobile    手机号
	 * @param password  密码
	 * @return          返回用户ID
	 */
	long login(String mobile, String password);
}
