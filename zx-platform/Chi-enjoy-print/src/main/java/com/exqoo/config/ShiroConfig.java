package com.exqoo.config;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.exqoo.filter.KickoutSessionControlFilter;
import com.exqoo.utils.shiro.UserRealm;

/**
 * Shiro配置
 *
 */
@Configuration
public class ShiroConfig {

	@Value("${spring.redis.host}")
	private String host;

	@Value("${spring.redis.port}")
	private int port;

	@Value("${spring.redis.timeout}")
	private int timeout;

	@Value("${spring.redis.password}")
	private String password;

	@Bean("shiroFilter")
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		

		// 必须设置 SecurityManager
		shiroFilter.setSecurityManager(securityManager);

		shiroFilter.setLoginUrl("/login");
		shiroFilter.setSuccessUrl("/index");
		shiroFilter.setUnauthorizedUrl("/403");


		Map<String, String> filterMap = new LinkedHashMap<>();
		filterMap.put("/public/**", "anon,kickout");
		filterMap.put("/webjars/**", "anon,kickout");
		filterMap.put("/api/**", "anon,kickout");

		// swagger配置
		filterMap.put("/swagger**", "anon,kickout");
		filterMap.put("/v2/api-docs", "anon,kickout");
		filterMap.put("/swagger-resources/configuration/ui", "anon,kickout");

		filterMap.put("/login", "anon,kickout");
		filterMap.put("/sys/login", "anon,kickout");
		filterMap.put("/captcha.jpg", "anon,kickout");
		filterMap.put("/**", "authc,kickout");
		shiroFilter.setFilterChainDefinitionMap(filterMap);
		

		// 自定义拦截器
		Map<String, Filter> filtersMap = new LinkedHashMap<String, Filter>();
		// 限制同一帐号同时在线的个数。
		filtersMap.put("kickout", kickoutSessionControlFilter());
		shiroFilter.setFilters(filtersMap);

		return shiroFilter;
	}

	@Bean(name = "securityManager")
	public SecurityManager securityManager(UserRealm userRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(userRealm);
		// 自定义缓存实现 使用redis
		securityManager.setCacheManager(cacheManager());
		// 自定义session管理 使用redis
		securityManager.setSessionManager(sessionManager());
		return securityManager;
	}

	/**
	 * 配置shiro redisManager 使用的是shiro-redis开源插件
	 * 
	 * @return
	 */
	public RedisManager redisManager() {
		RedisManager redisManager = new RedisManager();
		redisManager.setHost(host);
		redisManager.setPort(port);
		redisManager.setPassword(password);
		redisManager.setExpire(1800);// 配置缓存过期时间
		redisManager.setTimeout(timeout);
		// redisManager.setPassword(password);
		return redisManager;
	}

	/**
	 * cacheManager 缓存 redis实现 使用的是shiro-redis开源插件
	 * 
	 * @return
	 */
	public RedisCacheManager cacheManager() {
		RedisCacheManager redisCacheManager = new RedisCacheManager();
		redisCacheManager.setRedisManager(redisManager());
		return redisCacheManager;
	}

	/**
	 * RedisSessionDAO shiro sessionDao层的实现 通过redis 使用的是shiro-redis开源插件
	 */
	@Bean
	public RedisSessionDAO redisSessionDAO() {
		RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
		redisSessionDAO.setRedisManager(redisManager());
		return redisSessionDAO;
	}

	@Bean(name = "sessionManager")
	public SessionManager sessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		//设置session过期时间为1小时(单位：毫秒)，默认为30分钟
        sessionManager.setGlobalSessionTimeout(60 * 60 * 1000);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionIdUrlRewritingEnabled(false);
		sessionManager.setSessionDAO(redisSessionDAO());
		return sessionManager;
	}

	/**
	 * 限制同一账号登录同时登录人数控制
	 * 
	 * @return
	 */
	public KickoutSessionControlFilter kickoutSessionControlFilter() {
		KickoutSessionControlFilter kickoutSessionControlFilter = new KickoutSessionControlFilter();
		// 使用cacheManager获取相应的cache来缓存用户登录的会话；用于保存用户—会话之间的关系的；
		// 这里我们还是用之前shiro使用的redisManager()实现的cacheManager()缓存管理
		// 也可以重新另写一个，重新配置缓存时间之类的自定义缓存属性
		kickoutSessionControlFilter.setCacheManager(cacheManager());
		// 用于根据会话ID，获取会话进行踢出操作的；
		kickoutSessionControlFilter.setSessionManager(sessionManager());
		// 是否踢出后来登录的，默认是false；即后者登录的用户踢出前者登录的用户；踢出顺序。
		kickoutSessionControlFilter.setKickoutAfter(false);
		// 同一个用户最大的会话数，默认1；比如2的意思是同一个用户允许最多同时两个人登录；
		kickoutSessionControlFilter.setMaxSession(1);
		// 被踢出后重定向到的地址；
		kickoutSessionControlFilter.setKickoutUrl("/login");
		return kickoutSessionControlFilter;
	}

}
