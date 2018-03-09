package com.zx.share.platform.console.service.zx.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zx.share.platform.bean.zx.ZxFileManagerAB;
import com.zx.share.platform.console.mapper.zx.ZxFileManagerABMapper;
import com.zx.share.platform.console.service.zx.ZxFileManagerABService;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.response.DefaultResopnseBean;


@Service
public class ZxFileManagerABServiceImpl implements ZxFileManagerABService{

	@Autowired
	private ZxFileManagerABMapper zxFileManagerABMapper;

	@Override
	public DefaultResopnseBean<Object> add(ZxFileManagerAB zxAB) {
		zxAB.setCreateTime(new Date());
		zxFileManagerABMapper.insert(zxAB);
		return new DefaultResopnseBean<Object>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, null);
	}
}
