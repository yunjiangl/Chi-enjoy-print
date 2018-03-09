package com.zx.share.platform.wechat.api.controller.zx;

import com.zx.share.platform.constants.FileQuerySuffixEnum;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;
import com.zx.share.platform.vo.wechat.response.FileResultBean;
import com.zx.share.platform.wechat.api.controller.BaseController;
import com.zx.share.platform.wechat.service.FileManagerService;
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
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fenggang on 18/3/9.
 *
 * @author fenggang
 * @date 18/3/9
 */
@Api(value = "/file/m", produces = "application/json", description = "abcde类文件接口")
@Controller
@RequestMapping("/file/m")
public class FileManagerController extends BaseController {

    @Autowired
    private FileManagerService fileManagerService;

    @ApiOperation(value = "A类文件接口", notes = "A类文件接口")
    @RequestMapping(value = "/a/page", method = {RequestMethod.GET})
    @ResponseBody
    public DefaultResopnseBean<PageResponseBean<FileResultBean>> pageListA(@ApiParam("文件分类code") @RequestParam("categoryCode") String categoryCode,
                                                                           @ApiParam("第几页") @RequestParam("page") Integer page,
                                                                           @ApiParam("每页多少条") @RequestParam("pageSize") Integer pageSize,
                                                                           HttpServletRequest request, HttpServletResponse response) {
        servletPath = request.getServletPath();
        PageResponseBean<FileResultBean> pageResponseBean = fileManagerService.pageList(FileQuerySuffixEnum.ZX_FILE_QUERY_SUFFIX_AB.label, categoryCode, page, pageSize);
        DefaultResopnseBean<PageResponseBean<FileResultBean>> resopnseBean = new DefaultResopnseBean<>();
        resopnseBean.setData(pageResponseBean);
        return resopnseBean;
    }

    @ApiOperation(value = "B类文件接口", notes = "B类文件接口")
    @RequestMapping(value = "/b/page", method = {RequestMethod.GET})
    @ResponseBody
    public DefaultResopnseBean<PageResponseBean<FileResultBean>> pageListB(@ApiParam("文件分类code") @RequestParam("categoryCode") String categoryCode,
                                                                           @ApiParam("第几页") @RequestParam("page") Integer page,
                                                                           @ApiParam("每页多少条") @RequestParam("pageSize") Integer pageSize,
                                                                           HttpServletRequest request, HttpServletResponse response) {
        servletPath = request.getServletPath();
        PageResponseBean<FileResultBean> pageResponseBean = fileManagerService.pageList(FileQuerySuffixEnum.ZX_FILE_QUERY_SUFFIX_CDE.label, categoryCode, page, pageSize);
        DefaultResopnseBean<PageResponseBean<FileResultBean>> resopnseBean = new DefaultResopnseBean<>();
        resopnseBean.setData(pageResponseBean);
        return resopnseBean;
    }
}
