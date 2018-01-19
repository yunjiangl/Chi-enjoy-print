package com.exqoo.utils.aop;

import com.alibaba.fastjson.JSON;
import com.exqoo.entity.SysLogEntity;
import com.exqoo.utils.HttpContextUtils;
import com.exqoo.utils.ShiroUtils;
import com.exqoo.utils.annotation.SysLog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 系统日志，切面处理类
 * 
 */
@Aspect
@Component
public class SysLogAspect {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	// 定义Pointcut，Pointcut的名称 就是simplePointcut，此方法不能有返回值，该方法只是一个标示
	// @annotation 指定自定义注解
	@Pointcut("@annotation(com.exqoo.utils.annotation.SysLog)")
	public void logPointCut() {

	}

	@Before("logPointCut()")
	public void saveSysLog(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();

		SysLogEntity sysLog = new SysLogEntity();
		SysLog syslog = method.getAnnotation(SysLog.class);
		if (syslog != null) {
			// 注解上的描述
			sysLog.setOperation(syslog.value());
			logger.info(syslog.value());

		}

		logger.info("请求的时间：" + new Date());

		// 请求的方法名
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();
		sysLog.setMethod(className + "." + methodName + "()");
		logger.info("请求的方法：" + className + "." + methodName + "()");

		// 请求的参数
		Object[] args = joinPoint.getArgs();
		String params = JSON.toJSONString(args);
		sysLog.setParams(params);
		logger.info("请求的参数：" + params);

		// 获取request
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();

		// 用户名
		String username = ShiroUtils.getUserEntity().getUsername();
		sysLog.setUsername(username);

		sysLog.setCreateDate(new Date());
	}

	@After("logPointCut()")
	public void afterLog() {
		logger.info("请求结束");
	}
}
