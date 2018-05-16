package com.zx.share.platform.wechat.mapper;

import com.zx.share.platform.bean.sys.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 系统用户
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2016年9月18日 上午9:34:11
 */
@Repository
public interface SysUserDao{

	/**
	 * 根据用户id，查询系统用户
	 */
	SysUser queryByUserId(Long userId);

}
