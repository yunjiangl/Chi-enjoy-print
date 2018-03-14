package com.zx.share.platform.wechat.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zx.share.platform.bean.zx.ZxFileManagerCDE;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.GetPdfpage;
import com.zx.share.platform.util.Word2PdfUtil;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.wechat.mapper.file.CDEFileMapper;
import com.zx.share.platform.wechat.service.CDEFileService;

/**
 * 
 * @ClassName: CDEFileServiceImpl
 * @Description: CDE文件微信端业务实现类
 * @author: 刘芸江
 * @date: 2018年3月12日 下午5:50:59
 *
 */
@Service
public class CDEFileServiceImpl implements CDEFileService {

	@Autowired
	private CDEFileMapper CDEFileMapper;

	@Override
	public DefaultResopnseBean<List<ZxFileManagerCDE>> list(Long categoryId, Long userId) {

		ZxFileManagerCDE file = new ZxFileManagerCDE();

		file.setCategoryId(categoryId);
		file.setUserId(userId);

		List<ZxFileManagerCDE> list = CDEFileMapper.queryList(file);
		
		System.out.println(list.get(0).getCreateTime());

		return new DefaultResopnseBean<List<ZxFileManagerCDE>>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, list);
	}

	@Override
	@Transactional
	public DefaultResopnseBean<Object> add(ZxFileManagerCDE file, MultipartFile multipartFile) {

		String filePath = "G://fileuploadtest//src//file//";

		File targetFile = new File(filePath);

		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		String fileURL = filePath + multipartFile.getOriginalFilename();

		try {

			FileOutputStream fos = new FileOutputStream(fileURL);

			FileInputStream fs = (FileInputStream) multipartFile.getInputStream();

			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fs.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}

			fos.close();
			fs.close();

			String suffix = multipartFile.getOriginalFilename()
					.substring(multipartFile.getOriginalFilename().lastIndexOf(".") + 1);

			if ("pdf".equals(suffix)) {
				file.setFileNum(GetPdfpage.getPdfPage(fileURL));
			}

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

	@Override
	public DefaultResopnseBean<ZxFileManagerCDE> queryByFileId(Long id) {
		ZxFileManagerCDE data = CDEFileMapper.selectByPrimaryKey(id);

		return new DefaultResopnseBean<ZxFileManagerCDE>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, data);
	}

}
