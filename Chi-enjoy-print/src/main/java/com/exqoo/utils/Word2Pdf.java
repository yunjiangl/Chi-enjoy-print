package com.exqoo.utils;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;

import java.io.*;

/**
 * Created by wangyi on 2017/11/9.
 */
public class Word2Pdf {
    public static boolean getLicense() {
        boolean result = false;
        try {
            InputStream is = Word2Pdf.class.getClassLoader().getResourceAsStream("license.xml"); //  wordlicense.xml应放在..\WebRoot\WEB-INF\classes路径下
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void main(String[] args){
        Word2Pdf.word2pdf("C:\\Users\\Administrator\\Desktop/4894.docx");
    }
    public static void word2pdf(String Address) {
        if (!getLicense()) {          // 验证License 若不验证则转化出的PDP文档会有水印产生
            return;
        }
        try {
            File file = new File("C:\\Users\\Administrator\\Desktop/pdf1.pdf");  //新建一个空白pdf文档
            FileOutputStream os = new FileOutputStream(file);
            Document doc = new Document(Address);                    //Address是将要被转化的word文档
            doc.save(os, SaveFormat.PDF);                            //全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换            os.close();
            os.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void word2pdf(InputStream inputStream) throws Exception{
        if (!getLicense()) {          // 验证License 若不验证则转化出的PDP文档会有水印产生
            return;
        }
        File file = new File("C:\\Users\\Administrator\\Desktop/pdf1.pdf");  //新建一个空白pdf文档
        FileOutputStream os = new FileOutputStream(file);
        Document doc = new Document(inputStream);                    //Address是将要被转化的word文档
        doc.save(os, SaveFormat.PDF);                            //全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换            os.close();
        inputStream.close();
        os.close();
    }
    public static void word2pdf(InputStream inputStream, OutputStream outputStream) throws Exception{
        if (!getLicense()) {          // 验证License 若不验证则转化出的PDP文档会有水印产生
            return;
        }
        Document doc = new Document(inputStream);                    //Address是将要被转化的word文档
        doc.save(outputStream, SaveFormat.PDF);
    }
}
