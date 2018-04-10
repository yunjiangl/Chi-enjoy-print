package com.zx.share.platform.util;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Value;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;

public class Word2PdfUtil {


	public static String doc2pdf(String Address) {

		try {
			long old = System.currentTimeMillis();
			File file = new File("/home/zx-platform/file/pdf1.pdf"); // 新建一个空白pdf文档
			FileOutputStream os = new FileOutputStream(file);
			Document doc = new Document(Address); // Address是将要被转化的word文档
			doc.save(os, SaveFormat.PDF);// 全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
			long now = System.currentTimeMillis();
			System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒"); // 转化用时
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/home/zx-platform/file/pdf1.pdf";
	}
}
