package com.zx.share.platform.wechat.service;

import com.zx.share.platform.vo.WeChatOAuthVo;
import com.zx.share.platform.vo.WeChatUserInfoVo;
import com.zx.share.platform.vo.WxAppletAuthVo;

/**
 * Created by xmc1993 on 17/3/23.
 */
public interface WeChatLoginService {

    /**
     * 使用授权码从OAuth服务器获得accessToken
     * @param code
     * @return
     */
    WeChatOAuthVo getAccessToken(String appId, String secret, String grantType, String code);

    /**
     *
     * @param accessToken
     * @param openId
     */
    WeChatUserInfoVo getUserInfo(String accessToken, String openId);

    /**
     * 微信小程序使用js_code从服务器获取session_key
     * @param appId
     * @param secret
     * @param jsCode
     * @param grantType
     * @return
     */
    WxAppletAuthVo getAppletSessionKey(String appId, String secret, String jsCode, String grantType);

    WeChatUserInfoVo getAppletUserInfo(String encryptedData, String iv, String sessionKey);
    String getGroupId(String encryptedData, String iv, String sessionKey);
}
