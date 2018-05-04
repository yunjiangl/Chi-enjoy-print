package com.zx.share.platform.wechat.api.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.zx.share.platform.constants.UserSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.common.bean.SessionConfig;
import com.zx.share.platform.common.bean.UserCache;
import com.zx.share.platform.common.service.TokenCacheService;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.wechat.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

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

	@Autowired
	private UserService userService;

	@Autowired
	private TokenCacheService tokenCacheService;

	@ApiOperation(value = "发送注册验证码", notes = "发送注册验证码")
	@RequestMapping(value = "/code", method = RequestMethod.GET)
	@ResponseBody
	public DefaultResopnseBean<Object> list(@ApiParam("手机号") @RequestParam("mobile") String mobile,
			HttpServletRequest request) {
		servletPath = request.getServletPath();
		userService.registerCode(mobile);
		DefaultResopnseBean<Object> resopnseBean = new DefaultResopnseBean<>();
		resopnseBean.setCode(ErrorsEnum.SUCCESS.code);
		resopnseBean.setMessage(ErrorsEnum.SUCCESS.label);
		return resopnseBean;
	}

	@ApiOperation(value = "验证注册验证码", notes = "验证注册验证码")
	@RequestMapping(value = "/verification", method = RequestMethod.GET)
	@ResponseBody
	public DefaultResopnseBean<Object> verification(@ApiParam("手机号") @RequestParam("mobile") String mobile,
			@ApiParam("验证码") @RequestParam("code") String code, @ApiParam("类型") @RequestParam("type") Integer type,
			HttpServletRequest request) {
		servletPath = request.getServletPath();

		DefaultResopnseBean<Object> resopnseBean = new DefaultResopnseBean<>();

		if (code.equals(tokenCacheService.getCacheRegisterCode(mobile))) {
			// 验证码正确
			resopnseBean.setCode(ErrorsEnum.SUCCESS.code);
			resopnseBean.setMessage(ErrorsEnum.SUCCESS.label);
		} else {
			// 验证码错误
			resopnseBean.setCode(ErrorsEnum.SYSTEM_CUSTOM_ERROR.code);
			resopnseBean.setMessage("验证码错误");
		}

		return resopnseBean;
	}

	@ApiOperation(value = "注册信息保存", notes = "注册信息保存")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public DefaultResopnseBean<Object> save(@ApiParam("手机号") @RequestParam("mobile") String mobile,
			@ApiParam("验证码") @RequestParam("code") String code, @ApiParam("用户类型") @RequestParam("type") Integer type,
			@ApiParam("密码") @RequestParam("password") String password,
			@ApiParam("省") @RequestParam("province") String province, @ApiParam("市") @RequestParam("city") String city,
			@ApiParam("区") @RequestParam("area") String area, @ApiParam("名称") @RequestParam("name") String name,
			@ApiParam("微信号") @RequestParam("wechatId") String wechatId,
			@ApiParam("年龄") @RequestParam("age") Integer age, @ApiParam("性别") @RequestParam("grad") Integer grad,
			HttpServletRequest request) throws Exception {
		servletPath = request.getServletPath();
		//UserCache userCache = (UserCache)request.getAttribute(SessionConfig.DEFAULT_REQUEST_DRUG_USER); // 得到当前登录用户

		ZxUser user = new ZxUser();
		String userCode = UserSourceEnum.ZX_USER_SOURCE_WECHAT.label+"0000";
		//user.setId(userCache.getId());
		user.setUserCode(userCode);
		user.setMobile(mobile);
		user.setNickname(name);
		user.setRegisterTime(new Date());
		user.setUserType(type);
		//user.setAge(age);
		//user.setWechatId(wechatId);
		//user.setProvince(province);
		//user.setCity(city);
		//user.setArea(area);
		user.setPassword(password);
		user.setUserStatus(2);

		userService.insert(user);

		DefaultResopnseBean<Object> resopnseBean = new DefaultResopnseBean<>();
		return resopnseBean;
	}
}
