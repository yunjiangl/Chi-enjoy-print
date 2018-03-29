package com.zx.share.platform.console.service.zx.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.bean.zx.ZxUserPrinter;
import com.zx.share.platform.console.mapper.zx.ZxUserMapper;
import com.zx.share.platform.console.mapper.zx.ZxUserPrinterMapper;
import com.zx.share.platform.console.service.zx.ZxUserMapperService;
import com.zx.share.platform.console.service.zx.ZxUserPrinterService;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.response.DefaultResopnseBean;


@Service
public class ZxUserMapperServiceImpl implements ZxUserMapperService {

	@Autowired
	private ZxUserMapper zxUserMapper;
	
	/**
	 * 设备管理添加线上管理员遍历
	 */
	@Override
	public List<ZxUser> selectOnlineAdmin() {
		// TODO Auto-generated method stub
		return zxUserMapper.selectOnlineAdmin();
	}
	
	/**
	 * 设备列表添加线上管理员查看功能 
	 */
	@Override
	public ZxUser selectOnlineAdminById(Long id) {
		// TODO Auto-generated method stub
		return zxUserMapper.selectOnlineAdminById(id);
	}
	/**
	 * 设备管理线上管理员遍历分页
	 */
	@Override
	public DefaultResopnseBean<PageResponseBean<ZxUser>> selectAdminByPage(Map<String, Object> params) {
		Integer pageNum = params.get("pageNum") != null ? Integer.parseInt(params.get("pageNum").toString()) : 1;
		Integer pageSize = params.get("pageSize") != null ? Integer.parseInt(params.get("pageSize").toString()) : 10;
		PageHelper.startPage(pageNum, pageSize, true);
		List<ZxUser> list = zxUserMapper.selectAdminByPage(params);

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
	 * 设备管理线上管理员查看接口
	 */
	@Override
	public ZxUser selectZxAdminById(Long id) {
		// TODO Auto-generated method stub
		return zxUserMapper.selectZxAdminById(id);
	}
	


	

}
