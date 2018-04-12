 package com.zx.share.platform.console.api.controller;

import com.zx.share.platform.common.bean.UserCache;
import com.zx.share.platform.common.service.SercurityService;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 /**
  * Created by fenggang on 18/2/1.
  *
  * @author fenggang
  * @date 18/2/1
  */
 @Controller
 @Api(value = "login",description = "登录接口")
 @RequestMapping("/")
 public class LoginController {

     @Autowired
     private SercurityService sercurityService;

     @RequestMapping(value = "login", method = RequestMethod.GET)
     @ApiOperation(value = "login", notes = "login")
     @ResponseBody
     public DefaultResopnseBean<Object> login(HttpServletRequest request, HttpServletResponse response){


         sercurityService.saveSession(request,response,new UserCache());
         return null;
     }

     @RequestMapping(value = "logout", method = RequestMethod.GET)
     @ApiOperation(value = "logout", notes = "logout")
     @ResponseBody
     public DefaultResopnseBean<PageResponseBean<Object>> logout(){
         return null;
     }

 }
