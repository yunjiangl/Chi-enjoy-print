package com.zx.share.platform.wechat.service;

import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.vo.user.UserRequestBean;
import com.zx.share.platform.vo.user.UserResultBean;
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

	Integer update(UserRequestBean bean);

	Integer update(ZxUser user);

	String registerCode(String mobile);

	String forgetpasswordCode(Long userId);

	DefaultResopnseBean<Object> verification(Long userId, String code);


	UserDetailsBean details(String userCode);
}
