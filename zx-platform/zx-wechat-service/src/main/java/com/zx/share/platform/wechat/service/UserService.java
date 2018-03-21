package com.zx.share.platform.wechat.service;

import com.zx.share.platform.vo.user.UserRequestBean;
import com.zx.share.platform.vo.user.UserResultBean;

/**
 * Created by fenggang on 18/3/5.
 *
 * @author fenggang
 * @date 18/3/5
 */
public interface UserService {

    UserResultBean findByOpenId(String unionId);

    Integer save(UserRequestBean bean);

    Integer update(UserRequestBean bean);

    String registerCode(String mobile);
    String forgetpasswordCode(String mobile);
}
