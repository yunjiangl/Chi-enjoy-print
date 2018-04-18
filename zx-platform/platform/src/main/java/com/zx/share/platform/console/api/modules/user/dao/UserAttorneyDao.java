package com.zx.share.platform.console.api.modules.user.dao;

import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.bean.zx.ZxUserAttorney;
import com.zx.share.platform.console.api.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by fenggang on 18/4/18.
 *
 * @author fenggang
 * @date 18/4/18
 */
@Mapper
public interface UserAttorneyDao  extends BaseDao<ZxUserAttorney> {
}
