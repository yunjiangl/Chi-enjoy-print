package com.zx.share.platform.console.mapper.sys;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zx.share.platform.common.mapper.PlatFormMapper;

@Repository
public interface SysOwnerUserMapper extends PlatFormMapper<SysUser> {

	/**
	 * 查询出全部未删除的物主用户管理数据
	 * 
	 * @return
	 */
	List<SysUser> selectOwnerUserAll(Long roleId);

	/**
	 * 禁用物主数据
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
	Integer updateOwnerUserById(Map<String, Object> params);
	
	/**
	 * 物主端修改密码邮箱
	 */
	Integer updateOwerById(@Param("username") String username,
						   @Param("password") String password,
						   @Param("email") String email);
	/**
	 * 添加物主端收款信息
	 */
	Integer updateBank(@Param("openingBank") String openingBank,
					   @Param("province") String province,
					   @Param("city") String city,
					   @Param("region") String region,
					   @Param("accountNumber") String accountNumber,
					   @Param("accountName") String accountName,
					   @Param("userName") String userName);
	/**
	 * 查询全部设备列表
	 */
	List<SysUser> selectOwerList();
	/**
	 * 查询设备列表单行
	 */
	SysUser selectOwerByCode(@Param("printerCode") String printerCode);
}
