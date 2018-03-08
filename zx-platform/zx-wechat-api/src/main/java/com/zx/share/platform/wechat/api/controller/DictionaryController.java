package com.zx.share.platform.wechat.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.util.calendar.BaseCalendar;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fenggang on 18/3/5.
 *
 * @author fenggang
 * @date 18/3/5
 */
@Api(value = "/dictionary", produces = "application/json", description = "基础信息接口(包含文件类型)")
@Controller
@RequestMapping("/dictionary")
public class DictionaryController extends BaseController {

    @ApiOperation(value = "根据typeCode获取字典list接口", notes = "根据typeCode获取字典list接口")
    @RequestMapping(value = "/list/{typeCode}",method = RequestMethod.GET)
    public void list(@PathVariable String typeCode, HttpServletRequest request){
        servletPath = request.getServletPath();

    }
    @ApiOperation(value = "根据code获取单个字典信息接口", notes = "根据code获取单个字典信息接口")
    @RequestMapping(value = "/get/{code}",method = RequestMethod.GET)
    public void get(@PathVariable String code,HttpServletRequest request){
        servletPath = request.getServletPath();

    }
}
