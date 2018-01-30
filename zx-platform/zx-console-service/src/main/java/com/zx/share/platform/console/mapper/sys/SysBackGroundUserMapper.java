package com.zx.share.platform.console.mapper.sys;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zx.share.platform.bean.sys.SysUser;
import com.zx.share.platform.common.mapper.PlatFormMapper;

@Repository
public interface SysBackGroundUserMapper extends PlatFormMapper<SysUser>{
	
	/**
	 * 查询出全部未删除的后台用户管理数据
	 * @return
	 */
	List<SysUser> selectUserAll(Long roleId);
}
