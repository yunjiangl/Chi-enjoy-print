package com.exqoo.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.exqoo.entity.SysUser;

/**
 * 
 * @ClassName:  SysUserService   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 郭晓朋 
 * @date:   2018年1月16日 上午11:30:40   
 *     
 * @Copyright: 2018 
 *
 */
public interface SysUserService {

	/**
	 * 查询用户的所有权限
	 * 
	 * @param userId
	 *            用户ID
	 */
	Set<String> queryAllPerms(Long userId);

	/**
	 * 根据用户名，查询系统用户
	 */
	SysUser queryByUserName(String username);

	/**
	 * 根据用户ID，查询用户
	 * 
	 * @param userId
	 * @return
	 */
	SysUser queryObject(Long userId);

	/**
	 * 查询用户列表
	 */
	List<SysUser> queryList(Map<String, Object> map);

	/**
	 * 查询总数
	 */
	int queryTotal(Map<String, Object> map);

	/**
	 * 保存用户
	 */
	void save(SysUser user);

	/**
	 * 修改用户
	 */
	void update(SysUser user);

	/**
	 * 删除用户
	 */
	void deleteBatch(Long[] userIds);

	/**
	 * 
	 * @Title: updatePasswordAndEmail
	 * @Description: 修改密码和邮箱
	 * @Param userId 用户id
	 * @Param password 原密码
	 * @Param newPassword 新密码
	 * @Param email 邮箱
	 */
	int updatePasswordAndEmail(Long userId, String password, String newPassword, String email);
	
	/**
	 * 查询律师组数据
	 */
	List<SysUser> selectUserLawyerById(Long roleId);
	/**
	 * 律师组禁用功能
	 */
	Integer updateLawyerUser(Long userId);
	/**
	 * 通过昵称查找数据
	 */
	List<SysUser> selectNikeNameUser(String nikeName);
	/**
	 * 单行查询后台数据
	 */
	SysUser selectUserById(Long userId);
	/**
	 * 后台数据修改
	 */
	Integer updateBackstage(SysUser sysUser);
}
