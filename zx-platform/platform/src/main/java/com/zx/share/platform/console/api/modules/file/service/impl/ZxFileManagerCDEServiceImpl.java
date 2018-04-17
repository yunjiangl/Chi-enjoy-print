package com.zx.share.platform.console.api.modules.file.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zx.share.platform.bean.zx.ZxFileManagerCDE;
import com.zx.share.platform.console.api.modules.file.dao.ZxFileManagerCDEMapper;
import com.zx.share.platform.console.api.modules.file.service.ZxFileManagerCDEService;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

@Service
public class ZxFileManagerCDEServiceImpl implements ZxFileManagerCDEService {
	

	@Autowired
	private ZxFileManagerCDEMapper zxFileManagerCDEMapper;

	@Override
	public DefaultResopnseBean<PageResponseBean<ZxFileManagerCDE>> list(Map<String, Object> params) {
		Integer pageNum = params.get("pageNum") != null ? Integer.parseInt(params.get("pageNum").toString()) : 1;
		Integer pageSize = params.get("pageSize") != null ? Integer.parseInt(params.get("pageSize").toString()) : 10;
		PageHelper.startPage(pageNum, pageSize, true);
		List<ZxFileManagerCDE> list = zxFileManagerCDEMapper.queryList(params);
		PageInfo pageInfo = new PageInfo(list);
		PageResponseBean<ZxFileManagerCDE> data = new PageResponseBean<ZxFileManagerCDE>();
		data.setFirst(pageInfo.isIsFirstPage());
		data.setLast(pageInfo.isIsLastPage());
		data.setNumber(pageInfo.getPageNum());
		data.setNumberOfElements(pageInfo.getPageSize());
		data.setSize(pageInfo.getSize());
		data.setTotalPages(pageInfo.getPages());
		data.setTotalElements(pageInfo.getTotal());
		data.setContent(pageInfo.getList());
		return new DefaultResopnseBean<PageResponseBean<ZxFileManagerCDE>>(ErrorsEnum.SUCCESS.label,
				ErrorsEnum.SUCCESS.code, data);
	}
	

	
	@Override
	@Transactional
	public DefaultResopnseBean<Object> delete(Long ids) {
		zxFileManagerCDEMapper.delectList(ids);
		return new DefaultResopnseBean<Object>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, null);
	}

	@Override
	public DefaultResopnseBean<Object> show(Long id) {
		zxFileManagerCDEMapper.selectByPrimaryKey(id);
		return new DefaultResopnseBean<Object>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, null);
	}
}
