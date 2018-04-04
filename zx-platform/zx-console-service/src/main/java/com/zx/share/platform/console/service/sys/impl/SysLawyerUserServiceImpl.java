package com.zx.share.platform.console.service.sys.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.console.mapper.zx.ZxUserMapper;
import com.zx.share.platform.console.service.sys.SysLawyerUserService;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

@Service
public class SysLawyerUserServiceImpl implements SysLawyerUserService {

	@Autowired
	private ZxUserMapper zxUserMapper;

	@Override
	public DefaultResopnseBean<Object> update(ZxUser zxUser) {
		zxUser.setUpdateTime(new Date());
		zxUserMapper.updateByPrimaryKeySelective(zxUser);
		return new DefaultResopnseBean<Object>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, null);
	}

	@Override
	public DefaultResopnseBean<PageResponseBean<ZxUser>> list(Map<String, Object> params) {
		Integer pageNum = params.get("pageNum") != null ? Integer.parseInt(params.get("pageNum").toString()) : 1;
		Integer pageSize = params.get("pageSize") != null ? Integer.parseInt(params.get("pageSize").toString()) : 10;
		PageHelper.startPage(pageNum, pageSize, true);
		List<ZxUser> list = zxUserMapper.queryList(params);

		PageInfo pageInfo = new PageInfo(list);

		PageResponseBean<ZxUser> data = new PageResponseBean<ZxUser>();

		data.setFirst(pageInfo.isIsFirstPage());
		data.setLast(pageInfo.isIsLastPage());
		data.setNumber(pageInfo.getPageNum());
		data.setNumberOfElements(pageInfo.getPageSize());
		data.setSize(pageInfo.getSize());
		data.setTotalPages(pageInfo.getPages());
		data.setTotalElements(pageInfo.getTotal());
		data.setContent(pageInfo.getList());

		return new DefaultResopnseBean<PageResponseBean<ZxUser>>(ErrorsEnum.SUCCESS.label,
				ErrorsEnum.SUCCESS.code, data);
	}
	/**
	 * 查询律师审核数据
	 */
	@Override
	public DefaultResopnseBean<Object> queryByZxPMId(Long id) {
		ZxUser zxUser=zxUserMapper.queryByZxPMId(id);
		return new DefaultResopnseBean<Object>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, zxUser);
	}
	
}
