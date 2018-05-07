package com.zx.share.platform.wechat.api.controller.zx;

import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;
import com.zx.share.platform.vo.user.ImResponseBean;
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

/**
 * Created by fenggang on 18/5/7.
 *
 * @author fenggang
 * @date 18/5/7
 */
@Api(value = "/im", produces = "application/json", description = "对话列表接口")
@Controller
@RequestMapping("/im")
public class ImController extends BaseController {

    @ApiOperation(value = "对话列表", notes = "对话列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public DefaultResopnseBean<PageResponseBean<ImResponseBean>> attorney(
            @ApiParam(value = "page") @RequestParam(name = "page", required = false) Integer page,
            @ApiParam(value = "pageSize") @RequestParam(name = "pageSize", required = false) Integer pageSize,
            HttpServletRequest request) throws Exception {
        servletPath = request.getServletPath();
        DefaultResopnseBean<PageResponseBean<ImResponseBean>> resopnseBean = new DefaultResopnseBean<>();
        return resopnseBean;
    }

}
