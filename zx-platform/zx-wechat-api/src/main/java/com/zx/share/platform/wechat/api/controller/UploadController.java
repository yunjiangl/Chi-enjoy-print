package com.zx.share.platform.wechat.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zx.share.platform.bean.zx.ZxFileManagerCDE;
import com.zx.share.platform.common.bean.UserCache;
import com.zx.share.platform.common.service.TokenCacheService;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.wechat.service.UploadService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Created by fenggang on 18/3/19.
 *
 * @author fenggang
 * @date 18/3/19
 */
@Api(value = "/upload/file", produces = "application/json", description = "文件上传接口")
@Controller
@RequestMapping("/upload/file")
public class UploadController {

	@Autowired
	private UploadService uploadService;

	@Autowired
	private TokenCacheService tokenCacheService;

	/**
	 * @throws Exception
	 * @Title: fileUploadD
	 * @Description: 上传文件
	 */
	@RequestMapping(value = "/e", consumes = "multipart/*", headers = "content-type=multipart/form-data", method = RequestMethod.POST)
	@ApiOperation(value = "e上传文件", notes = "用户上传文件")
	public DefaultResopnseBean<Object> fileUploadE(
			@ApiParam(value = "上传的文件", required = true) MultipartFile multipartFile,
			@ApiParam(value = "管理员id", required = true) Long managerId,
			@ApiParam(value = "摘要", required = true) String abstracts, HttpServletRequest request) throws Exception {

		ZxFileManagerCDE file = new ZxFileManagerCDE();

		UserCache userCache = tokenCacheService.getCacheUser(request); // 得到当前登录用户

		file.setCreateId(userCache.getId());
		file.setUserId(userCache.getId());
		file.setManagerId(managerId);
		file.setAbstracts(abstracts);
		file.setCategoryId(16L);

		return uploadService.add(file, multipartFile);
	}

	/**
	 * @throws Exception
	 * @Title: fileUploadC
	 * @Description: 上传文件
	 */
	@RequestMapping(value = "/c/upLoad", consumes = "multipart/*", headers = "content-type=multipart/form-data", method = RequestMethod.POST)
	@ApiOperation(value = "c上传文件", notes = "律师上传文件")
	public DefaultResopnseBean<Object> fileUploadC(
			@ApiParam(value = "上传的文件", required = true) MultipartFile multipartFile,
			@ApiParam(value = "管理员id", required = true) Long managerId,
			@ApiParam(value = "摘要", required = true) String abstracts,
			@ApiParam(value = "用户id", required = true) Long userId, HttpServletRequest request) throws Exception {

		ZxFileManagerCDE file = new ZxFileManagerCDE();

		UserCache userCache = tokenCacheService.getCacheUser(request); // 得到当前登录用户
		file.setCreateId(userCache.getId());
		file.setUserId(userId);
		file.setManagerId(managerId);
		file.setAbstracts(abstracts);
		file.setCategoryId(17L);

		return uploadService.add(file, multipartFile);
	}

	/**
	 * @throws Exception
	 * @Title: fileUploadD
	 * @Description: 上传文件
	 */
	@RequestMapping(value = "/userimg", consumes = "multipart/*", headers = "content-type=multipart/form-data", method = RequestMethod.POST)
	@ApiOperation(value = "上传文件", notes = "用户上传照片")
	@ResponseBody
	public DefaultResopnseBean<Object> fileUploadD(
			@ApiParam(value = "上传的照片", required = true) MultipartFile multipartFile,
			@ApiParam(value = "摘要", required = true) String abstracts,
			@ApiParam(value = "用户code", required = true) Long userCode, HttpServletRequest request) throws Exception {

		//UserCache userCache = tokenCacheService.getCacheUser(request); // 得到当前登录用户
		//上传文件路径
		String filePath="F://images//"+userCode+"//";

		return uploadService.addImg(multipartFile,filePath);
	}
	/**
	 * @throws Exception
	 * @Title: fileUploadD
	 * @Description: 上传文件
	 */
	@RequestMapping(value = "/d/upLoad", consumes = "multipart/*", headers = "content-type=multipart/form-data", method = RequestMethod.POST)
	@ApiOperation(value = "d上传文件", notes = "用户上传照片")
	public DefaultResopnseBean<Object> userImgUpload(
			@ApiParam(value = "上传的照片", required = true) MultipartFile multipartFile,
			@ApiParam(value = "管理员id", required = true) Long managerId,
			@ApiParam(value = "摘要", required = true) String abstracts,
			@ApiParam(value = "用户id", required = true) Long userId, HttpServletRequest request) throws Exception {

		ZxFileManagerCDE file = new ZxFileManagerCDE();

		UserCache userCache = tokenCacheService.getCacheUser(request); // 得到当前登录用户

		file.setCreateId(userCache.getId());
		file.setUserId(userCache.getId());
		file.setManagerId(managerId);
		file.setAbstracts(abstracts);
		file.setCategoryId(18L);

		return uploadService.add(file, multipartFile);
	}
}
