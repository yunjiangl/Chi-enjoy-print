package com.zx.share.platform.common.service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by fenggang on 18/5/18.
 *
 * @author fenggang
 * @date 18/5/18
 */
public class JedisService {
    private static JedisPool jedisPool = null;
    private static final int port = 6379;
    private static final int timeout = 2000;

//    private static String host = "r-bp10fb3a48dd2264.redis.rds.aliyuncs.com";
//    private static String password ="A123456b";

  private static String host = "120.27.244.237";
  private static String password ="Xz(1035)";

    private synchronized static JedisPool getJedisPool(){
        if(jedisPool==null){
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxIdle(600);
            jedisPoolConfig.setMaxTotal(600);
            jedisPoolConfig.setMinIdle(30);
            jedisPoolConfig.setMaxWaitMillis(1000);
            jedisPoolConfig.setTimeBetweenEvictionRunsMillis(30000);
            jedisPoolConfig.setNumTestsPerEvictionRun(30);
            //在获取连接的时候检查有效性, 默认false
            jedisPoolConfig.setTestOnBorrow(true);
            //在空闲时检查有效性, 默认false
            jedisPoolConfig.setTestWhileIdle(true);
            //在进行returnObject对返回的connection进行validateObject校验
            jedisPoolConfig.setTestOnReturn(true);
            if(password==null || "".equals(password)){
                jedisPool = new JedisPool(jedisPoolConfig,host,port,timeout);
            }else{
                jedisPool = new JedisPool(jedisPoolConfig,host,port,timeout,password,1);
            }
        }
        return jedisPool;
    }

    private static void returnResource(Jedis jedis){
        if(jedis!=null){
            getJedisPool().returnResourceObject(jedis);
        }
    }

    public static void set(byte[] key ,byte[] value){
        Jedis jedis = getJedisPool().getResource();
        jedis.set(key, value);
        returnResource(jedis);

    }

    public static void set(String key ,String value){
        Jedis jedis = getJedisPool().getResource();
        jedis.set(key, value);
        returnResource(jedis);

    }

    public static byte[] getByte(byte[] key){
        Jedis jedis = getJedisPool().getResource();
        byte[] result = jedis.get(key);
        returnResource(jedis);
        return result;
    }

    public static void set(byte[] key ,byte[] value,int exp){
        Jedis jedis = getJedisPool().getResource();
        jedis.set(key, value);
        jedis.expire(key, exp);//缓存用户信息30天
        returnResource(jedis);

    }

    public static void set(String key ,String value,int exp){
        Jedis jedis = getJedisPool().getResource();
        jedis.set(key, value);
        jedis.expire(key, exp);//缓存用户信息30天
        returnResource(jedis);

    }

    public static void del(String key ){
        Jedis jedis = getJedisPool().getResource();
        jedis.del(key);
        returnResource(jedis);

    }

    public static void set(byte[] key ,int exp){
        Jedis jedis = getJedisPool().getResource();
        jedis.expire(key, exp);//缓存用户信息30天
        returnResource(jedis);
    }


    public static String get(String key){
        Jedis jedis = getJedisPool().getResource();
        String result = jedis.get(key);//缓存用户信息30天
        returnResource(jedis);
        return result;
    }
}
