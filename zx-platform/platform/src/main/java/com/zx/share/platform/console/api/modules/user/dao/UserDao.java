package com.zx.share.platform.console.api.modules.user.dao;

import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.console.api.modules.user.entity.UserEntity;
import com.zx.share.platform.console.api.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2017-10-23 21:23:54
 */
@Mapper
public interface UserDao extends BaseDao<ZxUser> {
    ZxUser queryByMobile(String mobile);
}
