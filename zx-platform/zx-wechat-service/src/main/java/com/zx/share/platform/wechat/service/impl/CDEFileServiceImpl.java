package com.zx.share.platform.wechat.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

	@Value("${filePath}")
	private String filePath;

	@Override
	public DefaultResopnseBean<List<ZxFileManagerCDE>> list(Long categoryId, Long userId) {

		ZxFileManagerCDE file = new ZxFileManagerCDE();

		file.setCategoryId(categoryId);
		file.setUserId(userId);

		List<ZxFileManagerCDE> list = CDEFileMapper.queryList(file);

		return new DefaultResopnseBean<List<ZxFileManagerCDE>>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, list);
	}
}
