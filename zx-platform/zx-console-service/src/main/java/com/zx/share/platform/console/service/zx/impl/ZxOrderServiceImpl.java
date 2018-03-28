package com.zx.share.platform.console.service.zx.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zx.share.platform.bean.zx.ZxOrder;
import com.zx.share.platform.console.mapper.zx.ZxOrderMapper;
import com.zx.share.platform.console.service.zx.ZxOrderService;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

/**
 * 
 * @ClassName: ZxOrderServiceImpl
 * @author: 刘芸江
 * @date: 2018年3月27日 下午3:59:02
 */
@Service
public class ZxOrderServiceImpl implements ZxOrderService {

	@Autowired
	private ZxOrderMapper zxOrderMapper;

	@Override
	public DefaultResopnseBean<PageResponseBean<ZxOrder>> list(Map<String, Object> param) {
		Integer pageNum = param.get("page") != null ? Integer.parseInt(param.get("page").toString()) : 1;
		Integer pageSize = param.get("pageSize") != null ? Integer.parseInt(param.get("pageSize").toString()) : 10;
		PageHelper.startPage(pageNum, pageSize, true);
		List<ZxOrder> list = zxOrderMapper.queryList(param);

		PageInfo pageInfo = new PageInfo(list);

		PageResponseBean<ZxOrder> data = new PageResponseBean<ZxOrder>();

		data.setFirst(pageInfo.isIsFirstPage());
		data.setLast(pageInfo.isIsLastPage());
		data.setNumber(pageInfo.getPageNum());
		data.setNumberOfElements(pageInfo.getPageSize());
		data.setSize(pageInfo.getSize());
		data.setTotalPages(pageInfo.getPages());
		data.setTotalElements(pageInfo.getTotal());
		data.setContent(pageInfo.getList());

		DefaultResopnseBean<PageResponseBean<ZxOrder>> resopnseBean = new DefaultResopnseBean<PageResponseBean<ZxOrder>>();

		resopnseBean.setData(data);
		resopnseBean.setCode(ErrorsEnum.SUCCESS.code);
		resopnseBean.setMessage(ErrorsEnum.SUCCESS.label);

		return resopnseBean;
	}

	@Override
	public ZxOrder orderInfo(Long id) {
		return zxOrderMapper.queryByOrderId(id);
	}

}
