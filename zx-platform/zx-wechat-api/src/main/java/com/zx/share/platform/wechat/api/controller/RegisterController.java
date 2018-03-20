package com.zx.share.platform.wechat.api.controller;

import com.zx.share.platform.constants.DictionaryKeys;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.vo.wechat.response.DictionaryResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by fenggang on 18/3/20.
 *
 * @author fenggang
 * @date 18/3/20
 */
@Api(value = "/register", produces = "application/json", description = "用户接口")
@Controller
@RequestMapping("/register")
public class RegisterController extends BaseController {

    @ApiOperation(value = "发送注册验证码", notes = "发送注册验证码")
    @RequestMapping(value = "/code", method = RequestMethod.POST)
    @ResponseBody
    public DefaultResopnseBean<Object> list(@ApiParam("手机号") @RequestParam("mobile") String mobile, HttpServletRequest request) {
        servletPath = request.getServletPath();
        DefaultResopnseBean<Object> resopnseBean = new DefaultResopnseBean<>();
        return resopnseBean;
    }

    @ApiOperation(value = "验证注册验证码", notes = "验证注册验证码")
    @RequestMapping(value = "/verification", method = RequestMethod.POST)
    @ResponseBody
    public DefaultResopnseBean<Object> verification(@ApiParam("手机号") @RequestParam("mobile") String mobile,
                                                    @ApiParam("验证码") @RequestParam("code") String code,
                                                    @ApiParam("类型") @RequestParam("type") Integer type, HttpServletRequest request) {
        servletPath = request.getServletPath();
        DefaultResopnseBean<Object> resopnseBean = new DefaultResopnseBean<>();
        return resopnseBean;
    }

    @ApiOperation(value = "注册信息保存", notes = "注册信息保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public DefaultResopnseBean<Object> save(@ApiParam("手机号") @RequestParam("mobile") String mobile,
                                            @ApiParam("验证码") @RequestParam("code") String code,
                                            @ApiParam("类型") @RequestParam("type") Integer type,
                                            @ApiParam("省") @RequestParam("province") String province,
                                            @ApiParam("市") @RequestParam("city") String city,
                                            @ApiParam("区") @RequestParam("area") String area,
                                            @ApiParam("名称") @RequestParam("name") String name,
                                            @ApiParam("微信号") @RequestParam("wechatId") String wechatId,
                                            @ApiParam("年龄") @RequestParam("age") Integer age,
                                            @ApiParam("性别") @RequestParam("grad") Integer grad, HttpServletRequest request) {
        servletPath = request.getServletPath();
        DefaultResopnseBean<Object> resopnseBean = new DefaultResopnseBean<>();
        return resopnseBean;
    }
}
