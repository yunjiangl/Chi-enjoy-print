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
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

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
	public DefaultResopnseBean<Object> add(ZxPrinterManager zxPM) {
		// 这里设置物主id
		//zxPM.setCreateId(createId);
		zxPM.setCreateTime(new Date());
		zxPM.setStatus(false);
		zxPrinterManagerMapper.insert(zxPM);

		return new DefaultResopnseBean<Object>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, null);
	}

	@Override
	public DefaultResopnseBean<PageResponseBean<ZxPrinterManager>> list(Map<String, Object> params) {

		Integer pageNum = params.get("pageNum") != null ? Integer.parseInt(params.get("pageNum").toString()) : 1;
		Integer pageSize = params.get("pageSize") != null ? Integer.parseInt(params.get("pageSize").toString()) : 10;
		PageHelper.startPage(pageNum, pageSize, true);
		List<ZxPrinterManager> list = zxPrinterManagerMapper.queryList(params);

		PageInfo pageInfo = new PageInfo(list);

		PageResponseBean<ZxPrinterManager> data = new PageResponseBean<ZxPrinterManager>();

		data.setFirst(pageInfo.isIsFirstPage());
		data.setLast(pageInfo.isIsLastPage());
		data.setNumber(pageInfo.getPageNum());
		data.setNumberOfElements(pageInfo.getPageSize());
		data.setSize(pageInfo.getSize());
		data.setTotalPages(pageInfo.getPages());
		data.setTotalElements(pageInfo.getTotal());
		data.setContent(pageInfo.getList());

		return new DefaultResopnseBean<PageResponseBean<ZxPrinterManager>>(ErrorsEnum.SUCCESS.label,
				ErrorsEnum.SUCCESS.code, data);

	}

	@Override
	public DefaultResopnseBean<Object> queryByZxPMId(Long id) {
		Map<String, Object> params = new HashMap<>();
		params.put("zxPMId", id);

		ZxPrinterManager data = zxPrinterManagerMapper.queryList(params).get(0);

		return new DefaultResopnseBean<Object>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, data);
	}
	
	/**
	 * 
	 * @Title: update
	 * @Description: 修改设备
	 * @param zxPM
	 *            设备信息
	 * @param hostname
	 *            设备物主
	 */
	@Override
	public DefaultResopnseBean<Object> update(ZxPrinterManager zxPM) {
		zxPM.setUpdateTime(new Date());
		zxPrinterManagerMapper.updateByPrimaryKeySelective(zxPM);
		return new DefaultResopnseBean<Object>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, null);
	}

}
