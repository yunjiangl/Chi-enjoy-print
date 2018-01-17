package com.exqoo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exqoo.dao.SysRealmDao;
import com.exqoo.dao.SysUserDao;
import com.exqoo.entity.SysRealm;
import com.exqoo.entity.SysUser;
import com.exqoo.service.SysUserService;
/**
 * 
 * @ClassName:  SysUserServiceImpl   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 郭晓朋 
 * @date:   2018年1月16日 上午11:30:28   
 *     
 * @Copyright: 2018 
 *
 */
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysRealmDao sysRealmDao;

	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public Set<String> queryAllPerms(Long userId) {
		List<String> permsList;

		// 系统管理员，拥有最高权限
		if (userId == 1) {
			List<SysRealm> realmList = sysRealmDao.selectAll();
			permsList = new ArrayList<>(realmList.size());
			for (SysRealm realm : realmList) {
				permsList.add(realm.getPerms());
			}
		} else {
			permsList = sysRealmDao.getUserPermissions(userId);
		}

		// 用户权限列表
		Set<String> permsSet = new HashSet<String>();
		for (String perms : permsList) {
			if (StringUtils.isBlank(perms)) {
				continue;
			}
			permsSet.addAll(Arrays.asList(perms.trim().split(",")));
		}
		return permsSet;
	}

	@Override
	public SysUser queryByUserName(String username) {

		SysUser record = new SysUser();

		record.setUsername(username);

		return sysUserDao.select(record).get(0);
	}

	@Override
	public SysUser queryObject(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysUser> queryList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void save(SysUser user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(SysUser user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBatch(Long[] userIds) {
		// TODO Auto-generated method stub

	}

	@Transactional
	@Override
	public int updatePasswordAndEmail(Long userId, String password, String newPassword, String email) {

		SysUser user = sysUserDao.selectByPrimaryKey(userId);

		if (user.getPassword() != password) {
			return 0;
		}

		user.setPassword(newPassword);
		user.setEmail(email);

		return sysUserDao.updateByPrimaryKey(user);
	}
	/**
	 * 查询律师组数据
	 */

	@Override
	public List<SysUser> selectUserLawyerById(Long roleId) {
		// TODO Auto-generated method stub
		return sysUserDao.selectUserLawyerById(roleId);
	}
	/**
	 * 律师组禁用功能
	 */

	@Override
	public Integer updateLawyerUser(Long userId) {
		// TODO Auto-generated method stub
		return sysUserDao.updateLawyerUser(userId);
	}
	/**
	 * 通过昵称查找数据
	 */

	@Override
	public List<SysUser> selectNikeNameUser(String nikeName) {
		SysUser user = new SysUser();
		user.setNickname(nikeName);
		return sysUserDao.select(user);
	}
	
	
	

}
