package com.zx.share.platform.wechat.service.impl;

import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.common.service.MemcachedService;
import com.zx.share.platform.common.service.TokenCacheService;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.constants.OCSKeys;
import com.zx.share.platform.util.StringUtil;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.vo.user.UserRequestBean;
import com.zx.share.platform.vo.user.UserResultBean;
import com.zx.share.platform.vo.wechat.request.UserAttorneyDomain;
import com.zx.share.platform.vo.wechat.request.UserUpdateBean;
import com.zx.share.platform.vo.wechat.response.AttorneyDetailsBean;
import com.zx.share.platform.vo.wechat.response.UserDetailsBean;
import com.zx.share.platform.wechat.mapper.UserMapper;
import com.zx.share.platform.wechat.service.SmsService;
import com.zx.share.platform.wechat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
	@Autowired
	private MemcachedService memcachedService;

	@Override
	public UserResultBean findByOpenId(String unionId) {
		return userMapper.findByOpenId(unionId);
	}

	@Transactional(readOnly = false)
	@Override
	public Integer save(UserRequestBean bean) {
		return userMapper.save(bean);
	}

	@Transactional(readOnly = false)
	@Override
	public Integer update(UserRequestBean bean) {
		UserUpdateBean userSaveBean = new UserUpdateBean();
		userSaveBean.setUserCode(bean.getUserCode());
		userSaveBean.setUnionId(bean.getUnionId());
		userSaveBean.setOpenId(bean.getOpenId());
		userSaveBean.setPortrait(bean.getHeadImgUrl());
		return userMapper.update(userSaveBean);
	}

	/**
	 * 用户信息修改
	 *
	 * @param bean
	 * @return
	 */
	@Override
	public Integer updateUser(UserUpdateBean bean) {
		return userMapper.update(bean);
	}

	/**
	 * 律师信息修改
	 * @param bean
	 * @return
	 */
	@Transactional(readOnly = false)
	@Override
	public Integer update(UserUpdateBean bean) {
		userMapper.update(bean);
		ZxUser user = this._findCode(bean.getUserCode());
		bean.setUserId(user.getId());
		userMapper.deleteAttorney(bean.getUserCode());
		userMapper.saveAttorney(bean);
		userMapper.deleteAttorneyDomain(bean.getUserCode());
		String domain = bean.getDomains();
		if(StringUtil.isNotBlank(domain)){
			List<UserAttorneyDomain> domainList = new ArrayList<>();
			String[] domains = domain.split(",");
			for (String domainCode:domains){
				UserAttorneyDomain saveDomain = new UserAttorneyDomain();
				saveDomain.setUserCode(bean.getUserCode());
				saveDomain.setUserId(bean.getUserId());
				saveDomain.setDomainCode(domainCode);
				domainList.add(saveDomain);
			}


			if(domainList!=null && !domainList.isEmpty()){
				userMapper.saveAttorneyDomain(domainList);
				//匹配关系
				userMapper.updateAttorneyDomain(bean.getUserCode());
			}
		}
		return 1;
	}


	@Override
	public String registerCode(String mobile) {

		try {
			int code = (int) (Math.random() * 9999) + 1000; // 随机生成五位数验证码
			smsService.smsCode("SMS_127158214", mobile, "小刚",
					"{ \"code\":\"" + Integer.toString(code) + "\"}");
			tokenCacheService.cacheRegisterCode(mobile, Integer.toString(code));
			System.out.println("验证码：" + code);

			return Integer.toString(code);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	private ZxUser _findCode(String code){
		ZxUser record = new ZxUser();
		record.setUserCode(code);
		ZxUser user = userMapper.selectOne(record);
		return user;
	}

	@Override
	public String forgetpasswordCode(Long userId) {

		ZxUser record = new ZxUser();
		record.setId(userId);
		ZxUser user = userMapper.selectOne(record);
		try {
			int code = (int) (Math.random() * 9999) + 1000; // 随机生成五位数验证码
			smsService.smsCode("SMS_127158214", user.getMobile(), "小刚",
					"{ \"code\":\"" + Integer.toString(code) + "\"}");
			tokenCacheService.cacheforgetPasswordCode(user.getMobile(), Integer.toString(code));
			System.out.println("验证码：" + code);
			return Integer.toString(code);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer update(ZxUser user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}

	/**
	 * 验证手机和验证码
	 */
	@Override
	public DefaultResopnseBean<Object> verification(Long userId, String code) {
		ZxUser record = new ZxUser();
		record.setId(userId);
		ZxUser user = userMapper.selectOne(record);

		DefaultResopnseBean<Object> resopnseBean = new DefaultResopnseBean<>();

		if (code.equals(tokenCacheService.getCacheforgetPasswordCode(user.getMobile()))) {
			// 验证码正确
			resopnseBean.setCode(ErrorsEnum.SUCCESS.code);
			resopnseBean.setMessage(ErrorsEnum.SUCCESS.label);
		} else {
			// 验证码错误
			resopnseBean.setCode(ErrorsEnum.SYSTEM_CUSTOM_ERROR.code);
			resopnseBean.setMessage("验证码错误");
		}
		return resopnseBean;
	}

	@Override
	public UserDetailsBean details(String userCode) {
		String key = OCSKeys.ZX_USER_DETAILS_CACHE_KEY+userCode;
		Object obj = null;//memcachedService.getAndTouch(key, OCSKeys.ZX_USER_DETAILS_CACHE_KEY_EXP_KEY);
		UserDetailsBean resultBean = null;
		if(obj==null){
			resultBean = userMapper.findByCode(userCode);
			AttorneyDetailsBean attorney = userMapper.findByAttorney(userCode);
			if(attorney!=null){
				List<String> domains = userMapper.findByAttorneyDomains(userCode);
				attorney.setDomainList(domains);
				resultBean.setAttorney(attorney);
			}
			memcachedService.set(key, OCSKeys.ZX_USER_DETAILS_CACHE_KEY_EXP_KEY,resultBean);
		}else{
			 resultBean = (UserDetailsBean)obj;
		}
		return resultBean;
	}

	@Override
	public String findMaxId(String userCode) {
		Long id = userMapper.findMaxId(userCode+"%");

		return id==null || id==0 ?"0":id.toString();
	}
}
