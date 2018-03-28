package com.zx.share.platform.console.service.zx.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zx.share.platform.bean.zx.ZxFileManagerAB;
import com.zx.share.platform.console.mapper.zx.ZxFileManagerABMapper;
import com.zx.share.platform.console.service.zx.ZxFileManagerABService;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

@Service
public class ZxFileManagerABServiceImpl implements ZxFileManagerABService {

	@Autowired
	private ZxFileManagerABMapper zxFileManagerABMapper;

	@Override
	public DefaultResopnseBean<Object> add(ZxFileManagerAB zxAB) {
		zxAB.setCreateTime(new Date());
		zxFileManagerABMapper.insert(zxAB);
		return new DefaultResopnseBean<Object>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, null);
	}

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

	@Override
	public DefaultResopnseBean<Object> delete(Long id) {

		zxFileManagerABMapper.deleteByPrimaryKey(id);
		return new DefaultResopnseBean<Object>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, null);
	}
}
