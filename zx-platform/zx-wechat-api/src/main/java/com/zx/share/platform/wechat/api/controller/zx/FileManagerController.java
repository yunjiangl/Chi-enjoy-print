package com.zx.share.platform.wechat.api.controller.zx;

import com.zx.share.platform.bean.zx.ZxFileManagerCDE;
import com.zx.share.platform.constants.FileQuerySuffixEnum;
import com.zx.share.platform.util.annotation.ACSPermissions;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

	@Autowired
	private CDEFileService service;

	@ApiOperation(value = "A类文件接口", notes = "A类文件接口")
	@RequestMapping(value = "/a/page", method = { RequestMethod.GET })
	@ResponseBody
	public DefaultResopnseBean<PageResponseBean<FileResultBean>> pageListA(
			@ApiParam("文件分类code") @RequestParam("categoryCode") String categoryCode,
			@ApiParam("第几页") @RequestParam("page") Integer page,
			@ApiParam("每页多少条") @RequestParam("pageSize") Integer pageSize, HttpServletRequest request,
			HttpServletResponse response) {
		servletPath = request.getServletPath();
		PageResponseBean<FileResultBean> pageResponseBean = fileManagerService
				.pageList(FileQuerySuffixEnum.ZX_FILE_QUERY_SUFFIX_AB.label, categoryCode, page, pageSize);
		DefaultResopnseBean<PageResponseBean<FileResultBean>> resopnseBean = new DefaultResopnseBean<>();
		resopnseBean.setData(pageResponseBean);
		return resopnseBean;
	}

	@ApiOperation(value = "B类文件接口", notes = "B类文件接口")
	@RequestMapping(value = "/b/page", method = { RequestMethod.GET })
	@ResponseBody
	public DefaultResopnseBean<PageResponseBean<FileResultBean>> pageListB(
			@ApiParam("文件分类code") @RequestParam("categoryCode") String categoryCode,
			@ApiParam("第几页") @RequestParam("page") Integer page,
			@ApiParam("每页多少条") @RequestParam("pageSize") Integer pageSize, HttpServletRequest request,
			HttpServletResponse response) {
		servletPath = request.getServletPath();
		PageResponseBean<FileResultBean> pageResponseBean = fileManagerService
				.pageList(FileQuerySuffixEnum.ZX_FILE_QUERY_SUFFIX_CDE.label, categoryCode, page, pageSize);
		DefaultResopnseBean<PageResponseBean<FileResultBean>> resopnseBean = new DefaultResopnseBean<>();
		resopnseBean.setData(pageResponseBean);
		return resopnseBean;
	}

	/**
	 * @Title: list
	 * @Description: 文件列表
	 */
	@RequestMapping(value = "/c/list", method = RequestMethod.GET)
	@ApiOperation(value = "c文件列表", notes = "律师上传文件列表")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "Long", name = "categoryId", value = "文件类型", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "Long", name = "userId", value = "用户id", required = true), })
	@ResponseBody
	public DefaultResopnseBean<List<ZxFileManagerCDE>> listC(Long categoryId, Long userId) {

		return service.list(categoryId, userId);
	}

	/**
	 * @Title: fileUploadC
	 * @Description: 上传文件
	 */
	@RequestMapping(value = "/c/upLoad", consumes = "multipart/*", headers = "content-type=multipart/form-data", method = RequestMethod.POST)
	@ApiOperation(value = "c上传文件", notes = "律师上传文件")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", dataType = "ZxFileManagerCDE", name = "file", value = "文件信息", required = true) })
	public DefaultResopnseBean<Object> fileUploadC(
			@ApiParam(value = "上传的文件", required = true) MultipartFile multipartFile, ZxFileManagerCDE file) {

		return service.add(file, multipartFile);
	}

	/**
	 * @Title: fileUploadD
	 * @Description: 上传文件
	 */
	@RequestMapping(value = "/d/upLoad", consumes = "multipart/*", headers = "content-type=multipart/form-data", method = RequestMethod.POST)
	@ApiOperation(value = "d上传文件", notes = "用户上传照片")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", dataType = "ZxFileManagerCDE", name = "file", value = "文件信息", required = true) })
	public DefaultResopnseBean<Object> fileUploadD(
			@ApiParam(value = "上传的照片", required = true) MultipartFile multipartFile, ZxFileManagerCDE file) {

		return service.add(file, multipartFile);
	}

	/**
	 * @Title: list
	 * @Description: 文件列表
	 */
	@RequestMapping(value = "/d/list", method = RequestMethod.GET)
	@ApiOperation(value = "d文件列表", notes = "用户上传文件列表")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "Long", name = "categoryId", value = "文件类型", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "Long", name = "userId", value = "用户id", required = true), })
	@ResponseBody
	public DefaultResopnseBean<List<ZxFileManagerCDE>> listD(Long categoryId, Long userId) {

		return service.list(categoryId, userId);
	}
	
	/**
	 * @Title: fileUploadD
	 * @Description: 上传文件
	 */
	@RequestMapping(value = "/e/upLoad", consumes = "multipart/*", headers = "content-type=multipart/form-data", method = RequestMethod.POST)
	@ApiOperation(value = "e上传文件", notes = "用户上传文件")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", dataType = "ZxFileManagerCDE", name = "file", value = "文件信息", required = true) })
	public DefaultResopnseBean<Object> fileUploadE(
			@ApiParam(value = "上传的文件", required = true) MultipartFile multipartFile, ZxFileManagerCDE file) {

		return service.add(file, multipartFile);
	}

}
