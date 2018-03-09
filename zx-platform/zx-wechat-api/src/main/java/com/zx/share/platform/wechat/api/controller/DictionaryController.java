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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @RequestMapping(value = "/list/{pId}",method = RequestMethod.GET)
    @ResponseBody
    public DefaultResopnseBean<List<DictionaryResultBean>> list(@PathVariable Long pId, HttpServletRequest request){
        servletPath = request.getServletPath();
        List<DictionaryResultBean> list = dictionaryService.findType(DictionaryKeys.ZX_FILE_TYPES,pId);
        DefaultResopnseBean<List<DictionaryResultBean>> resopnseBean = new DefaultResopnseBean<>();
        resopnseBean.setData(list);
        return resopnseBean;
    }
    @ApiOperation(value = "根据code获取单个字典信息接口", notes = "根据code获取单个字典信息接口")
    @RequestMapping(value = "/get/{code}",method = RequestMethod.GET)
    public void get(@PathVariable String code,HttpServletRequest request){
        servletPath = request.getServletPath();

    }
}
