package com.zx.share.platform.wechat.api.controller;

import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.GrantType;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.vo.WeChatUserInfoVo;
import com.zx.share.platform.vo.WxAppletAuthVo;
import com.zx.share.platform.vo.WxLoginResponseVo;
import com.zx.share.platform.wechat.service.WeChatLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by fenggang on 18/3/2.
 *
 * @author fenggang
 * @date 18/3/2
 */
@Api(value = "/user", produces = "application/json", description = "微信登录接口")
@Controller
@RequestMapping("/wechat")
public class WechatLongController {

    @Autowired
    private WeChatLoginService weChatLoginService;


    private static final String MOBILE_APP_ID = "";
    private static final String MOBILE_SECRET = "";

    //小程序
    private static final String APPLET_APP_ID = "";
    private static final String APPLET_SECRET = "";

    @ApiOperation(value = "微信小程序微信登录接口", notes = "微信小程序微信登录接口")
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public DefaultResopnseBean<WxLoginResponseVo> wxAppletLoginByWeChat(@ApiParam("appId") @RequestParam("appId") String appId,
                                                                        @ApiParam("code 授权码") @RequestParam("code") String code,
                                                                        @ApiParam("encryptedData用户信息（明文,加密数据") @RequestParam("encryptedData") String encryptedData,
                                                                        @ApiParam("iv 加密算法的初始向量") @RequestParam("iv") String iv,
                                                                        HttpServletRequest request, HttpServletResponse response) throws IOException {
        DefaultResopnseBean<WxLoginResponseVo> responseData = new DefaultResopnseBean<>();
        //获取sessionKey
        WxAppletAuthVo wxAppletAuthVo = weChatLoginService.getAppletSessionKey(APPLET_APP_ID, APPLET_SECRET, code, GrantType.AUTHORIZATION_CODE);
        if (wxAppletAuthVo == null) {
            responseData.jsonFill(ErrorsEnum.SYSTEM_CUSTOM_ERROR.code, "授权码无效/访问微信验证服务器失败");
            return responseData;
        }
        //获取用户信息
        WeChatUserInfoVo appletUserInfo = weChatLoginService.getAppletUserInfo(encryptedData, iv, wxAppletAuthVo.getSessionKey());
        if (appletUserInfo == null) {
            responseData.jsonFill(ErrorsEnum.SYSTEM_CUSTOM_ERROR.code, "获取微信用户信息失败");
            return responseData;
        }

        //如果没有openID，unionId，重新获取一下


        //如果用户创建失败


        //获取到用户信息
        WxLoginResponseVo wxLoginResponseVo = new WxLoginResponseVo();

        //登录信息写入缓存

        return responseData;
    }
}
