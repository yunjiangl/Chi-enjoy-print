package com.zx.share.platform.common.service;

import com.alibaba.fastjson.JSON;
import com.zx.share.platform.common.bean.MySession;
import com.zx.share.platform.constants.OCSKeys;
import com.zx.share.platform.vo.wechat.response.UserDetailsBean;
import net.spy.memcached.MemcachedClient;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 缓存service
 * 
 * @author fenggang
 */
@Service("memcachedService")
public class MemcachedService {

	private MemcachedClient memcachedClient;



	/**
	 * 设置缓存
	 *
	 * @param key：关键字
	 * @param exprieTime：过期时间，单位秒（例如exprieTime=30，为30秒）
	 * @param value：值
	 */
	public void set(String key, int exprieTime, Object value) {
		JedisService.set(key, value.toString(), exprieTime);
	}

	/**
	 * 删除缓存
	 *
	 * @param key
	 */
	public void delete(String key) {
		//memcachedClient.delete(key);
		JedisService.del(key);
	}

	/**
	 * 获取缓存值
	 *
	 * @param key
	 * @return
	 */
	public Object get(String key) {
//		return memcachedClient.get(key);
		return JedisService.get(key);
	}


	/**
	 * 获得缓存中的数据并重置其过期时间.
	 *
	 * @param key
	 * @param exprieTime
	 */
	public Object getAndTouch(String key, int exprieTime) {
		Object value = this.get(key);
		if (value != null) {
			this.set(key, exprieTime, value.toString());
		}
		return value;
	}

	/**
	 * 缓存值+1，返回+1之后的值
	 *
	 * @param key
	 * @return
	 */
	protected long incr(String key) {
		return memcachedClient.incr(key, 1);
	}

	/**
	 * 缓存值-1，返回-1之后的值
	 *
	 * @param key
	 * @return
	 */
	protected long decr(String key) {
		return memcachedClient.decr(key, 1, 1l);
	}

	/**
	 * 批量获取缓存值
	 *
	 * @param keys
	 * @return
	 */
	protected Map<String, Object> getBulk(List<String> keys) {
		return memcachedClient.getBulk(keys);
	}

	public static final String SESSION_PREFIX = "SESSION_";

	// 保存session
	public void setSession(String sessionId, MySession session) {
		if (session == null) {
			return;
		}
		set(SESSION_PREFIX + sessionId, 60*60,JSON.toJSONString(session));
	}

	// 获得session
	public MySession getSession(String sessionId) {
		Object obj = get(SESSION_PREFIX + sessionId);
		if (obj != null) {
			return JSON.parseObject(obj.toString(), MySession.class);
		}
		return null;
	}

	// 删除session
	public void delSession(String sessionId) {
		delete(SESSION_PREFIX + sessionId);
	}

	public void deleteKey(String key){
		delete(key);
	}

}
