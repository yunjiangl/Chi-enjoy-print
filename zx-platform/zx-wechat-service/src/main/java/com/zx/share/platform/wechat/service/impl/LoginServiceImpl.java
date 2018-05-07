package com.zx.share.platform.wechat.service.impl;

import com.zx.share.platform.vo.WxLoginResponseVo;
import com.zx.share.platform.vo.wechat.response.UserDetailsBean;
import com.zx.share.platform.wechat.service.LoginService;
import com.zx.share.platform.wechat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fenggang on 18/4/20.
 *
 * @author fenggang
 * @date 18/4/20
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;

    @Override
    public WxLoginResponseVo login(String mobile, String pwd) {

        UserDetailsBean bean = userService.findByMobile(mobile);
        WxLoginResponseVo loginResultBean = new WxLoginResponseVo();
        loginResultBean.setAccessToken(bean.getAccessToken());
        loginResultBean.setMobile(bean.getMobile());
        loginResultBean.setNickName(bean.getNickName());
        loginResultBean.setUserCode(bean.getUserCode());
        loginResultBean.setHeadImageUrl(bean.getPortrait());
        loginResultBean.setUserType(bean.getUserType());
        loginResultBean.setUserStatus(bean.getUserStatus());
        loginResultBean.setNickName(bean.getNickName());
        return loginResultBean;
    }
}
