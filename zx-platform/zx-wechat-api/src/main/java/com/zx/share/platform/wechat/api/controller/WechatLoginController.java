package com.zx.share.platform.wechat.api.controller;

import com.zx.share.platform.common.service.SercurityService;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.constants.UserSourceEnum;
import com.zx.share.platform.util.CodeBuilderUtil;
import com.zx.share.platform.util.GrantType;
import com.zx.share.platform.util.StringUtil;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.vo.WeChatOAuthVo;
import com.zx.share.platform.vo.WeChatUserInfoVo;
import com.zx.share.platform.vo.WxAppletAuthVo;
import com.zx.share.platform.vo.WxLoginResponseVo;
import com.zx.share.platform.vo.user.UserRequestBean;
import com.zx.share.platform.vo.user.UserResultBean;
import com.zx.share.platform.wechat.api.config.WeChatConfig;
import com.zx.share.platform.wechat.service.UserService;
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

/**
 * Created by fenggang on 18/3/2.
 *
 * @author fenggang
 * @date 18/3/2
 */
@Api(value = "/wechat", produces = "application/json", description = "微信登录接口")
@Controller
@RequestMapping("/wechat")
public class WechatLoginController extends BaseController{

    @Autowired
    private WeChatLoginService weChatLoginService;
    @Autowired
    private UserService userService;
    @Autowired
    private WeChatConfig weChatConfig;
    @Autowired
    private SercurityService sercurityService;

    @ApiOperation(value = "微信小程序微信登录接口", notes = "微信小程序微信登录接口")
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public DefaultResopnseBean<WxLoginResponseVo> wxAppletLoginByWeChat(@ApiParam("appId") @RequestParam("appId") String appId,
                                                                        @ApiParam("code 授权码") @RequestParam("code") String code,
                                                                        @ApiParam("encryptedData用户信息（明文,加密数据") @RequestParam("encryptedData") String encryptedData,
                                                                        @ApiParam("iv 加密算法的初始向量") @RequestParam("iv") String iv,
                                                                        HttpServletRequest request, HttpServletResponse response) throws IOException {
        servletPath = request.getServletPath();
        String sessionToken = request.getSession().getId();
        DefaultResopnseBean<WxLoginResponseVo> responseData = new DefaultResopnseBean<>();
        //获取sessionKey
        WxAppletAuthVo wxAppletAuthVo = weChatLoginService.getAppletSessionKey(weChatConfig.getLoginAppId(), weChatConfig.getLoginAppSecret(), code, GrantType.AUTHORIZATION_CODE);
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

        UserResultBean userResultBean = userService.findByOpenId(appletUserInfo.getOpenId());

        if (userResultBean == null) {
            UserRequestBean userSaveBean = new UserRequestBean();
            String userCode = UserSourceEnum.ZX_USER_SOURCE_WECHAT.label+"0000";
            String id = userService.findMaxId(userCode);
            userSaveBean.setCity(appletUserInfo.getCity());
            userSaveBean.setUserCode(CodeBuilderUtil.userCode(UserSourceEnum.ZX_USER_SOURCE_WECHAT.label,"0000",id));
            userSaveBean.setProvince(appletUserInfo.getProvince());
            userSaveBean.setOpenId(appletUserInfo.getOpenId());
            userSaveBean.setCountry(appletUserInfo.getCountry());
            userSaveBean.setUnionId(appletUserInfo.getUnionId());
            userSaveBean.setHeadImgUrl(appletUserInfo.getHeadImgUrl());
            userSaveBean.setNickName(appletUserInfo.getNickName());
            userSaveBean.setSex(appletUserInfo.getSex());
            userSaveBean.setAccessToken(sessionToken);
            userSaveBean.setUserStatus(1);
            userSaveBean.setUserType(1);
            userService.save(userSaveBean);

            userResultBean = new UserResultBean();

        }else {
            //每次登录都更新sessionKey，头像和用户名
            UserRequestBean userSaveBean = new UserRequestBean();
            userSaveBean.setUserCode(userResultBean.getUserCode());
            userSaveBean.setHeadImgUrl(appletUserInfo.getHeadImgUrl());
            userSaveBean.setWxSessionKey(wxAppletAuthVo.getSessionKey());
            userSaveBean.setAccessToken(sessionToken);
            userResultBean.setPortrait(userSaveBean.getHeadImgUrl());
            userService.update(userSaveBean);
        }

        //如果没有openID，unionId，重新获取一下
        if(userResultBean!=null && StringUtil.isBlank(userResultBean.getOpenId())){
            UserRequestBean userSaveBean = new UserRequestBean();
            userSaveBean.setUserCode(userResultBean.getUserCode());
            userSaveBean.setUnionId(appletUserInfo.getUnionId());
            userSaveBean.setOpenId(userResultBean.getOpenId());
            userSaveBean.setAccessToken(sessionToken);
            userService.update(userSaveBean);
        }

        //如果用户创建失败
        if(userResultBean==null){
            responseData.jsonFill(ErrorsEnum.SYSTEM_BUSINESS_ERROR);
            return responseData;
        }

        //获取到用户信息
        WxLoginResponseVo loginResultBean = new WxLoginResponseVo();
        loginResultBean.setAccessToken(sessionToken);
        loginResultBean.setMobile(userResultBean.getMobile());
        loginResultBean.setNickName(userResultBean.getUnionId());
        loginResultBean.setUserCode(userResultBean.getUserCode());
        loginResultBean.setHeadImageUrl(userResultBean.getPortrait());
        loginResultBean.setUserType(userResultBean.getUserType());
        loginResultBean.setUserStatus(userResultBean.getUserStatus());
        loginResultBean.setOpenId(userResultBean.getOpenId());
        loginResultBean.setNickName(userResultBean.getUsername());
        //放入返回对象
        responseData.setData(loginResultBean);
        //登录信息写入缓存
        sercurityService.saveSession(request,null,loginResultBean);
        return responseData;
    }

