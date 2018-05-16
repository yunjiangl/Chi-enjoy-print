package com.zx.share.platform.wechat.service.impl;

import com.zx.share.platform.bean.zx.ZxFileManagerCDE;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.*;
import com.zx.share.platform.util.file.FileUtil;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.wechat.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

        String fileURL = this._getFilePath(filePath, file.getUserId().toString()) + multipartFile.getOriginalFilename(); // 获得文件上传之后的路径

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

            // 读取pdf文件打印页数
            if ("pdf".equals(suffix)) {
                file.setFileNum(GetPdfpage.getPdfPage(fileURL));
                // file.setCategoryId(categoryId); 设置文件分类id
            }

            // 读取word文件打印页数
            if ("doc".equals(suffix) || "docx".equals(suffix)) {
                file.setFileNum(GetPdfpage.getPdfPage(Word2PdfUtil.doc2pdf(fileURL)));
                // file.setCategoryId(categoryId); 设置文件分类id
            }

            // 读取Excel文件打印页数
            if ("xls".equals(suffix) || "xlsx".equals(suffix)) {
                file.setFileNum(GetPdfpage.getPdfPage(Excel2Pdf.excel2pdf(fileURL)));
                // file.setCategoryId(categoryId); 设置文件分类id
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new DefaultResopnseBean<Object>("文件上传失败", 500, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<ZxFileManagerCDE> list =  CDEFileMapper.selectAll();

        file.setFileName(multipartFile.getOriginalFilename());
        file.setFileUrl(fileURL);
        file.setFileCode(CodeBuilderUtil.fileCode(file.getCategoryCode(),String.valueOf(list.get(list.size()-1).getId() + 1)));
        file.setCreateTime(new Date());

        CDEFileMapper.insertSelective(file);

        return new DefaultResopnseBean<Object>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, file.getFileCode());
    }

    //按照类型，年月日区分文件夹
    private String _getFilePath(String filePath, String userId) {
        StringBuffer newFilePath = new StringBuffer(filePath + userId + File.separator);
        newFilePath.append(File.separator + DateUtil.getDateString(new Date()));
        newFilePath.append(File.separator);
        FileUtil.isExistDir(newFilePath.toString());
        return newFilePath.toString();
    }

    /**
     * @param filePath 文件保存路径
     * @param multipartFile
     * @Title: add
     * @Description: 添加用户照片
     */
    @Override
    public DefaultResopnseBean<Object> addImg(MultipartFile multipartFile, String filePath) {
        // 获得文件后缀
        String suffix = multipartFile.getOriginalFilename()
                .substring(multipartFile.getOriginalFilename().lastIndexOf(".") );
        //生成唯一id
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // 判断文件夹是否存在
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        String fileURL = filePath+uuid+suffix;

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

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new DefaultResopnseBean<Object>("文件上传失败", 500, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new DefaultResopnseBean<Object>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, fileURL);
    }
}
