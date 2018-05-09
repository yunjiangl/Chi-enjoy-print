package com.zx.share.platform.wechat.api.interceptor;

import com.zx.share.platform.common.bean.SessionConfig;
import com.zx.share.platform.common.bean.UserCache;
import com.zx.share.platform.common.service.SercurityService;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.exception.BusinessException;
import com.zx.share.platform.util.annotation.ACSPermissions;
import com.zx.share.platform.vo.WxLoginResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录校验拦截器 Created by fenggang on 1/24/18.
 *
 * @author fenggang
 * @date 1/24/18
 */
@Component
public class LoginValidationInterceptor extends HandlerInterceptorAdapter {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private SercurityService sercurityService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			ACSPermissions acsPermissions = handlerMethod.getMethodAnnotation(ACSPermissions.class);
			String path = request.getServletPath();
			if (path.indexOf("null") >= 0) {
				throwException(ErrorsEnum.SYSTEM_REQUEST_URL_ERROR.code, ErrorsEnum.SYSTEM_REQUEST_URL_ERROR.label);
			}
			// 2、判断用户是否登录
			if (request.getMethod().equals("OPTIONS")) {
				return true;
			}
			if (request.getServletPath().equals("/error")) {
				throw new BusinessException(ErrorsEnum.SYSTEM_ERROR);
			}
			logger.info("接口【{}】请求开始登录验证", request.getServletPath());
			sercurityService.sessionValidation(request);
			WxLoginResponseVo user = sercurityService.getUserToken(request);
			logger.info("用户【" + user.getNickName() + "】操作了接口：【{}】", request.getServletPath());

			request.setAttribute(SessionConfig.DEFAULT_REQUEST_DRUG_USER, user);
			return true;
		}
		return super.preHandle(request, response, handler);
	}

	private void throwException(int code, String codeLabel) throws Exception {
		BusinessException e = new BusinessException(code, codeLabel, codeLabel);
		throw e;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
	}
}
