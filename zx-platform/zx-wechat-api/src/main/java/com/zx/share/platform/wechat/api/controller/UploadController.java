package com.zx.share.platform.wechat.api.controller;

import com.zx.share.platform.bean.zx.ZxFileManagerCDE;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.wechat.service.UploadService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     * @Title: fileUploadD
     * @Description: 上传文件
     */
    @RequestMapping(value = "/e", consumes = "multipart/*", headers = "content-type=multipart/form-data", method = RequestMethod.POST)
    @ApiOperation(value = "e上传文件", notes = "用户上传文件")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "ZxFileManagerCDE", name = "file", value = "文件信息", required = true) })
    public DefaultResopnseBean<Object> fileUploadE(
            @ApiParam(value = "上传的文件", required = true) MultipartFile multipartFile, ZxFileManagerCDE file) {

        return uploadService.add(file, multipartFile);
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

        return uploadService.add(file, multipartFile);
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

        return uploadService.add(file, multipartFile);
    }
}
