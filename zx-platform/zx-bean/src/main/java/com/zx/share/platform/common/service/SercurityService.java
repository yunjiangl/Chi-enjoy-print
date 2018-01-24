package com.zx.share.platform.common.service;

import com.alibaba.fastjson.JSONObject;
import com.zx.share.platform.common.bean.MySession;
import com.zx.share.platform.common.bean.SessionConfig;
import com.zx.share.platform.common.bean.UserToken;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.exception.NeedLoginException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author fenggang
 */
@Service("sercurityService")
public class SercurityService {
	private static Logger logger = LoggerFactory.getLogger(SercurityService.class);

	@Resource
	MemcachedService memUtils;

	public void saveSession(HttpServletRequest request, HttpServletResponse response, UserToken user) {

//		Cookie[] cookies = request.getCookies();
		String sessionId = request.getSession().getId();
//		if ((cookies != null) && (cookies.length > 0)) {
//			for (Cookie cookie : cookies) {
//				String name = cookie.getName();
//				String value = cookie.getValue();
//				if (SessionConfig.DEFAULT_SESSION_COOKIE_NAME.equals(name)) {
//					sessionId = value;
//					break;
//				}
//			}
//		}

		MySession session = new MySession(sessionId);
		session.setAttribute(SessionConfig.DEFAULT_OPERATOR_REQUEST_ATTRIBUTE_NAME, user);
		memUtils.setSession(session.getId(), session);

//		Cookie cookie = new Cookie(SessionConfig.DEFAULT_SESSION_COOKIE_NAME, session.getId());
//		cookie.setPath("/");
//		// 失效时间
//		cookie.setMaxAge(-1);
//		response.addCookie(cookie);

	}

	public void cleanSession(HttpServletRequest request) throws NeedLoginException {

		String sessionId = getSessionId(request);

		if (!StringUtils.isEmpty(sessionId)) {
			memUtils.delSession(sessionId);
		}
	}

	public MySession getSession(HttpServletRequest request) throws NeedLoginException {

		String sessionId = getSessionId(request);

		MySession session = memUtils.getSession(sessionId);

		if (session == null || session.getAttribute(SessionConfig.DEFAULT_OPERATOR_REQUEST_ATTRIBUTE_NAME) == null) {
			throw new NeedLoginException(ErrorsEnum.SYSTEM_NOT_LOGIN_STATUS);
		}

		return session;
	}

	public UserToken getUserToken(HttpServletRequest request) throws NeedLoginException {
		MySession session = getSession(request);
		Object obj = session.getAttribute(SessionConfig.DEFAULT_OPERATOR_REQUEST_ATTRIBUTE_NAME);
		return JSONObject.parseObject(obj.toString(), UserToken.class);
	}

	public void sessionValidation(HttpServletRequest request) throws NeedLoginException {

		String sessionId = getSessionId(request);

		// 检测mem
		MySession session = memUtils.getSession(sessionId);
		if (session == null || session.getAttribute(SessionConfig.DEFAULT_OPERATOR_REQUEST_ATTRIBUTE_NAME) == null) {
			logger.debug("Session is out of time");
			throw new NeedLoginException(ErrorsEnum.SYSTEM_NOT_LOGIN_STATUS);
		}

	}

	public void flushCookie(String sessionId, HttpServletResponse response) {

		Cookie cookie = new Cookie(SessionConfig.DEFAULT_SESSION_COOKIE_NAME, sessionId);
		cookie.setPath("/");
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
	}

	private String getSessionId(HttpServletRequest request) throws NeedLoginException {

		Cookie[] cookies = request.getCookies();
		String sessionId = request.getSession().getId();
//		if ((cookies != null) && (cookies.length > 0)) {
//			for (Cookie cookie : cookies) {
//				String name = cookie.getName();
//				String value = cookie.getValue();
//				if (SessionConfig.DEFAULT_SESSION_COOKIE_NAME.equals(name)) {
//					sessionId = value;
//					break;
//				}
//			}
//		}

		if (StringUtils.isEmpty(sessionId)) {
			throw new NeedLoginException(ErrorsEnum.SYSTEM_NOT_LOGIN_STATUS);
		}

		return sessionId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.idailycar.ops.service.SercurityService#refreshSession(com.idailycar.ops.domain.Operator,
	 * javax.servlet.http.HttpServletRequest)
	 */
	public void refreshSession(UserToken user, HttpServletRequest request) throws NeedLoginException {

		// 找到当前session
		MySession session = getSession(request);

		// 把新用户信息保存到session中
		session.setAttribute(SessionConfig.DEFAULT_OPERATOR_REQUEST_ATTRIBUTE_NAME, user);

		// 把session保存到缓存中
		memUtils.setSession(session.getId(), session);
	}

}
