package com.zx.share.platform.util;

import java.io.IOException;

import com.itextpdf.text.pdf.PdfReader;

/**
 * 
 * @ClassName: GetPdfpage
 * @Description:获取pdf页数
 * @author: 刘芸江
 * @date: 2018年3月13日 下午3:32:15
 *
 */
public class GetPdfpage {
	public static int getPdfPage(String filepath) {
		int pagecount = 0;
		PdfReader reader;
		try {
			reader = new PdfReader(filepath);
			pagecount = reader.getNumberOfPages();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(pagecount);
		return pagecount;
	}
}
