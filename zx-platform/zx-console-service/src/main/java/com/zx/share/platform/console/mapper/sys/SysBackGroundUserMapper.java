package com.zx.share.platform.console.mapper.sys;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zx.share.platform.bean.sys.SysRole;
import com.zx.share.platform.bean.sys.SysUser;
import com.zx.share.platform.common.mapper.PlatFormMapper;

@Repository
public interface SysBackGroundUserMapper extends PlatFormMapper<SysUser> {

	/**
	 * 查询出全部未删除的后台用户管理数据
	 * 
	 * @return
	 */
	List<SysUser> selectUserAll(Long roleId);

	/**
	 * 修改后台用户管理数据
	 */
	Integer updateUserById(Map<String, Object> params);
	
	/**
	 * 刪除后台用户管理数据
	 */
	Integer deleteUserById(Long userId);
	
	/**
	 * 模糊查詢
	 * @param roleName
	 * @param status
	 * @param time1
	 * @param time2
	 * @return
	 */
	List<SysUser> selectUserDim(@Param("name") String name,
							@Param("perms") String perms,
							@Param("time1") Date  time1,
							@Param("time2") Date time2);
}
