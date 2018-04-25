package com.zx.share.platform.console.api.modules.file.dao;

import java.util.List;
import java.util.Map;

import com.zx.share.platform.bean.sys.SysDictionary;
import com.zx.share.platform.bean.zx.ZxPrinterManager;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.zx.share.platform.bean.zx.ZxFileManagerAB;
import com.zx.share.platform.common.mapper.PlatFormMapper;
import com.zx.share.platform.console.api.modules.sys.dao.BaseDao;

@Repository
@Mapper
public interface ZxFileManagerABMapper extends BaseDao<ZxFileManagerAB> {

	List<SysDictionary> dictionaryList(Map<String, Object> params);
}
