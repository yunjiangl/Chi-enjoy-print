package com.zx.share.platform.console.api.datasources;

import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.console.api.datasources.annotation.DataSource;
import com.zx.share.platform.console.api.modules.user.entity.UserEntity;
import com.zx.share.platform.console.api.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 测试
 * @author czx
 * @email object_czx@163.com
 * @date 2017/9/16 23:10
 */
@Service
public class DataSourceTestService {
    @Autowired
    private UserService userService;

    public ZxUser queryObject(Long userId){
        return userService.queryObject(userId);
    }

    @DataSource(name = DataSourceNames.SECOND)
    public ZxUser queryObject2(Long userId){
        return userService.queryObject(userId);
    }
}
