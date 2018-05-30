package com.zx.share.platform.console.api.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;
import org.aspectj.weaver.ast.Test;

/**
 * Created by Nominal on 2018/5/30 0030.
 * 微博：@Mr丶Li_Anonym
 */
public class Word2PdfUtil {
    public static boolean getLicense() {
        boolean result = false;
        try {
            InputStream is = Test.class.getClassLoader().getResourceAsStream("license.xml"); // license.xml应放在根路径路径下
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void doc2pdf(String inPath) {
        if (!getLicense()) { // 验证License 若不验证则转化出的pdf文档会有水印产生
            return;
        }
        try {
            String path=inPath.substring(0,inPath.lastIndexOf("/"))+"/pdf";
            String ids=inPath.substring(inPath.lastIndexOf("/"),inPath.lastIndexOf("."))+".pdf";
            File file =new File(path);
//如果文件夹不存在则创建
            if  (!file .exists()  && !file .isDirectory())
            {
                System.out.println("//不存在");
                file .mkdir();
            }
            long old = System.currentTimeMillis();
            File file1 = new File(path+ids); // 新建一个空白pdf文档
            FileOutputStream os = new FileOutputStream(file1);
            Document doc = new Document(inPath); // Address是将要被转化的word文档
            doc.save(os, SaveFormat.PDF);// 全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF,
            // EPUB, XPS, SWF 相互转换
            long now = System.currentTimeMillis();
            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒"); // 转化用时
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
