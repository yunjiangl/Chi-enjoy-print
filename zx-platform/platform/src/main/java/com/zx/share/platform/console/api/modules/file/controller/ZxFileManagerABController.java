package com.zx.share.platform.console.api.modules.file.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zx.share.platform.bean.sys.SysDictionary;
import com.zx.share.platform.bean.sys.SysMenuEntity;
import com.zx.share.platform.console.api.common.utils.PageUtils;
import com.zx.share.platform.console.api.common.utils.Query;
import com.zx.share.platform.console.api.modules.sys.controller.AbstractController;
import com.zx.share.platform.console.api.modules.sys.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
public class ZxFileManagerABController  extends AbstractController {

	@Autowired
	private ZxFileManagerABService zxFileManagerABService;
	@Autowired
	private SysConfigService sysConfigService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		query.isPaging(true);
		List<ZxFileManagerAB> printerList = zxFileManagerABService.queryList(query);
		int total = zxFileManagerABService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(printerList, total, query.getLimit(), query.getPage());
		return R.ok().put("page", pageUtil);
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{fileId}")
	public R info(@PathVariable("fileId") Long fileId){
		ZxFileManagerAB file = zxFileManagerABService.queryObject(fileId);
		SysDictionary dictionary = sysConfigService.queryObject(file.getCategoryId());
		if(dictionary!=null){
			return R.ok().put("bean", file).put("categoryName",dictionary.getName());
		}
		return R.ok().put("bean", file);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody ZxFileManagerAB file){
		file.setCreateId(getUserId());
		file.setCreateTime(new Date());
		zxFileManagerABService.save(file);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody ZxFileManagerAB file){
		file.setUpdateId(getUserId());
		file.setUpdateTime(new Date());
		zxFileManagerABService.update(file);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] printerIds){
		zxFileManagerABService.deleteBatch(printerIds);

		return R.ok();
	}

	/**
	 * 
	 * @Title: dictionaryList
	 * @Description: 获取ab分类类目
	 */
	@RequestMapping(value = "/dictionary/list/{type}", method = RequestMethod.GET)
	@ResponseBody
	public R dictionaryList(@PathVariable("type") String type) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("type", type);
		List<SysDictionary> list= zxFileManagerABService.dictionaryList(params);

		//添加顶级菜单
		SysDictionary root = new SysDictionary();
		root.setId(0L);
		root.setName("顶级");
		root.setParentId(-1L);
		list.add(root);
		return R.ok().put("list", list);
	}
}
