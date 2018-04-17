package com.zx.share.platform.console.api.modules.sys.service;

import com.zx.share.platform.console.api.modules.sys.entity.SysUserEntity;
import com.zx.share.platform.console.api.modules.sys.entity.SysUserTokenEntity;

import java.util.Set;

/**
 * shiro相关接口
 * @author czx
 * @email object_czx@163.com
 * @date 2017-06-06 8:49
 */
public interface ShiroService {
    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(long userId);

    SysUserTokenEntity queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     * @param userId
     */
    SysUserEntity queryUser(Long userId);
}
