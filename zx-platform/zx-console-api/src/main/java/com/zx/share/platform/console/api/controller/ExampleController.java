package com.zx.share.platform.console.api.controller;

import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by fenggang on 18/2/1.
 *
 * @author fenggang
 * @date 18/2/1
 */
@Controller
@Api(value = "example",description = "测试接口")
@RequestMapping("/example")
public class ExampleController {

    @RequestMapping(value = "example", method = RequestMethod.GET)
    @ApiOperation(value = "example", notes = "普通对象返回")
    @ResponseBody
    public DefaultResopnseBean<Object> example(){
        return null;
    }

    @RequestMapping(value = "page", method = RequestMethod.GET)
    @ApiOperation(value = "page", notes = "涉及到分页对象返回")
    @ResponseBody
    public DefaultResopnseBean<PageResponseBean<Object>> page(){
        return null;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ApiOperation(value = "list", notes = "list集合数据返回")
    @ResponseBody
    public DefaultResopnseBean<List<Object>> list(){
        return null;
    }
}
