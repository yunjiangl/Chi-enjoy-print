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

	@Override
	public List<ZxFileManagerAB> queryList(Map<String, Object> map) {
		return zxFileManagerABMapper.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return zxFileManagerABMapper.queryTotal(map);
	}

	@Override
	public void save(ZxFileManagerAB file) {
		zxFileManagerABMapper.save(file);
	}

	@Override
	public void update(ZxFileManagerAB file) {
		zxFileManagerABMapper.update(file);
	}

	@Override
	public void deleteBatch(Long[] fileIds) {
		zxFileManagerABMapper.deleteBatch(fileIds);
	}

	@Override
	public ZxFileManagerAB queryObject(Long id) {
		return zxFileManagerABMapper.queryObject(id);
	}

	@Override
	public List<SysDictionary> dictionaryList(Map<String, Object> params) {
		return zxFileManagerABMapper.dictionaryList(params);
	}
}
