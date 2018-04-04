package com.zx.share.platform.console.mapper.zx;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zx.share.platform.bean.sys.SysUser;
import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.common.mapper.PlatFormMapper;

@Repository
public interface ZxUserMapper extends PlatFormMapper<ZxUser>{
	
	
	/**
	 * 设备管理添加线上管理员遍历
	 */
	List<ZxUser> selectOnlineAdmin();
	/**
	 * 设备列表添加线上管理员查看功能 
	 */
	ZxUser selectOnlineAdminById(@Param("id") Long id);
	/**
	 * 设备管理线上管理员遍历
	 */
	List<ZxUser> selectAdminByPage(Map<String, Object> params);
	/**
	 * 设备管理线上管理员查看接口
	 */
	ZxUser selectZxAdminById(@Param("id")Long id);
	/**
	 * 查询出全部未删除的律师用户管理数据
	 * 
	 * @return
	 */
	List<SysUser> selectLawyerUserAll();

}
