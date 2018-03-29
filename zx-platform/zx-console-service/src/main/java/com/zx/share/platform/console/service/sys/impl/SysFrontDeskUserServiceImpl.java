package com.zx.share.platform.console.service.sys.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zx.share.platform.bean.sys.SysRole;
import com.zx.share.platform.bean.sys.SysUser;
import com.zx.share.platform.console.mapper.sys.SysBackGroundUserMapper;
import com.zx.share.platform.console.mapper.sys.SysFrontDeskUserMapper;
import com.zx.share.platform.console.service.sys.SysBackGroundUserService;
import com.zx.share.platform.console.service.sys.SysFrontDeskUserService;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

@Service
public class SysFrontDeskUserServiceImpl implements SysFrontDeskUserService {

	@Autowired
	private SysFrontDeskUserMapper sysFrontDeskUserMapper;

	/**
	 * 查询出全部未删除的前台用户管理数据
	 * 
	 * @return
	 */
	@Override
	public DefaultResopnseBean<PageResponseBean<SysUser>> selectFrontDeskUserAll(Long roleId,
			Map<String, Object> param) {
		Integer pageNum = param.get("page") != null ? Integer.parseInt(param.get("page").toString()) : 1;
		Integer pageSize = param.get("pageSize") != null ? Integer.parseInt(param.get("pageSize").toString()) : 10;
		PageHelper.startPage(pageNum, pageSize, true);
		List<SysUser> list = sysFrontDeskUserMapper.selectFrontDeskUserAll(roleId);

		PageInfo pageInfo = new PageInfo(list);

		PageResponseBean<SysUser> data = new PageResponseBean<SysUser>();

		DefaultResopnseBean<PageResponseBean<SysUser>> resopnseBean = new DefaultResopnseBean<PageResponseBean<SysUser>>();

		data.setFirst(pageInfo.isIsFirstPage());
		data.setLast(pageInfo.isIsLastPage());
		data.setNumber(pageInfo.getPageNum());
		data.setNumberOfElements(pageInfo.getPageSize());
		data.setSize(pageInfo.getSize());
		data.setTotalPages(pageInfo.getPages());
		data.setTotalElements(pageInfo.getTotal());
		data.setContent(pageInfo.getList());

		resopnseBean.setData(data);
		resopnseBean.setCode(ErrorsEnum.SUCCESS.code);
		resopnseBean.setMessage(ErrorsEnum.SUCCESS.label);

		return resopnseBean;

	}

	/**
	 * 禁用前台数据
	 */
	@Override
	public Integer updateFrontDeskUser(Long userId) {
		// TODO Auto-generated method stub
		return sysFrontDeskUserMapper.updateFrontDeskUser(userId);
	}
	
	/**
	 * 模糊查询
	 */

	@Override
	public DefaultResopnseBean<PageResponseBean<SysUser>> selectFrontDeskUserDim(String name, String perms, Date time1, Date time2,
			Map<String, Object> param) {
		Integer pageNum = param.get("page") != null ? Integer.parseInt(param.get("page").toString()) : 1;
		Integer pageSize = param.get("pageSize") != null ? Integer.parseInt(param.get("pageSize").toString()) : 10;
		PageHelper.startPage(pageNum, pageSize, true);
		
		List<SysUser> list =sysFrontDeskUserMapper.selectFrontDeskUserDim(name, perms, time1, time2);
		
		PageInfo pageInfo = new PageInfo(list);

		PageResponseBean<SysUser> data = new PageResponseBean<SysUser>();

		DefaultResopnseBean<PageResponseBean<SysUser>> resopnseBean = new DefaultResopnseBean<PageResponseBean<SysUser>>();

		data.setFirst(pageInfo.isIsFirstPage());
		data.setLast(pageInfo.isIsLastPage());
		data.setNumber(pageInfo.getPageNum());
		data.setNumberOfElements(pageInfo.getPageSize());
		data.setSize(pageInfo.getSize());
		data.setTotalPages(pageInfo.getPages());
		data.setTotalElements(pageInfo.getTotal());
		data.setContent(pageInfo.getList());

		resopnseBean.setData(data);
		resopnseBean.setCode(ErrorsEnum.SUCCESS.code);
		resopnseBean.setMessage(ErrorsEnum.SUCCESS.label);
		return resopnseBean;
	}

}
