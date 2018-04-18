package com.zx.share.platform.console.api.modules.user.dao;

import com.zx.share.platform.bean.sys.SysUserLogin;
import com.zx.share.platform.console.api.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by fenggang on 18/4/18.
 *
 * @author fenggang
 * @date 18/4/18
 */
@Mapper
public interface SysUserLoginDao extends BaseDao<SysUserLogin> {

    SysUserLogin queryUserType(@Param("userId") Long userId, @Param("type") Integer type);
}
