package com.zx.share.platform.console.service.sys.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zx.share.platform.console.mapper.sys.SysOwnerUserMapper;
import com.zx.share.platform.console.mapper.zx.ZxUserPrinterMapper;
import com.zx.share.platform.console.service.sys.SysOwnerUserService;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

@Service
public class SysOwnerUserServiceImpl implements SysOwnerUserService {

	@Autowired
	private SysOwnerUserMapper SysOwnerUserMapper;
	
	@Autowired
	private ZxUserPrinterMapper zxUserPrinterMapper;
	/**
	 * 查询出全部未删除的前台用户管理数据
	 * 
	 * @return
	 */
	@Override
	public DefaultResopnseBean<PageResponseBean<SysUser>> selectOwnerUserAll(Long roleId,Map<String, Object> param) {
		// TODO Auto-generated method stub
		Integer pageNum = param.get("page") != null ? Integer.parseInt(param.get("page").toString()) : 1;
		Integer pageSize = param.get("pageSize") != null ? Integer.parseInt(param.get("pageSize").toString()) : 10;
		PageHelper.startPage(pageNum, pageSize, true);
		List<SysUser> list = SysOwnerUserMapper.selectOwnerUserAll(roleId);

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
	public Integer updateOwnerUser(Long userId) {
		// TODO Auto-generated method stub
		return SysOwnerUserMapper.updateOwnerUser(userId);
	}
	/**
	 * 模糊查询
	 */

	@Override
	public List<SysUser> selectOwnerUserDim(String name, Boolean isLock, Date time1, Date time2) {
		// TODO Auto-generated method stub
		return SysOwnerUserMapper.selectOwnerUserDim(name, isLock, time1, time2);
	}
	
	/**
	 * 修改物主用户管理数据
	 */
	@Override
	public Integer updateOwnerUserById(Long id, String userName, String salt, String password, String email, Boolean isLock,
			String comment, Long roleId) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		params.put("userName", userName);
		params.put("salt", salt);
		params.put("password", password);
		params.put("email", email);
		params.put("isLock", isLock);
		params.put("comment", comment);
		params.put("roleId", roleId);
		return SysOwnerUserMapper.updateOwnerUserById(params);
	}
	
	/**
	 * 物主端修改密码邮箱
	 */
	@Override
	public Integer updateOwerById(String username, String password, String email) {
		// TODO Auto-generated method stub
		return SysOwnerUserMapper.updateOwerById(username, password, email);
	}
	
	/**
	 * 添加物主端收款信息
	 */
	@Override
	public Integer updateBank(String openingBank, String province, String city, String region, String accountNumber,
			String accountName,String userName) {
		// TODO Auto-generated method stub
		return SysOwnerUserMapper.updateBank(openingBank, province, city, region, accountNumber, accountName,userName);
	}
	
	/**
	 * 查询全部设备列表
	 */
	@Override
	public List<SysUser> selectOwerList() {
		// TODO Auto-generated method stub
		return SysOwnerUserMapper.selectOwerList();
	}
	
	/**
	 * 设备列表禁用功能
	 */
	@Override
	public Integer updateOwenByCode(String printerCode) {
		// TODO Auto-generated method stub
		return zxUserPrinterMapper.updateOwenByCode(printerCode);
	}
	
	/**
	 * 查询设备列表单行
	 */
	@Override
	public SysUser selectOwerByCode(String printerCode) {
		// TODO Auto-generated method stub
		return SysOwnerUserMapper.selectOwerByCode(printerCode);
	}
}
