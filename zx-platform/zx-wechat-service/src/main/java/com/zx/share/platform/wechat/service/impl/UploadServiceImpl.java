package com.zx.share.platform.wechat.service.impl;

import com.zx.share.platform.bean.zx.ZxFileManagerCDE;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.GetPdfpage;
import com.zx.share.platform.util.Word2PdfUtil;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.wechat.mapper.file.CDEFileMapper;
import com.zx.share.platform.wechat.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;

/**
 * Created by fenggang on 18/3/19.
 *
 * @author fenggang
 * @date 18/3/19
 */
@Service
public class UploadServiceImpl implements UploadService {


    @Autowired
    private com.zx.share.platform.wechat.mapper.file.CDEFileMapper CDEFileMapper;

    @Value("${filePath}")
    private String filePath;

    @Override
    @Transactional
    public DefaultResopnseBean<Object> add(ZxFileManagerCDE file, MultipartFile multipartFile) {

        File targetFile = new File(filePath);

        // 判断文件夹是否存在
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        String fileURL = filePath + multipartFile.getOriginalFilename(); // 获得文件上传之后的路径

        try {

            // 文件上传
            FileOutputStream fos = new FileOutputStream(fileURL);

            FileInputStream fs = (FileInputStream) multipartFile.getInputStream();

            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fs.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

            fos.close();
            fs.close();

            // 文件上传完毕

            // 获得文件后缀
            String suffix = multipartFile.getOriginalFilename()
                    .substring(multipartFile.getOriginalFilename().lastIndexOf(".") + 1);

            // 读取文件打印页数
            if ("pdf".equals(suffix)) {
                file.setFileNum(GetPdfpage.getPdfPage(fileURL));
            }

            // 读取文件打印页数
            if ("doc".equals(suffix) || "docx".equals(suffix)) {
                file.setFileNum(GetPdfpage.getPdfPage(Word2PdfUtil.doc2pdf(fileURL)));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new DefaultResopnseBean<Object>("文件上传失败", 500, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        file.setFileName(multipartFile.getOriginalFilename());
        file.setFileUrl(fileURL);

        // 设置文件创建者id
        // file.setCreateId(createId);
        file.setCreateTime(new Date());

        CDEFileMapper.insertSelective(file);

        return new DefaultResopnseBean<Object>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, null);
    }

}
