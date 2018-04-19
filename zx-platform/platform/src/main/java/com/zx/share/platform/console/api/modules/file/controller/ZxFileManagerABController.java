package com.zx.share.platform.console.api.modules.file.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zx.share.platform.bean.sys.SysDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zx.share.platform.bean.zx.ZxFileManagerAB;
import com.zx.share.platform.bean.zx.ZxPrinterManager;
import com.zx.share.platform.console.api.common.utils.R;
import com.zx.share.platform.console.api.modules.file.service.ZxFileManagerABService;
import com.zx.share.platform.constants.DictionaryTypeEnum;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

@RestController
@RequestMapping("zx/ab/")
public class ZxFileManagerABController {

	@Autowired
	private ZxFileManagerABService zxFileManagerABService;

	/**
	 * 
	 * @Title: add
	 * @Description: 添加文件分类
	 */
	@RequestMapping(value = "add", consumes = "multipart/*", headers = "content-type=multipart/form-data", method = RequestMethod.POST)
	public R add(@RequestParam(name = "categoryId", required = true) Long categoryId,
			@RequestParam(name = "abstracts", required = true) String abstracts,
			@RequestParam(name = "multipartFile", required = true) MultipartFile multipartFile) {
		ZxFileManagerAB zxAB = new ZxFileManagerAB();
		zxAB.setAbstracts(abstracts);
		zxAB.setCategoryId(categoryId);
		System.out.println(categoryId);
		zxFileManagerABService.add(zxAB, multipartFile);
		return R.ok();
	}
	
	
	/**
	 * 单条数据展示
	 * @param fileId
	 * @return
	 */
	@RequestMapping("/info/{fileId}")
	public R selectId(@PathVariable("fileId") Long fileId) {
		ZxFileManagerAB zxFileManagerAB=zxFileManagerABService.selectId(fileId);
		return R.ok().put("zxFileManagerAB",zxFileManagerAB);
	}
	

/*	*//**
	 * 
	 * @Title: update
	 * @Description: 修改
	 *//*
	@RequestMapping(value = "update", consumes = "multipart/*", headers = "content-type=multipart/form-data", method = RequestMethod.POST)
	public DefaultResopnseBean<Object> update(@RequestParam(name = "id", required = false) Long id) {
		return zxFileManagerABService.update(id);
	}*/
	
	
	
	/**
	 * 修改文件
	 * @param ZxFileManagerAB
	 * @return
	 */
    @RequestMapping(value="/update",method= RequestMethod.POST)
    public R update(@RequestBody ZxFileManagerAB zxFileManagerAB){
    	zxFileManagerABService.update(zxFileManagerAB);
    	return R.ok();
    }

       

	/**
	 * 
	 * @Title: list
	 * @Description: 文件分类列表
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public DefaultResopnseBean<PageResponseBean<ZxFileManagerAB>> Alist(
			@RequestParam(name = "pageNum", required = false) Integer pageNum,
			@RequestParam(name = "pageSize", required = false) Integer pageSize,
			@RequestParam(name = "typeString", required = false) String typeString,
			@RequestParam(name = "fileName", required = false) String fileName,
			@RequestParam(name = "yijiName", required = false) String yijiName,
			@RequestParam(name = "erjiName", required = false) String erjiName,
			@RequestParam(name = "sanjiName", required = false) String sanjiName,
			@RequestParam(name = "sjName", required = false) String sjName) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (DictionaryTypeEnum.ZX_DICTIONARY_TYPE_FILE_A.label.equals(typeString)) {
			SysDictionary sysDictionary = new SysDictionary();
			sysDictionary.setType(DictionaryTypeEnum.ZX_DICTIONARY_TYPE_FILE_A.code);

			params.put("type", sysDictionary.getType());
		}
		if (DictionaryTypeEnum.ZX_DICTIONARY_TYPE_FILE_B.label.equals(typeString)) {
			SysDictionary sysDictionary = new SysDictionary();
			sysDictionary.setType(DictionaryTypeEnum.ZX_DICTIONARY_TYPE_FILE_B.code);

			params.put("type", sysDictionary.getType());
		}

		params.put("pageNum", pageNum);
		params.put("pageSize", pageSize);
		params.put("fileName", fileName);
		params.put("yijiName", yijiName);
		params.put("erjiName", erjiName);
		params.put("sanjiName", sanjiName);
		params.put("sjName", sjName);

		return zxFileManagerABService.list(params);
	}

	/**
	 * 
	 * @param Id
	 * @Description: 删除文件
	 * @return
	 */
	@RequestMapping(value = "/sys/deleteUserById", method = RequestMethod.GET)
	public DefaultResopnseBean<Object> delete(@RequestParam("Id") Long Id) {
		return zxFileManagerABService.delete(Id);
	}
	
    /**
     * 批量删除
     */
    @RequestMapping("/sys/delete")
    public R delete(@RequestBody Long[] fileIds){
        zxFileManagerABService.deleteAll(fileIds);
        return R.ok();
    }

	/**
	 * 
	 * @Title: dictionaryList
	 * @Description: 获取ab分类类目
	 */
	@RequestMapping(value = "/dictionary/list/{parentid}", method = RequestMethod.POST)
	public R dictionaryList(@PathVariable("parentid") String parentid) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentId", parentid);
		List<SysDictionary> list= zxFileManagerABService.dictionaryList(params);
		return R.ok().put("list", list);
	}
}