    @ApiOperation(value = "微信用户登录", notes = "微信用户登录")
    @RequestMapping(value = "/loginByWeChat", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public DefaultResopnseBean<WxLoginResponseVo> loginByWeChat(@ApiParam("appId") @RequestParam("appId") String appId,
                                                         @ApiParam("code 授权码") @RequestParam("code") String code,
                                                         HttpServletRequest request, HttpServletResponse response) throws Exception {
        servletPath = request.getServletPath();
        String sessionToken = request.getSession().getId();
        DefaultResopnseBean<WxLoginResponseVo> responseData = new DefaultResopnseBean<>();
        WeChatOAuthVo weChatOAuthVo = weChatLoginService.getAccessToken(weChatConfig.getLoginAppId(), weChatConfig.getLoginAppSecret(), code, GrantType.AUTHORIZATION_CODE);
        if (null == weChatOAuthVo) {
            responseData.jsonFill(ErrorsEnum.SYSTEM_CUSTOM_ERROR.code, "微信OAuth失败");
            return responseData;
        }

        UserResultBean userResultBean = userService.findByOpenId(weChatOAuthVo.getOpenId());

        if (userResultBean == null) {
            //获取微信用户信息
            WeChatUserInfoVo appletUserInfo = weChatLoginService.getUserInfo(weChatOAuthVo.getAccessToken(), weChatOAuthVo.getOpenId());
            if (null == appletUserInfo) {
                responseData.jsonFill(ErrorsEnum.SYSTEM_CUSTOM_ERROR.code, "获取微信用户信息失败");
                return responseData;
            }
            UserRequestBean userSaveBean = new UserRequestBean();
            String userCode = UserSourceEnum.ZX_USER_SOURCE_WECHAT.label+"0000";
            String id = userService.findMaxId(userCode);
            userSaveBean.setCity(appletUserInfo.getCity());
            userSaveBean.setUserCode(CodeBuilderUtil.userCode(UserSourceEnum.ZX_USER_SOURCE_WECHAT.label,"0000",id));
            userSaveBean.setProvince(appletUserInfo.getProvince());
            userSaveBean.setOpenId(appletUserInfo.getOpenId());
            userSaveBean.setCountry(appletUserInfo.getCountry());
            userSaveBean.setUnionId(appletUserInfo.getUnionId());
            userSaveBean.setHeadImgUrl(appletUserInfo.getHeadImgUrl());
            userSaveBean.setNickName(appletUserInfo.getNickName());
            userSaveBean.setSex(appletUserInfo.getSex());
            userSaveBean.setAccessToken(sessionToken);
            userSaveBean.setUserStatus(1);
            userSaveBean.setUserType(1);
            userService.save(userSaveBean);

            userResultBean = new UserResultBean();

        }

        //如果用户创建失败
        if(userResultBean==null){
            responseData.jsonFill(ErrorsEnum.SYSTEM_BUSINESS_ERROR);
            return responseData;
        }

        //获取到用户信息
        WxLoginResponseVo loginResultBean = new WxLoginResponseVo();
        loginResultBean.setAccessToken(sessionToken);
        loginResultBean.setMobile(userResultBean.getMobile());
        loginResultBean.setNickName(userResultBean.getUnionId());
        loginResultBean.setUserCode(userResultBean.getUserCode());
        loginResultBean.setHeadImageUrl(userResultBean.getPortrait());
        loginResultBean.setUserType(userResultBean.getUserType());
        loginResultBean.setUserStatus(userResultBean.getUserStatus());
        loginResultBean.setOpenId(userResultBean.getOpenId());
        //放入返回对象
        responseData.setData(loginResultBean);

        //登录信息写入缓存
        sercurityService.saveSession(request,null,loginResultBean);

        return responseData;
    }
}
