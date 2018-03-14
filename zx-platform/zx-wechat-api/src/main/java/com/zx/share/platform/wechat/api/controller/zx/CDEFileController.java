package com.zx.share.platform.wechat.api.controller.zx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zx.share.platform.bean.zx.ZxFileManagerCDE;
import com.zx.share.platform.util.annotation.ACSPermissions;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.wechat.service.CDEFileService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * @ClassName: CDEFileController
 * @Description:CDE类文件微信端接口
 * @author: 刘芸江
 * @date: 2018年3月12日 下午2:50:07
 *
 */
@Api(value = "/file/cde", produces = "application/json", description = "CDE文件接口")
@RestController
@RequestMapping("/file/cde")
public class CDEFileController {

	@Autowired
	private CDEFileService service;

	/**
	 * 
	 * @Title: list
	 * @Description: 文件列表
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET)
	@ApiOperation(value = "文件列表", notes = "文件列表")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "Long", name = "categoryId", value = "文件类型", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "Long", name = "userId", value = "用户id", required = true), })
	@ACSPermissions(permissions = "zx:cde:list") // 操作权限
	public DefaultResopnseBean<List<ZxFileManagerCDE>> list(Long categoryId, Long userId) {

		return service.list(categoryId, userId);
	}

	/**
	 * 
	 * @Title: save
	 * @Description: 保存文件信息
	 */
	@RequestMapping(value = "save", consumes = "multipart/*", headers = "content-type=multipart/form-data", method = RequestMethod.POST)
	@ApiOperation(value = "上传文件", notes = "上传文件")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", dataType = "ZxFileManagerCDE", name = "file", value = "文件信息", required = true) })
	@ACSPermissions(permissions = "zx:cde:save") // 操作权限
	public DefaultResopnseBean<Object> save(@ApiParam(value = "上传的文件", required = true) MultipartFile multipartFile,
			ZxFileManagerCDE file) {

		return service.add(file, multipartFile);
	}

	/**
	 * 
	 * @Title: queryById
	 * @Description: 通过文件id查询文件信息
	 */
	@RequestMapping(value = "sel/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "查询文件", notes = "通过文件id查询文件信息")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path", dataType = "Long", name = "id", value = "文件id", required = true) })
	@ACSPermissions(permissions = "zx:cde:sel") // 操作权限
	public DefaultResopnseBean<ZxFileManagerCDE> queryById(@PathVariable(name = "id") Long id) {
		return service.queryByFileId(id);
	}
}
