package com.zx.share.platform.console.api.modules.file.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.zx.share.platform.bean.sys.SysDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zx.share.platform.bean.zx.ZxFileManagerAB;
import com.zx.share.platform.console.api.modules.file.dao.ZxFileManagerABMapper;
import com.zx.share.platform.console.api.modules.file.service.UploadService;
import com.zx.share.platform.console.api.modules.file.service.ZxFileManagerABService;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

@Service
public class ZxFileManagerABServiceImpl implements ZxFileManagerABService {

	@Autowired
	private ZxFileManagerABMapper zxFileManagerABMapper;
	
	@Autowired
	private UploadService uploadService;

	@Transactional
	@Override
	public DefaultResopnseBean<Object> add(ZxFileManagerAB zxAB, MultipartFile multipartFile) {
		zxAB.setCreateTime(new Date());
		uploadService.add(zxAB, multipartFile);
		return new DefaultResopnseBean<Object>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, null);
	}

	/**
	 * 列表查询
	 */
	@Override
	public DefaultResopnseBean<PageResponseBean<ZxFileManagerAB>> list(Map<String, Object> params) {
		Integer pageNum = params.get("pageNum") != null ? Integer.parseInt(params.get("pageNum").toString()) : 1;
		Integer pageSize = params.get("pageSize") != null ? Integer.parseInt(params.get("pageSize").toString()) : 10;
		PageHelper.startPage(pageNum, pageSize, true);
		List<ZxFileManagerAB> list = zxFileManagerABMapper.queryList(params);
		PageInfo pageInfo = new PageInfo(list);
		PageResponseBean<ZxFileManagerAB> data = new PageResponseBean<ZxFileManagerAB>();
		data.setFirst(pageInfo.isIsFirstPage());
		data.setLast(pageInfo.isIsLastPage());
		data.setNumber(pageInfo.getPageNum());
		data.setNumberOfElements(pageInfo.getPageSize());
		data.setSize(pageInfo.getSize());
		data.setTotalPages(pageInfo.getPages());
		data.setTotalElements(pageInfo.getTotal());
		data.setContent(pageInfo.getList());
		return new DefaultResopnseBean<PageResponseBean<ZxFileManagerAB>>(ErrorsEnum.SUCCESS.label,
				ErrorsEnum.SUCCESS.code, data);
	}

	/**
	 * 模糊查询a文件
	 * 
	 * @param params
	 * @return
	 */
	@Override
	public DefaultResopnseBean<PageResponseBean<ZxFileManagerAB>> vagueList(Map<String, Object> params) {
		Integer pageNum = params.get("pageNum") != null ? Integer.parseInt(params.get("pageNum").toString()) : 1;
		Integer pageSize = params.get("pageSize") != null ? Integer.parseInt(params.get("pageSize").toString()) : 10;
		PageHelper.startPage(pageNum, pageSize, true);
		List<ZxFileManagerAB> list = zxFileManagerABMapper.vagueList(params);
		PageInfo pageInfo = new PageInfo(list);
		PageResponseBean<ZxFileManagerAB> data = new PageResponseBean<ZxFileManagerAB>();
		data.setFirst(pageInfo.isIsFirstPage());
		data.setLast(pageInfo.isIsLastPage());
		data.setNumber(pageInfo.getPageNum());
		data.setNumberOfElements(pageInfo.getPageSize());
		data.setSize(pageInfo.getSize());
		data.setTotalPages(pageInfo.getPages());
		data.setTotalElements(pageInfo.getTotal());
		data.setContent(pageInfo.getList());
		return new DefaultResopnseBean<PageResponseBean<ZxFileManagerAB>>(ErrorsEnum.SUCCESS.label,
				ErrorsEnum.SUCCESS.code, data);
	}

	@Transactional
	@Override
	public DefaultResopnseBean<Object> delete(Long id) {
		zxFileManagerABMapper.deleteByPrimaryKey(id);
		return new DefaultResopnseBean<Object>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, null);
	}

	@Transactional
	@Override
	public DefaultResopnseBean<Object> update(long id) {
		ZxFileManagerAB zxFileManagerAB = zxFileManagerABMapper.selectByPrimaryKey(id);
		zxFileManagerABMapper.updateByPrimaryKey(zxFileManagerAB);
		return new DefaultResopnseBean<Object>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, null);
	}

	@Override
	public DefaultResopnseBean<List<SysDictionary>> dictionaryList(Map<String, Object> params) {
		List<SysDictionary> data = zxFileManagerABMapper.dictionaryList(params);
		return new DefaultResopnseBean<List<SysDictionary>>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, data);
	}
}
