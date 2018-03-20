package com.zx.share.platform.common.service;

import com.zx.share.platform.common.bean.UserCache;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.constants.OCSKeys;
import com.zx.share.platform.exception.BusinessException;
import com.zx.share.platform.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 缓存service
 * 
 * @author fenggang
 */
@Service("tokenCacheService")
public class TokenCacheService {

	@Resource
	private MemcachedService memcachedService;

	private static final String ACCESS_TOKEN_HEADER_NAME = OCSKeys.ACCESS_TOKEN_HEADER_NAME;

	private static String USER_KEY = OCSKeys.ZX_TOKEN_USER_KEY;
	private static int USER_EXP_KEY = OCSKeys.ZX_TOKEN_USER_EXP_KEY;
	private static int USER_REGISTER_CODE_TIME_KEY = OCSKeys.ZX_USER_REGISTER_CODE_TIME_KEY;
	private static String USER_REGISTER_CODE_KEY = OCSKeys.ZX_USER_REGISTER_CODE_KEY;
	private static String USRE_FORGET_PASSWORD_CODE_KEY = OCSKeys.ZX_USRE_FORGET_PASSWORD_CODE_KEY; 

	private static String USER_LOGIN_CODE_KEY = OCSKeys.ZX_USER_LOGIN_CODE_KEY;
	private static int USER_LOGIN_CODE_TIME_KEY = OCSKeys.ZX_USER_LOGIN_CODE_TIME_KEY;

	public void cacheCode(String seesionId,String text){
		memcachedService.set(seesionId, OCSKeys.ZX_USER_REGISTER_TIME_KEY, text);
	}

	public String getCacheCode(String seesionId){
		Object obj = memcachedService.get(seesionId);
		if(obj == null){
			return null;
		}
		return obj.toString();
	}

	/**
	 * 将验证码写入到缓存中，有效时间为5分钟
	 * 
	 * @param code
	 */
	public void cacheRegisterCode(String tel, String code) {
		String key = USER_REGISTER_CODE_KEY + tel;
		memcachedService.set(key, USER_REGISTER_CODE_TIME_KEY, code);
	}

	/**
	 * 获取缓存中的注册验证码
	 * 
	 * @return
	 */
	public String getCacheRegisterCode(String tel) {
		String key = USER_REGISTER_CODE_KEY + tel;
		Object object = memcachedService.get(key);
		if (object == null) {
			return "";
		}
		return object.toString();
	}

	/**
	 * 将登录验证码写入到缓存中，有效时间为5分钟
	 * 
	 * @param code
	 */
	public void cacheLoginCode(String tel, String code) {
		String key = USER_LOGIN_CODE_KEY + tel;
		memcachedService.set(key, USER_LOGIN_CODE_TIME_KEY, code);
	}

	/**
	 * 获取缓存中的登录验证码
	 * 
	 * @return
	 */
	public String getCacheLoginCode(String tel) {
		String key = USER_LOGIN_CODE_KEY + tel;
		Object object = memcachedService.get(key);
		if (object == null) {
			return "";
		}
		return object.toString();
	}

	public void cacheforgetPasswordCode(String mobile, String code) {
		String key = USRE_FORGET_PASSWORD_CODE_KEY + mobile;
		memcachedService.set(key, USER_REGISTER_CODE_TIME_KEY, code);
	}

	public String getCacheforgetPasswordCode(String mobile) {
		String key = USRE_FORGET_PASSWORD_CODE_KEY + mobile;
		Object object = memcachedService.get(key);
		if (object == null) {
			return "";
		}
		return object.toString();
	}

	/**
	 * <pre>
	 * 设置用户信息到缓存中
	 * 
	 * <pre>
	 * 
	 * @param request
	 * @param user
	 */
	public void cacheUser(HttpServletRequest request, UserCache user) {
		String key = getUserCacheKey(request);
		memcachedService.set(key, USER_EXP_KEY, user);
	}

	/**
	 * <pre>
	 * 获取缓存用户，不为空，重新设置缓存中用户的过期时间
	 * </pre>
	 * 
	 * @param request
	 * @return
	 */
	public UserCache getCacheUser(HttpServletRequest request) throws Exception {
		String key = getUserCacheKey(request);
		Object obj = memcachedService.get(key);
		if (obj == null) {
			throwException(ErrorsEnum.SYSTEM_NOT_LOGIN.code,ErrorsEnum.SYSTEM_NOT_LOGIN.label);
		}
		UserCache user = (UserCache) obj;
		if (user != null) {
			memcachedService.set(key, USER_EXP_KEY, user);
			if(user.getStatus()!=1){
				throwException(ErrorsEnum.SYSTEM_USER_STUTUS_LONGIN.code,ErrorsEnum.SYSTEM_USER_STUTUS_LONGIN.label);
			}
		}
		return user;
	}

	/**
	 * 删除缓存中得用户信息
	 * 
	 * @param request
	 */
	public void deleteCacheUser(HttpServletRequest request) {
		String key = getUserCacheKey(request);
		memcachedService.delete(key);
	}

	/**
	 * 获取用户缓存key
	 * 
	 * @param request
	 * @return
	 */
	private String getUserCacheKey(HttpServletRequest request) {
		String key = USER_KEY + getCacheKey(request);
		return key;
	}

	/**
	 * <pre>
	 * 获取缓存key 
	 * 同时使用，使用token保存登录信息，优先使用token，如果获取失败则取session
	 * </pre>
	 * 
	 * @param request
	 */
	private String getCacheKey(HttpServletRequest request) {
		Object sessionId = request.getAttribute(ACCESS_TOKEN_HEADER_NAME);
		if (StringUtil.isBlank(sessionId)) {
			Object sessionIdAttribute = request.getHeader(ACCESS_TOKEN_HEADER_NAME);
			if (StringUtil.isNotBlank(sessionIdAttribute)) {
				sessionId = sessionIdAttribute.toString();
			}
		}
		if (StringUtil.isBlank(sessionId)) {
			sessionId = request.getParameter("token");
		}
		if (StringUtil.isBlank(sessionId)) {
			sessionId = request.getSession().getId();
		}
		return sessionId.toString();
	}

	/**
	 * 生成登录权限token
	 * 
	 * @param request
	 * @param userId
	 * @return
	 */
	public String generateAccessToken(HttpServletRequest request, String userId) {
		return request.getSession().getId();
	}

	private void throwException(int code, String codeLabel) throws Exception {
		BusinessException e = new BusinessException(code, codeLabel, codeLabel);
		throw e;
	}

}
