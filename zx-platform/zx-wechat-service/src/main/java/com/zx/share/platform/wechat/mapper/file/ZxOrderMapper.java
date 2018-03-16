package com.zx.share.platform.wechat.mapper.file;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zx.share.platform.bean.zx.ZxOrder;
import com.zx.share.platform.bean.zx.ZxPrinterManager;
import com.zx.share.platform.common.mapper.PlatFormMapper;


@Repository
public interface ZxOrderMapper extends PlatFormMapper<ZxOrder> {


	/**
	 * 
	 * @Title: queryList
	 * @Description: 查询订单数据
	 */
	List<ZxOrder> queryList(Map<String, Object> params);
}
