package com.zx.share.platform.wechat.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.zx.share.platform.bean.zx.ZxFileManagerCDE;
import com.zx.share.platform.util.response.DefaultResopnseBean;

/**
 * 
 * @ClassName: CDEFileService
 * @Description:TODO(CDE文件微信端业务借口类)
 * @author: 刘芸江
 * @date: 2018年3月12日 上午9:24:14
 *
 */
public interface CDEFileService {

	/**
	 * @Title: list
	 * @Description: 文件列表
	 * @param categoryId
	 *            文件分类id
	 * @param userId
	 *            用户id
	 * @return: DefaultResopnseBean<PageResponseBean<ZxFileManagerCDE>>
	 * 
	 */
	DefaultResopnseBean<List<ZxFileManagerCDE>> list(Long categoryId, Long userId);

	/**
	 * 
	 * @Title: add
	 * @Description: 添加文件
	 */
	DefaultResopnseBean<Object> add(ZxFileManagerCDE file, MultipartFile multipartFile);

}
