package com.zx.share.platform.wechat.mapper.file;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zx.share.platform.bean.zx.ZxFileManagerCDE;
import com.zx.share.platform.common.mapper.PlatFormMapper;

@Repository
public interface CDEFileMapper extends PlatFormMapper<ZxFileManagerCDE> {

	List<ZxFileManagerCDE> queryList(ZxFileManagerCDE file);

}
