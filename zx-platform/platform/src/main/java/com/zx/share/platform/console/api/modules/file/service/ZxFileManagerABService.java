package com.zx.share.platform.console.api.modules.file.service;

import java.util.List;
import java.util.Map;

import com.zx.share.platform.bean.sys.SysDictionary;
import com.zx.share.platform.bean.zx.ZxPrinterManager;
import org.springframework.web.multipart.MultipartFile;

import com.zx.share.platform.bean.zx.ZxFileManagerAB;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

public interface ZxFileManagerABService {

	List<ZxFileManagerAB> queryList(Map<String, Object> map);

	int queryTotal(Map<String, Object> map);

	void save(ZxFileManagerAB printer);

	void update(ZxFileManagerAB printer);

	void deleteBatch(Long[] printerIds);

	ZxFileManagerAB queryObject(Long id);

	List<SysDictionary> dictionaryList(Map<String, Object> params);

}
