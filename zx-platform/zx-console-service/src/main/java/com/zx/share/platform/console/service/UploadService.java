package com.zx.share.platform.console.service;

import org.springframework.web.multipart.MultipartFile;

import com.zx.share.platform.bean.zx.ZxFileManagerAB;
import com.zx.share.platform.util.response.DefaultResopnseBean;

/**
 * Created by fenggang on 18/3/19.
 *
 * @author fenggang
 * @date 18/3/19
 */
public interface UploadService {

    /**
     *
     * @Title: add
     * @Description: 添加文件
     */
    DefaultResopnseBean<Object> add(ZxFileManagerAB file, MultipartFile multipartFile);
}
