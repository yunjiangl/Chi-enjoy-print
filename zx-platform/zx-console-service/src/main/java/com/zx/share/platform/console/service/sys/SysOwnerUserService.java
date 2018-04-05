package com.zx.share.platform.console.service.sys;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zx.share.platform.bean.sys.SysUser;

public interface SysOwnerUserService {
	
	/**
	 * 查询出全部未删除的前台用户管理数据
	 * @return
	 */
	List<SysUser> selectOwnerUserAll(Long roleId);
	
	/**
	 * 禁用前台数据
	 */
	Integer updateOwnerUser(Long userId);
	
	/**
	 * 模糊查询
	 */
	List<SysUser> selectOwnerUserDim(@Param("name") String name,
										@Param("isLock") Boolean isLock,
										@Param("time1") Date  time1,
										@Param("time2") Date time2);
	/**
	 * 修改物主用户管理数据
	 */
	Integer updateOwnerUserById(Long id,String userName,String salt,String password,String email,Boolean isLock,String comment,Long roleId);
	
	/**
	 * 物主端修改密码邮箱
	 */
	Integer updateOwerById(String username,String password, String email);
	
	/**
	 * 添加物主端收款信息
	 */
	Integer updateBank(String openingBank,String province,String city,String region,String accountNumber,String accountName,String userName);
	
	/**
	 * 查询全部设备列表
	 */
	List<SysUser> selectOwerList();
	
	/**
	 * 设备列表禁用功能
	 */
	Integer updateOwenByCode(String printerCode);
	
	/**
	 * 查询设备列表单行
	 */
	SysUser selectOwerByCode(String printerCode);
}
