package com.zx.share.platform.wechat.service.impl;

import com.zx.share.platform.vo.user.UserRequestBean;
import com.zx.share.platform.vo.user.UserResultBean;
import com.zx.share.platform.wechat.mapper.UserMapper;
import com.zx.share.platform.wechat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public UserResultBean findByUnionId(String unionId) {
        return userMapper.findByUnionId(unionId);
    }

    @Override
    public Integer save(UserRequestBean bean) {
        return null;
    }

    @Override
    public Integer update(UserRequestBean bean) {
        return null;
    }
}
