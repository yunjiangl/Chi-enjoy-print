package com.zx.share.platform.wechat.api.controller.zx;

import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;
import com.zx.share.platform.vo.wechat.response.PrinterResultBean;
import com.zx.share.platform.wechat.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by fenggang on 18/3/9.
 *
 * @author fenggang
 * @date 18/3/9
 */
@Api(value = "/printer", produces = "application/json", description = "打印机接口")
@Controller
@RequestMapping("/printer")
public class PrinterController extends BaseController {

    @ApiOperation(value = "所有打印机接口", notes = "所有打印机接口")
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ResponseBody
    public DefaultResopnseBean<List<PrinterResultBean>> all(HttpServletRequest request){
        servletPath = request.getServletPath();
        DefaultResopnseBean<List<PrinterResultBean>> resopnseBean = new DefaultResopnseBean<>();
        return  resopnseBean;
    }

    @ApiOperation(value = "所有打印机分页接口", notes = "所有打印机分页接口")
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    public DefaultResopnseBean<PageResponseBean<PrinterResultBean>> page(@ApiParam("第几页") @RequestParam("page") Integer page,
                                                                         @ApiParam("每页多少条") @RequestParam("pageSize") Integer pageSize,
                                                                         HttpServletRequest request){
        servletPath = request.getServletPath();
        DefaultResopnseBean<PageResponseBean<PrinterResultBean>> resopnseBean = new DefaultResopnseBean<>();
        return  resopnseBean;
    }

    @ApiOperation(value = "附近打印机接口", notes = "附近打印机接口")
    @RequestMapping(value = "/nearby",method = RequestMethod.GET)
    @ResponseBody
    public DefaultResopnseBean<List<PrinterResultBean>> nearby(@ApiParam("经度") @RequestParam("longitude") Double longitude,
                                                               @ApiParam("纬度") @RequestParam("latitude") Double latitude,
                                                               HttpServletRequest request){
        servletPath = request.getServletPath();
        DefaultResopnseBean<List<PrinterResultBean>> resopnseBean = new DefaultResopnseBean<>();
        return  resopnseBean;
    }

    @ApiOperation(value = "打印机查询接口", notes = "打印机查询接口")
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    @ResponseBody
    public DefaultResopnseBean<PageResponseBean<PrinterResultBean>> query(@ApiParam("第几页") @RequestParam("page") Integer page,
                                                                          @ApiParam("每页多少条") @RequestParam("pageSize") Integer pageSize,
                                                                          HttpServletRequest request){
        servletPath = request.getServletPath();
        DefaultResopnseBean<PageResponseBean<PrinterResultBean>> resopnseBean = new DefaultResopnseBean<>();
        return  resopnseBean;
    }

    @ApiOperation(value = "我的打印机接口", notes = "我的打印机接口")
    @RequestMapping(value = "/my",method = RequestMethod.GET)
    @ResponseBody
    public DefaultResopnseBean<PageResponseBean<PrinterResultBean>> my(@ApiParam("第几页") @RequestParam("page") Integer page,
                                                                       @ApiParam("每页多少条") @RequestParam("pageSize") Integer pageSize,
                                                                       HttpServletRequest request){
        servletPath = request.getServletPath();
        DefaultResopnseBean<PageResponseBean<PrinterResultBean>> resopnseBean = new DefaultResopnseBean<>();
        return  resopnseBean;
    }
}
