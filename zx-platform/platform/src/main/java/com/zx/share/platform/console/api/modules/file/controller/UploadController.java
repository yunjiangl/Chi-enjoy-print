package com.zx.share.platform.console.api.modules.file.controller;

import com.zx.share.platform.console.api.common.utils.R;
import com.zx.share.platform.console.api.modules.sys.controller.AbstractController;
import com.zx.share.platform.util.Excel2Pdf;
import com.zx.share.platform.util.GetPdfpage;
import com.zx.share.platform.util.Word2PdfUtil;
import com.zx.share.platform.util.file.FileUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by fenggang on 18/4/24.
 *
 * @author fenggang
 * @date 18/4/24
 */
@RestController
@RequestMapping("/upload")
public class UploadController extends AbstractController {

    private final String UPLOAD_TYPE_A = "/home/file/";//A类文件

    /**
     * 单条数据展示
     * @param file
     * @return
     */
    @RequestMapping("/a/file")
    public R fileA(@RequestParam(name = "file", required = true) MultipartFile file,
                   @RequestParam(name = "type", required = true) String type) {
        File targetFile = new File(UPLOAD_TYPE_A+super.getUserId());
        // 判断文件夹是否存在
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        String fileURL = FileUtil.getFilePath(UPLOAD_TYPE_A,super.getUserId()+"") + file.getOriginalFilename(); // 获得文件上传之后的路径
        Integer pageNum = 0;
        try {
            // 文件上传
            FileOutputStream fos = new FileOutputStream(fileURL);
            FileInputStream fs = (FileInputStream) file.getInputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fs.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

            fos.close();
            fs.close();
            // 文件上传完毕
            // 获得文件后缀
            String suffix = file.getOriginalFilename()
                    .substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            // 读取pdf文件打印页数
            if ("pdf".equals(suffix)) {
                pageNum = (GetPdfpage.getPdfPage(fileURL));
            }

            // 读取word文件打印页数
            if ("doc".equals(suffix) || "docx".equals(suffix)) {
                pageNum = (GetPdfpage.getPdfPage(Word2PdfUtil.doc2pdf(fileURL)));
            }

            // 读取Excel文件打印页数
            if("xls".equals(suffix)||"xlsx".equals(suffix)) {
                pageNum = (GetPdfpage.getPdfPage(Excel2Pdf.excel2pdf(fileURL)));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok().put("pageNum",pageNum).put("fileURL",fileURL);
    }

}
