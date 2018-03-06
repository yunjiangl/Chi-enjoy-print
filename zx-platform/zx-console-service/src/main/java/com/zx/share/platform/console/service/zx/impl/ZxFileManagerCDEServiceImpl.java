package com.zx.share.platform.console.service.zx.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zx.share.platform.console.mapper.zx.ZxFileManagerCDEMapper;
import com.zx.share.platform.console.service.zx.ZxFileManagerCDEService;

@Service
public class ZxFileManagerCDEServiceImpl implements ZxFileManagerCDEService {

	@Autowired
	private ZxFileManagerCDEMapper zxFileManagerCDEMapper;
}
