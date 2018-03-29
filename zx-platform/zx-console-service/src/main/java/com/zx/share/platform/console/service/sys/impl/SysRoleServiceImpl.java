package com.zx.share.platform.console.service.sys.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zx.share.platform.bean.sys.SysRole;
import com.zx.share.platform.bean.sys.SysUser;
import com.zx.share.platform.console.mapper.sys.SysRoleMapper;
import com.zx.share.platform.console.service.sys.SysRoleService;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

@Service
public class SysRoleServiceImpl implements SysRoleService{
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	
	/**
	 * 单行查询
	 */

	@Override
	public SysRole selectRoleById(Long roleId) {
		return sysRoleMapper.selectByPrimaryKey(roleId);
	}
	/**
	 * 添加用户组
	 */

	@Override
	public Integer insertRoll(SysRole sysRole) {
		// TODO Auto-generated method stub
		return sysRoleMapper.insert(sysRole);
	}
	
	/**
	 * 修改数据
	 */
	@Override
	public Integer updateRole(SysRole sysRole) {
		// TODO Auto-generated method stub
		return sysRoleMapper.updateByPrimaryKey(sysRole);
	}
	/**
	 * 模糊查询
	 */

	@Override
	public List<SysRole> selectDim(String name, String perms, Date time1, Date time2) {
		// TODO Auto-generated method stub
		return sysRoleMapper.selectDim(name, perms, time1, time2);
	}
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@Override
	public DefaultResopnseBean<PageResponseBean<SysRole>> selectRoleAll(Map<String, Object> param) {
		Integer pageNum = param.get("page") != null ? Integer.parseInt(param.get("page").toString()) : 1;
		Integer pageSize = param.get("pageSize") != null ? Integer.parseInt(param.get("pageSize").toString()) : 10;
		PageHelper.startPage(pageNum, pageSize, true);
		List<SysRole> list = sysRoleMapper.selectAll();
		PageResponseBean<SysRole> data = new PageResponseBean<SysRole>();

		DefaultResopnseBean<PageResponseBean<SysRole>> resopnseBean = new DefaultResopnseBean<PageResponseBean<SysRole>>();
		PageInfo pageInfo = new PageInfo(list);
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
