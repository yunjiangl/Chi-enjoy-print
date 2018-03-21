package com.zx.share.platform.wechat.api.controller;

import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.common.bean.UserCache;
import com.zx.share.platform.common.service.TokenCacheService;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.vo.wechat.response.UserDetailsBean;
import com.zx.share.platform.wechat.service.UserService;

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

/**
 * Created by fenggang on 18/3/20.
 *
 * @author fenggang
 * @date 18/3/20
 */
@Api(value = "/forgetpassword", produces = "application/json", description = "找回密码接口")
@Controller
@RequestMapping("/forgetpassword")
public class ForgetPasswordController extends BaseController {

	@Autowired
	private UserService userService;

	@Autowired
	private TokenCacheService tokenCacheService;

	/**
	 * 
	 * @throws Exception
	 * @Title: forgetpassword
	 * @Description: 向用户绑定手机发送验证码
	 */
	@ApiOperation(value = "找回密码-验证码发送", notes = "向用户绑定手机发送验证码")
	@RequestMapping(value = "/code", method = RequestMethod.POST)
	@ResponseBody
	public DefaultResopnseBean<Object> forgetpassword(HttpServletRequest request) throws Exception {
		servletPath = request.getServletPath();

		UserCache userCache = tokenCacheService.getCacheUser(request); // 得到当前登录用户

		userService.forgetpasswordCode(userCache.getId());

		DefaultResopnseBean<Object> resopnseBean = new DefaultResopnseBean<>();
		resopnseBean.setCode(ErrorsEnum.SUCCESS.code);
		resopnseBean.setMessage(ErrorsEnum.SUCCESS.label);
		return resopnseBean;
	}

	@ApiOperation(value = "找回密码-验证", notes = "")
	@RequestMapping(value = "/verification", method = RequestMethod.POST)
	@ResponseBody
	public DefaultResopnseBean<Object> verification(@ApiParam("验证码") @RequestParam("code") String code,
			HttpServletRequest request) throws Exception {
		servletPath = request.getServletPath();
		UserCache userCache = tokenCacheService.getCacheUser(request); // 得到当前登录用户

		return userService.verification(userCache.getId(), code);
	}

	@ApiOperation(value = "找回密码-保存", notes = "")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public DefaultResopnseBean<Object> updatePwd(@ApiParam("密码") @RequestParam("pwd") String pwd,
			HttpServletRequest request) throws Exception {
		servletPath = request.getServletPath();

		UserCache userCache = tokenCacheService.getCacheUser(request); // 得到当前登录用户

		ZxUser user = new ZxUser();
		user.setId(userCache.getId());
		user.setPassword(pwd);
		
		userService.update(user);

		DefaultResopnseBean<Object> resopnseBean = new DefaultResopnseBean<>();
		return resopnseBean;
	}
}
