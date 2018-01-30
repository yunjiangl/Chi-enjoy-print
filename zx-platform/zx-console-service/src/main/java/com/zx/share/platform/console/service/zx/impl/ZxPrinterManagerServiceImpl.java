package com.zx.share.platform.console.service.zx.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zx.share.platform.bean.zx.ZxPrinterManager;
import com.zx.share.platform.console.mapper.zx.ZxPrinterManagerMapper;
import com.zx.share.platform.console.service.zx.ZxPrinterManagerService;
import com.zx.share.platform.constants.ErrorsEnum;

/**
 * 
 * @ClassName: ZxPrinterManagerServiceImpl
 * @Description: 设备业务实现类
 * @author 芸江
 * @date 2018年1月30日 上午10:49:33
 *
 */
@Service
public class ZxPrinterManagerServiceImpl implements ZxPrinterManagerService {

	@Autowired
	private ZxPrinterManagerMapper zxPrinterManagerMapper;

	@Transactional
	@Override
	public Map<String, Object> add(ZxPrinterManager zxPM) {
		zxPM.setCreateTime(new Date());
		zxPrinterManagerMapper.insert(zxPM);
		Map<String, Object> map = new HashMap<>();
		map.put("code", ErrorsEnum.SUCCESS.code);
		map.put("label", ErrorsEnum.SUCCESS.label);
		return map;
	}

	@Override
	public PageInfo list(Map<String, Object> params) {

		Integer pageNum = params.get("pageNum") != null ? Integer.parseInt(params.get("pageNum").toString()) : 1;
		Integer pageSize = params.get("pageSize") != null ? Integer.parseInt(params.get("pageSize").toString()) : 10;
		PageHelper.startPage(pageNum, pageSize, true);
		List<ZxPrinterManager> list = zxPrinterManagerMapper.queryList(params);
		PageInfo pageInfo = new PageInfo(list);
		return pageInfo;

	}

}
