package com.zx.share.platform.console.api.modules.sys.redis;

import com.zx.share.platform.bean.sys.SysDictionary;
import com.zx.share.platform.console.api.common.utils.RedisKeys;
import com.zx.share.platform.console.api.common.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 系统配置Redis
 *
 * @author czx
 * @email object_czx@163.com
 * @date 2017/7/18 21:08
 */
@Component
public class SysConfigRedis {
    @Autowired
    private RedisUtils redisUtils;

    public void saveOrUpdate(SysDictionary config) {
        if(config == null){
            return ;
        }
        String key = RedisKeys.getSysConfigKey(config.getId().toString());
        redisUtils.set(key, config);
    }

    public void delete(String configKey) {
        String key = RedisKeys.getSysConfigKey(configKey);
        redisUtils.delete(key);
    }

    public SysDictionary get(String configKey){
        String key = RedisKeys.getSysConfigKey(configKey);
        return redisUtils.get(key, SysDictionary.class);
    }
}
