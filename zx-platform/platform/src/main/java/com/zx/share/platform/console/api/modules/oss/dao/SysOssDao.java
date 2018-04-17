package com.zx.share.platform.console.api.modules.oss.dao;

import com.zx.share.platform.console.api.modules.oss.entity.SysOssEntity;
import com.zx.share.platform.console.api.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件上传
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2017-03-25 12:13:26
 */
@Mapper
public interface SysOssDao extends BaseDao<SysOssEntity> {
	
}
