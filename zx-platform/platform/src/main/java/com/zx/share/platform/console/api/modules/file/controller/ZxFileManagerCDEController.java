package com.zx.share.platform.console.api.modules.file.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zx.share.platform.bean.sys.SysDictionary;
import com.zx.share.platform.bean.zx.ZxFileManagerCDE;
import com.zx.share.platform.console.api.modules.file.service.ZxFileManagerCDEService;
import com.zx.share.platform.constants.DictionaryTypeEnum;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

@RestController
@RequestMapping("zx/cde/")
public class ZxFileManagerCDEController {

	@Autowired
	private ZxFileManagerCDEService zxFileManagerCDEService;

	/**
	 * 
	 * @Title: list
	 * @Description: 文件分类cde列表
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public DefaultResopnseBean<PageResponseBean<ZxFileManagerCDE>> list(
			@RequestParam(name = "pageNum", required = false) Integer pageNum,
			@RequestParam(name = "pageSize", required = false) Integer pageSize,
			@RequestParam(name = "userName", required = false) String userName,
			@RequestParam(name = "fileName", required = false) String fileName,
			@RequestParam(name = "startTime", required = false) String startTime,
			@RequestParam(name = "endTime", required = false) String endTime,
			@RequestParam(name = "typeString", required = false) String typeString) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (DictionaryTypeEnum.ZX_DICTIONARY_TYPE_FILE_C.label.equals(typeString)) {
			SysDictionary sysDictionary = new SysDictionary();
			sysDictionary.setType(DictionaryTypeEnum.ZX_DICTIONARY_TYPE_FILE_C.code);

			params.put("type", sysDictionary.getType());
		}
		if (DictionaryTypeEnum.ZX_DICTIONARY_TYPE_FILE_D.label.equals(typeString)) {
			SysDictionary sysDictionary = new SysDictionary();
			sysDictionary.setType(DictionaryTypeEnum.ZX_DICTIONARY_TYPE_FILE_D.code);
			params.put("type", sysDictionary.getType());
		}
		if (DictionaryTypeEnum.ZX_DICTIONARY_TYPE_FILE_E.label.equals(typeString)) {
			SysDictionary sysDictionary = new SysDictionary();
			sysDictionary.setType(DictionaryTypeEnum.ZX_DICTIONARY_TYPE_FILE_E.code);
			params.put("type", sysDictionary.getType());
		}

		params.put("pageNum", pageNum);
		params.put("pageSize", pageSize);
		params.put("userName", userName);
		params.put("fileName", fileName);
		params.put("createTime", startTime);
		params.put(" updateTime", endTime);

		return zxFileManagerCDEService.list(params);
	}

	/**
	 * 
	 * @param Id
	 * @Description: 删除文件cde
	 * @return
	 */
	@RequestMapping(value = "/sys/deleteUserById", method = RequestMethod.GET)
	public DefaultResopnseBean<Object> delete(@RequestParam("ids") Long ids) {
		return zxFileManagerCDEService.delete(ids);
	}

}
