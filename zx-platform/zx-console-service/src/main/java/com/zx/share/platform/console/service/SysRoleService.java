package com.zx.share.platform.console.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zx.share.platform.wechat.model.SysRole;
/**
 * 
 * @ClassName:  SysRoleService   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 郭晓朋 
 * @date:   2018年1月19日 上午9:35:46   
 *     
 * @Copyright: 2018 
 *
 */
public interface SysRoleService {
	/**
	 * 查询用户组所以数据
	 */
	List<SysRole> selectRoleAll();

	/**
	 * 单行查询
	 */
	SysRole selectRoleById(Long roleId);
	/**
	 * 添加用户组
	 */
	Integer insertRoll(SysRole sysRole);
	/**
	 * 修改数据
	 */
	Integer updateRole(SysRole sysRole);
	/**
	 * 模糊查询
	 */
	List<SysRole> selectDim(@Param("roleName") String roleName,
                            @Param("status") Byte status,
                            @Param("time1") String time1,
                            @Param("time2") String time2);
}
