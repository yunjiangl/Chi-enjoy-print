package com.zx.share.platform.wechat.service;

import com.zx.share.platform.vo.WxLoginResponseVo;

/**
 * Created by fenggang on 18/4/20.
 *
 * @author fenggang
 * @date 18/4/20
 */
public interface LoginService {

    WxLoginResponseVo login(String mobile,String pwd);
    WxLoginResponseVo login(String mobile,String pwd,String ip);
}
