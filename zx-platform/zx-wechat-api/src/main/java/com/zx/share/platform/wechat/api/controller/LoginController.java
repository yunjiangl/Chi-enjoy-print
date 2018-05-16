package com.zx.share.platform.wechat.api.controller;

import com.zx.share.platform.common.service.SercurityService;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.exception.NeedLoginException;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.vo.WxLoginResponseVo;
import com.zx.share.platform.vo.user.LoginRequesVo;
import com.zx.share.platform.wechat.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fenggang on 18/3/20.
 *
 * @author fenggang
 * @date 18/3/20
 */
@Api(value = "/Login", produces = "application/json", description = "登录退出接口")
@Controller
@RequestMapping("")
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private SercurityService sercurityService;

    @ApiOperation(value = "logout", notes = "logout")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public DefaultResopnseBean<Object> logout(HttpServletRequest request) {
        servletPath = request.getServletPath();
        DefaultResopnseBean<Object> resopnseBean = new DefaultResopnseBean<>();
        try {
            sercurityService.cleanSession(request);
        } catch (NeedLoginException e) {
            resopnseBean.jsonFill(ErrorsEnum.SYSTEM_NOT_LOGIN);
        }
        return resopnseBean;
    }

    @ApiOperation(value = "login", notes = "login")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public DefaultResopnseBean<WxLoginResponseVo> login(@RequestBody LoginRequesVo bean, HttpServletRequest request) {
        servletPath = request.getServletPath();
        DefaultResopnseBean<WxLoginResponseVo> resopnseBean = new DefaultResopnseBean<>();
        WxLoginResponseVo loginResponseVo = loginService.login(bean.getMobile(),bean.getPwd(),getIpAdrress(request));
        if(loginResponseVo==null){
            resopnseBean.jsonFill(ErrorsEnum.SYSTEM_USER_ERROR_LONGIN);
        }else{
            resopnseBean.setData(loginResponseVo);
        }
        sercurityService.saveSession(request,null,loginResponseVo);
        return resopnseBean;
    }

    /**
     * 获取Ip地址
     * @param request
     * @return
     */
    private String getIpAdrress(HttpServletRequest request) {
        String Xip = request.getHeader("X-Real-IP");
        String XFor = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = XFor.indexOf(",");
            if(index != -1){
                return XFor.substring(0,index);
            }else{
                return XFor;
            }
        }
        XFor = Xip;
        if(StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
            return XFor;
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getRemoteAddr();
        }
        return XFor;
    }
}
