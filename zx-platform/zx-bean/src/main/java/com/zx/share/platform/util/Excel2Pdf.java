package com.zx.share.platform.util;

import java.io.File;
import java.io.FileOutputStream;

import com.aspose.cells.PdfSaveOptions;
import com.aspose.cells.Workbook;

public class Excel2Pdf {

	public static String excel2pdf(String Address) {
		try {
			File pdfFile = new File("G:\\fileuploadtest\\src\\file\\pdf2.pdf");// 输出路径
			Workbook wb = new Workbook(Address);// 原始excel路径
			FileOutputStream fileOS = new FileOutputStream(pdfFile);
			PdfSaveOptions saveOptions = new PdfSaveOptions();
			saveOptions.setAllColumnsInOnePagePerSheet(true);
			wb.save(fileOS, saveOptions);
			fileOS.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "G:\\fileuploadtest\\src\\file\\pdf1.pdf";

	}
}
