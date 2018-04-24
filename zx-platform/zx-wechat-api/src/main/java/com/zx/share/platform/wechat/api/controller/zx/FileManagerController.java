package com.zx.share.platform.wechat.api.controller.zx;

import java.util.List;

import javax.management.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.StringUtil;
import com.zx.share.platform.vo.wechat.response.DictionaryResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zx.share.platform.bean.zx.ZxFileManagerCDE;
import com.zx.share.platform.constants.FileQuerySuffixEnum;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;
import com.zx.share.platform.vo.wechat.response.FileResultBean;
import com.zx.share.platform.wechat.api.controller.BaseController;
import com.zx.share.platform.wechat.service.CDEFileService;
import com.zx.share.platform.wechat.service.FileManagerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

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
    public DefaultResopnseBean<PageResponseBean<FileResultBean>> pageListA(@ApiParam("查询内容") @RequestParam(name = "query", required = false) String query,
																		   @ApiParam("文件分类code") @RequestParam(name ="categoryCode", required = false) String categoryCode,
																		   @ApiParam("第几页") @RequestParam("page") Integer page,
                                                                           @ApiParam("每页多少条") @RequestParam("pageSize") Integer pageSize,
                                                                           HttpServletRequest request, HttpServletResponse response) {
        servletPath = request.getServletPath();
        PageResponseBean<FileResultBean> pageResponseBean = fileManagerService.pageabList(FileQuerySuffixEnum.ZX_FILE_QUERY_SUFFIX_A.label, categoryCode, page, pageSize, query);
        DefaultResopnseBean<PageResponseBean<FileResultBean>> resopnseBean = new DefaultResopnseBean<>();
        resopnseBean.setData(pageResponseBean);
        return resopnseBean;
    }

	@ApiOperation(value = "B类文件接口", notes = "B类文件接口")
	@RequestMapping(value = "/b/page", method = {RequestMethod.GET})
	@ResponseBody
	public DefaultResopnseBean<PageResponseBean<FileResultBean>> pageListB(@ApiParam("查询内容") @RequestParam("query") String query,
																		   @ApiParam("文件分类code") @RequestParam("categoryCode") String categoryCode,
																		   @ApiParam("第几页") @RequestParam("page") Integer page,
																		   @ApiParam("每页多少条") @RequestParam("pageSize") Integer pageSize,
																		   HttpServletRequest request, HttpServletResponse response) {
		servletPath = request.getServletPath();
		PageResponseBean<FileResultBean> pageResponseBean = fileManagerService.pageabList(FileQuerySuffixEnum.ZX_FILE_QUERY_SUFFIX_B.label, categoryCode, page, pageSize, query);
		DefaultResopnseBean<PageResponseBean<FileResultBean>> resopnseBean = new DefaultResopnseBean<>();
		resopnseBean.setData(pageResponseBean);
		return resopnseBean;
	}

	@ApiOperation(value = "C类文件接口", notes = "C类文件接口")
	@RequestMapping(value = "/c/page", method = {RequestMethod.GET})
	@ResponseBody
	public DefaultResopnseBean<PageResponseBean<FileResultBean>> pageListC(@ApiParam("查询内容") @RequestParam("query") String query,
																		   @ApiParam("文件分类code") @RequestParam("categoryCode") String categoryCode,
																		   @ApiParam("第几页") @RequestParam("page") Integer page,
																		   @ApiParam("每页多少条") @RequestParam("pageSize") Integer pageSize,
																		   HttpServletRequest request, HttpServletResponse response) {
		servletPath = request.getServletPath();
		PageResponseBean<FileResultBean> pageResponseBean = fileManagerService.pagecdeList(FileQuerySuffixEnum.ZX_FILE_QUERY_SUFFIX_C.label, categoryCode, page, pageSize, query);
		DefaultResopnseBean<PageResponseBean<FileResultBean>> resopnseBean = new DefaultResopnseBean<>();
		resopnseBean.setData(pageResponseBean);
		return resopnseBean;
	}

	@ApiOperation(value = "D类文件接口", notes = "D类文件接口")
	@RequestMapping(value = "/d/page", method = {RequestMethod.GET})
	@ResponseBody
	public DefaultResopnseBean<PageResponseBean<FileResultBean>> pageListD(@ApiParam("查询内容") @RequestParam("query") String query,
																		   @ApiParam("文件分类code") @RequestParam("categoryCode") String categoryCode,
																		   @ApiParam("第几页") @RequestParam("page") Integer page,
																		   @ApiParam("每页多少条") @RequestParam("pageSize") Integer pageSize,
																		   HttpServletRequest request, HttpServletResponse response) {
		servletPath = request.getServletPath();
		PageResponseBean<FileResultBean> pageResponseBean = fileManagerService.pagecdeList(FileQuerySuffixEnum.ZX_FILE_QUERY_SUFFIX_D.label, categoryCode, page, pageSize, query);
		DefaultResopnseBean<PageResponseBean<FileResultBean>> resopnseBean = new DefaultResopnseBean<>();
		resopnseBean.setData(pageResponseBean);
		return resopnseBean;
	}

	@ApiOperation(value = "E类文件接口", notes = "E类文件接口")
	@RequestMapping(value = "/e/page", method = {RequestMethod.GET})
	@ResponseBody
	public DefaultResopnseBean<PageResponseBean<FileResultBean>> pageListE(@ApiParam("查询内容") @RequestParam("query") String query,
																		   @ApiParam("文件分类code") @RequestParam("categoryCode") String categoryCode,
																		   @ApiParam("第几页") @RequestParam("page") Integer page,
																		   @ApiParam("每页多少条") @RequestParam("pageSize") Integer pageSize,
																		   HttpServletRequest request, HttpServletResponse response) {
		servletPath = request.getServletPath();
		PageResponseBean<FileResultBean> pageResponseBean = fileManagerService.pagecdeList(FileQuerySuffixEnum.ZX_FILE_QUERY_SUFFIX_E.label, categoryCode, page, pageSize, query);
		DefaultResopnseBean<PageResponseBean<FileResultBean>> resopnseBean = new DefaultResopnseBean<>();
		resopnseBean.setData(pageResponseBean);
		return resopnseBean;
	}

	@ApiOperation(value = "获取文件详情", notes = "获取文件详情")
	@RequestMapping(value = "/details",method = RequestMethod.GET)
	@ResponseBody
	public DefaultResopnseBean<FileResultBean> details(@ApiParam("文件code") @RequestParam("code") String code,
													   HttpServletRequest request){
		servletPath = request.getServletPath();
		DefaultResopnseBean<FileResultBean> resopnseBean = new DefaultResopnseBean<>();
		if(StringUtil.isBlank(code)){
			resopnseBean.jsonFill(ErrorsEnum.SYSTEM_REQUEST_PARAM_ERROR);
			return resopnseBean;
		}
		resopnseBean.setData(fileManagerService.details(code));
		return resopnseBean;
	}

}
