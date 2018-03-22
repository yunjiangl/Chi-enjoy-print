package com.zx.share.platform.wechat.api.controller;

import com.zx.share.platform.constants.DictionaryKeys;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.vo.wechat.response.DictionaryResultBean;
import com.zx.share.platform.wechat.mapper.DictionaryMapper;
import com.zx.share.platform.wechat.service.DictionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.util.calendar.BaseCalendar;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @Autowired
    private DictionaryService dictionaryService;

    @ApiOperation(value = "获取文件类型接口", notes = "获取文件类型接口")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public DefaultResopnseBean<List<DictionaryResultBean>> list(@RequestParam("pId") Long pId, HttpServletRequest request){
        servletPath = request.getServletPath();
        List<DictionaryResultBean> list = dictionaryService.findType(DictionaryKeys.ZX_FILE_TYPES,pId);
        DefaultResopnseBean<List<DictionaryResultBean>> resopnseBean = new DefaultResopnseBean<>();
        resopnseBean.setData(list);
        return resopnseBean;
    }

    @ApiOperation(value = "根据code获取单个字典信息接口", notes = "根据code获取单个字典信息接口")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public void get(@RequestParam("code") String code,HttpServletRequest request){
        servletPath = request.getServletPath();

    }

    @ApiOperation(value = "获取A文件类型接口", notes = "获取A文件类型接口")
    @RequestMapping(value = "/a/list",method = RequestMethod.GET)
    @ResponseBody
    public DefaultResopnseBean<List<DictionaryResultBean>> lista(HttpServletRequest request){
        servletPath = request.getServletPath();
        List<DictionaryResultBean> list = dictionaryService.lista();
        DefaultResopnseBean<List<DictionaryResultBean>> resopnseBean = new DefaultResopnseBean<>();
        resopnseBean.setData(list);
        return resopnseBean;
    }

    @ApiOperation(value = "获取B文件类型接口", notes = "获取B文件类型接口")
    @RequestMapping(value = "/b/list",method = RequestMethod.GET)
    @ResponseBody
    public DefaultResopnseBean<List<DictionaryResultBean>> listb(HttpServletRequest request){
        servletPath = request.getServletPath();
        List<DictionaryResultBean> list = dictionaryService.listb();
        DefaultResopnseBean<List<DictionaryResultBean>> resopnseBean = new DefaultResopnseBean<>();
        resopnseBean.setData(list);
        return resopnseBean;
    }

    @ApiOperation(value = "获取律师领域接口", notes = "获取律师领域接口")
    @RequestMapping(value = "/domain/list",method = RequestMethod.GET)
    @ResponseBody
    public DefaultResopnseBean<List<DictionaryResultBean>> domain(HttpServletRequest request){
        servletPath = request.getServletPath();
        List<DictionaryResultBean> list = dictionaryService.domain();
        DefaultResopnseBean<List<DictionaryResultBean>> resopnseBean = new DefaultResopnseBean<>();
        resopnseBean.setData(list);
        return resopnseBean;
    }
}
