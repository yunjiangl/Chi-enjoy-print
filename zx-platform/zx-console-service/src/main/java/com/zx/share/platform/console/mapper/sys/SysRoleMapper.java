package com.zx.share.platform.console.mapper.sys;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zx.share.platform.bean.sys.SysRole;
import com.zx.share.platform.common.mapper.PlatFormMapper;

@Repository
public interface SysRoleMapper extends PlatFormMapper<SysRole>{
	/**
	 * 模糊查詢
	 * @param roleName
	 * @param status
	 * @param time1
	 * @param time2
	 * @return
	 */
	List<SysRole> selectDim(@Param("roleName") String roleName,
							@Param("status") Byte status,
							@Param("time1") String  time1,
							@Param("time2") String time2);
}
