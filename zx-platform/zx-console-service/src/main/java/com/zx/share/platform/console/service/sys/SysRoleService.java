package com.zx.share.platform.console.service.sys;

import java.util.List;

import com.zx.share.platform.bean.sys.SysRole;

public interface SysRoleService {
	
	/**
	 * 查询全部数据
	 * @return
	 */
	List<SysRole> selectRoleAll();
}
