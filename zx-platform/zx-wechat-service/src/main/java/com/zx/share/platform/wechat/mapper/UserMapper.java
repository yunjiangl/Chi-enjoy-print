package com.zx.share.platform.wechat.mapper;

import org.springframework.stereotype.Repository;

import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.common.mapper.PlatFormMapper;
import com.zx.share.platform.vo.user.UserRequestBean;
import com.zx.share.platform.vo.user.UserResultBean;

/**
 * Created by fenggang on 18/3/5.
 *
 * @author fenggang
 * @date 18/3/5
 */
@Repository
public interface UserMapper extends PlatFormMapper<ZxUser> {

    UserResultBean findByUnionId(String unionId);

    UserResultBean findByOpenId(String openId);

    Integer save(UserRequestBean bean);

    Integer update(UserRequestBean bean);

}
