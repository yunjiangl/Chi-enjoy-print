package com.zx.share.platform.console.api.modules.file.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zx.share.platform.bean.zx.ZxFileManagerAB;
import com.zx.share.platform.console.api.modules.file.dao.ZxFileManagerABMapper;
import com.zx.share.platform.console.api.modules.file.service.UploadService;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.DateUtil;
import com.zx.share.platform.util.Excel2Pdf;
import com.zx.share.platform.util.GetPdfpage;
import com.zx.share.platform.util.Word2PdfUtil;
import com.zx.share.platform.util.file.FileUtil;
import com.zx.share.platform.util.response.DefaultResopnseBean;

/**
 * Created by fenggang on 18/3/19.
 *
 * @author fenggang
 * @date 18/3/19
 */
@Service
public class UploadServiceImpl implements UploadService {



    @Value("${filePath}")
    private String filePath;
    
    @Autowired
    private ZxFileManagerABMapper zxFileManagerABMapper;

    @Override
    @Transactional
    public DefaultResopnseBean<Object> add(ZxFileManagerAB file, MultipartFile multipartFile) {

        return null;
    }

    //按照类型，年月日区分文件夹
    private String _getFilePath(String filePath,String userId){
        StringBuffer newFilePath = new StringBuffer(filePath+userId+File.separator);
        newFilePath.append(File.separator+DateUtil.getDateString(new Date()));
        newFilePath.append(File.separator);
        FileUtil.isExistDir(newFilePath.toString());
        return newFilePath.toString();
    }

}
