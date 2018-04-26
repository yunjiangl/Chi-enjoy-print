package com.zx.share.platform.wechat.service;

import com.zx.share.platform.bean.zx.ZxFileManagerCDE;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import org.springframework.web.multipart.MultipartFile;

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
    DefaultResopnseBean<Object> add(ZxFileManagerCDE file, MultipartFile multipartFile);
    /**
     *
     * @Title: add
     * @Description: 添加用户照片
     */
    DefaultResopnseBean<Object> addImg(MultipartFile multipartFile,String filePath);
}
