package com.exqoo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exqoo.entity.SysFileSort;
import com.exqoo.service.SysFileService;
import com.exqoo.utils.Word2Pdf;

/**
 * 文件管理控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/file")
public class SysFileController {

	@Autowired
	private SysFileService sysFileService;
	
	/**
	 * 查询所有的标题
	 * @return
	 */
	@RequestMapping("/select")
	public String load(){
		List<SysFileSort> list=sysFileService.selectAll();
		for (SysFileSort sysFileSort : list) {
			System.out.println(sysFileSort.getSortName());
		}
		return "index";
	}
	
	
	/**
	 * 预览word
	 * @param response
	 * @param fileUrl
	 * @throws Exception
	 */
	@RequestMapping(value = "showFile/word", method = RequestMethod.GET)
	public void showFileWord(HttpServletResponse response, String fileUrl) throws Exception {
		File file = new File(fileUrl);

		FileInputStream fis = new FileInputStream(file);

		response.setContentType("application/pdf");
		
		OutputStream out = response.getOutputStream();

		Word2Pdf.word2pdf(fis, out);

		fis.close();
		out.close();
	}

	/**
	 * 预览pdf
	 * @param response
	 * @param fileUrl
	 * @throws IOException
	 */
	@RequestMapping(value = "showFile/pdf", method = RequestMethod.GET)
	public void showFilePdf(HttpServletResponse response,String fileUrl) throws IOException {

		File file = new File(fileUrl);

		FileInputStream fis = new FileInputStream(file);
		OutputStream out = response.getOutputStream();

		byte[] bs = new byte[1024];
		int len = 0;

		while ((len = fis.read(bs)) != -1) {
			out.write(bs, 0, len);
		}

		fis.close();
		out.close();
	}
	
	
}
