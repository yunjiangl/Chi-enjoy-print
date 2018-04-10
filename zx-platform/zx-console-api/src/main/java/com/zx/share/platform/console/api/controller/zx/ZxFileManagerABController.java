package com.zx.share.platform.console.api.controller.zx;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zx.share.platform.bean.sys.SysDictionary;
import com.zx.share.platform.bean.zx.ZxFileManagerAB;
import com.zx.share.platform.console.service.zx.ZxFileManagerABService;
import com.zx.share.platform.constants.DictionaryTypeEnum;
import com.zx.share.platform.util.annotation.ACSPermissions;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api("后台文件管理接口")
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
	@ApiOperation(value = "添加文件管理分类", notes = "添加文件管理分类")
	public DefaultResopnseBean<Object> add(
			@ApiParam("分类id") @RequestParam(name = "categoryId", required = true) Long categoryId,
			@ApiParam("摘要") @RequestParam(name = "abstracts", required = true) String abstracts,
			@ApiParam("上传的文件") @RequestParam(name = "multipartFile", required = true) MultipartFile multipartFile) {
		ZxFileManagerAB zxAB = new ZxFileManagerAB();
		zxAB.setAbstracts(abstracts);
		zxAB.setCategoryId(categoryId);
		System.out.println(categoryId);
		return zxFileManagerABService.add(zxAB, multipartFile);
	}

	/**
	 * 
	 * @Title: update
	 * @Description: 修改
	 */
	@RequestMapping(value = "update", consumes = "multipart/*", headers = "content-type=multipart/form-data", method = RequestMethod.POST)
	@ApiOperation(value = "修改文件管理分类", notes = "修改文件管理分类")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", dataType = "ZxFileManagerAB", name = "zxAB", value = "文件分类管理", required = true) })
	@ACSPermissions(permissions = "zx:ab:add")
	public DefaultResopnseBean<Object> update(@ApiParam("id") @RequestParam(name = "id", required = false) Long id) {
		return zxFileManagerABService.update(id);
	}

	/**
	 * 
	 * @Title: list
	 * @Description: 文件分类列表
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ApiOperation(value = "文件分类ab列表", notes = "文件分类ab列表")
	@ACSPermissions(permissions = "zx:ab:list")
	public DefaultResopnseBean<PageResponseBean<ZxFileManagerAB>> Alist(
			@ApiParam("第几页") @RequestParam(name = "pageNum", required = false) Integer pageNum,
			@ApiParam("每页多少条数据") @RequestParam(name = "pageSize", required = false) Integer pageSize,
			@ApiParam("文件分类编号") @RequestParam(name = "typeString", required = false) String typeString,
			@ApiParam("文件标题") @RequestParam(name = "fileName", required = false) String fileName,
			@ApiParam("一级类目") @RequestParam(name = "yijiName", required = false) String yijiName,
			@ApiParam("二级类目") @RequestParam(name = "erjiName", required = false) String erjiName,
			@ApiParam("三级类目") @RequestParam(name = "sanjiName", required = false) String sanjiName,
			@ApiParam("四级级类目") @RequestParam(name = "sjName", required = false) String sjName) {
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
	@ApiOperation(value = "删除文件", notes = "删除文件")
	@ACSPermissions(permissions = "zx:ab:delete")
	public DefaultResopnseBean<Object> delete(@RequestParam("Id") Long Id) {
		return zxFileManagerABService.delete(Id);
	}

	/**
	 * 
	 * @Title: dictionaryList
	 * @Description: 获取ab分类类目
	 */
	@RequestMapping(value = "/dictionary/list", method = RequestMethod.GET)
	@ApiOperation(value = "文件分类ab类目列表", notes = "文件分类ab类目列表")
	public DefaultResopnseBean<List<SysDictionary>> dictionaryList(
			@ApiParam("父级id") @RequestParam(name = "parentId", required = true) String parentId) {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("parentId", parentId);

		return zxFileManagerABService.dictionaryList(params);
	}
}
