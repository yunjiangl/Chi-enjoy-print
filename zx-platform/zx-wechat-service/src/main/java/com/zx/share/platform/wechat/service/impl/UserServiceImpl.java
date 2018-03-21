package com.zx.share.platform.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.common.service.TokenCacheService;
import com.zx.share.platform.vo.user.UserRequestBean;
import com.zx.share.platform.vo.user.UserResultBean;
import com.zx.share.platform.wechat.mapper.UserMapper;
import com.zx.share.platform.wechat.service.SmsService;
import com.zx.share.platform.wechat.service.UserService;

/**
 * Created by fenggang on 18/3/5.
 *
 * @author fenggang
 * @date 18/3/5
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private TokenCacheService tokenCacheService;
	@Autowired
	private SmsService smsService;

	@Override
	public UserResultBean findByOpenId(String unionId) {
		return userMapper.findByOpenId(unionId);
	}

	@Override
	public Integer save(UserRequestBean bean) {
		return userMapper.save(bean);
	}

	@Override
	public Integer update(UserRequestBean bean) {
		return null;
	}

	@Override
	public String registerCode(String mobile) {

		try {
			int code = (int) (Math.random() * 9999) + 1000; // 随机生成五位数验证码
			smsService.smsCode("SMS_1000000", mobile, "智享打印",
					"{\"name\":\"Tom\", \"code\":\"" + Integer.toString(code) + "\"}");
			tokenCacheService.cacheRegisterCode(mobile, Integer.toString(code));
			System.out.println("验证码：" + code);

			return Integer.toString(code);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public String forgetpasswordCode(String mobile) {
		return null;
	}

	@Override
	public Integer update(ZxUser user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}
}
