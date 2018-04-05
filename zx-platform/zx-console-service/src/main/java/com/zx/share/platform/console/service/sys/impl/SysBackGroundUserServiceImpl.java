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
import com.zx.share.platform.console.service.sys.SysBackGroundUserService;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

@Service
public class SysBackGroundUserServiceImpl implements SysBackGroundUserService {

	@Autowired
	private SysBackGroundUserMapper sysBackGroundUserMapper;

	/**
	 * 查询出全部未删除的后台用户管理数据
	 * 
	 * @return
	 */
	@Override
	public DefaultResopnseBean<PageResponseBean<SysUser>> selectUserAll(Long roleId,Map<String, Object> param) {
		Integer pageNum = param.get("page") != null ? Integer.parseInt(param.get("page").toString()) : 1;
		Integer pageSize = param.get("pageSize") != null ? Integer.parseInt(param.get("pageSize").toString()) : 10;
		PageHelper.startPage(pageNum, pageSize, true);
		List<SysUser> list = sysBackGroundUserMapper.selectUserAll(roleId);

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
	 * 修改后台用户管理数据
	 */
	@Override
	public Integer updateUserById(Long id, String userName, String realName, String password, String email, Boolean isLock,
			String comment, Long roleId) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		params.put("userName", userName);
		params.put("realName", realName);
		params.put("password", password);
		params.put("email", email);
		params.put("isLock", isLock);
		params.put("comment", comment);
		params.put("roleId", roleId);
		return sysBackGroundUserMapper.updateUserById(params);
	}
	
	/**
	 * 刪除后台用户管理数据
	 */
	@Override
	public Integer deleteUserById(Long userId) {
		// TODO Auto-generated method stub
		return sysBackGroundUserMapper.deleteUserById(userId);
	}
	/**
	 * 模糊查询
	 */

	@Override
	public List<SysUser> selectUserDim(String name, Boolean isLock, Date time1, Date time2) {
		// TODO Auto-generated method stub
		return sysBackGroundUserMapper.selectUserDim(name, isLock, time1, time2);
	}
	/**
	 * 后台用户管理增添用户
	 */
	@Override
	public Integer insertUsers(String userName, String realName, String password, String email, Boolean isLock,
			String comment) {
		// TODO Auto-generated method stub
		return sysBackGroundUserMapper.insertUsers(userName, realName, password, email, isLock, comment);
	}
	
	/**
	 * 单行查询
	 */
	@Override
	public SysUser Select(String userName) {
		// TODO Auto-generated method stub
		return sysBackGroundUserMapper.Select(userName);
	}
	
	
	

}
