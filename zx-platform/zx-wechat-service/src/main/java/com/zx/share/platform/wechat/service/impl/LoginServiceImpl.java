package com.zx.share.platform.wechat.service.impl;

import com.zx.share.platform.util.StringUtil;
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
        if(bean==null || StringUtil.isBlank(pwd) ){
            return null;
        }
        WxLoginResponseVo loginResultBean = new WxLoginResponseVo();
        loginResultBean.setAccessToken(bean.getAccessToken());
        loginResultBean.setMobile(bean.getMobile());
        loginResultBean.setNickName(bean.getNickName());
        loginResultBean.setUserCode(bean.getUserCode());
        loginResultBean.setHeadImageUrl(bean.getPortrait());
        loginResultBean.setUserType(bean.getUserType());
        loginResultBean.setUserStatus(bean.getUserStatus());
        loginResultBean.setOpenId(bean.getOpenId());
        loginResultBean.setNickName(bean.getNickName());
        if(StringUtil.isNotBlank(bean.getIsLock()) && StringUtil.isNotBlank(bean.getUserType()) && bean.getUserType()==2 && bean.getIsLock()!=1){
            loginResultBean.setUserType(1);
        }

        if(StringUtil.isNotBlank(bean.getIsLock())  && bean.getIsLock()!=1){
            loginResultBean.setIsLock(3);
        }else{
            loginResultBean.setIsLock(1);
        }
        return loginResultBean;
    }

    @Override
    public WxLoginResponseVo login(String mobile, String pwd, String ip) {
        UserDetailsBean bean = userService.findByMobile(mobile);
        if(bean==null || StringUtil.isBlank(pwd) ){
            return null;
        }
        WxLoginResponseVo loginResultBean = new WxLoginResponseVo();
        loginResultBean.setAccessToken(bean.getAccessToken());
        loginResultBean.setMobile(bean.getMobile());
        loginResultBean.setNickName(bean.getNickName());
        loginResultBean.setUserCode(bean.getUserCode());
        loginResultBean.setHeadImageUrl(bean.getPortrait());
        loginResultBean.setUserType(bean.getUserType());
        loginResultBean.setUserStatus(bean.getUserStatus());
        loginResultBean.setOpenId(bean.getOpenId());
        loginResultBean.setNickName(bean.getNickName());
        if(StringUtil.isNotBlank(bean.getIsLock()) && StringUtil.isNotBlank(bean.getUserType()) && bean.getUserType()==2 && bean.getIsLock()!=1){
            loginResultBean.setUserType(1);
        }

        if(StringUtil.isNotBlank(bean.getIsLock())  && bean.getIsLock()!=1){
            loginResultBean.setIsLock(3);
        }else{
            loginResultBean.setIsLock(1);
        }

        //修改时间ip
        userService.updateIpLoginTime(bean.getId(),ip);
        return loginResultBean;
    }
}
