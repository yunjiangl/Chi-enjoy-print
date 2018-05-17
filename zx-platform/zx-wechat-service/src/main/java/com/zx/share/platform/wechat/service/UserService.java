package com.zx.share.platform.wechat.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.vo.user.UserRequestBean;
import com.zx.share.platform.vo.user.UserResultBean;
import com.zx.share.platform.vo.wechat.request.UserUpdateBean;
import com.zx.share.platform.vo.wechat.response.UserDetailsBean;

/**
 * Created by fenggang on 18/3/5.
 *
 * @author fenggang
 * @date 18/3/5
 */
public interface UserService {

	UserResultBean findByOpenId(String unionId);

	Integer save(UserRequestBean bean);

	Integer insert(ZxUser zxUser);

	Integer update(UserRequestBean bean);

	/**
	 * 律师信息修改
	 * @param bean
	 * @return
	 */
	Integer update(UserUpdateBean bean);

	/**
	 * 用户信息修改
	 * @param bean
	 * @return
	 */
	Integer updateUser(UserUpdateBean bean);

	Integer update(ZxUser user);


	String registerCode(String mobile);

	String forgetpasswordCode(Long userId);

	DefaultResopnseBean<Object> verification(Long userId, String code);


	UserDetailsBean details(String userCode);

	String findMaxId(String userCode);

	UserDetailsBean findByMobile(String mobile);

	UserDetailsBean findByMobilePwd(String mobile,String pwd);
	
	List<ZxUser> newsSelect(String name);
	
	ZxUser codeSelect(String code);
	
	ZxUser selectByUcode(String Ucode);
}
