package com.zx.share.platform.console.service.zx.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zx.share.platform.console.mapper.zx.ZxFileManagerABMapper;
import com.zx.share.platform.console.service.zx.ZxFileManagerABService;


@Service
public class ZxFileManagerABServiceImpl implements ZxFileManagerABService{

	@Autowired
	private ZxFileManagerABMapper zxFileManagerABMapper;
}
