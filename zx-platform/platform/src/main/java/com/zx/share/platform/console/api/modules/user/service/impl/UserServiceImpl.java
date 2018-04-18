package com.zx.share.platform.console.api.modules.user.service.impl;

import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.bean.zx.ZxUserAttorney;
import com.zx.share.platform.bean.zx.ZxUserAttorneyDomain;
import com.zx.share.platform.console.api.common.exception.RRException;
import com.zx.share.platform.console.api.common.validator.Assert;
import com.zx.share.platform.console.api.modules.user.dao.SysUserLoginDao;
import com.zx.share.platform.console.api.modules.user.dao.UserAttorneyDao;
import com.zx.share.platform.console.api.modules.user.dao.UserAttorneyDomainDao;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.zx.share.platform.console.api.modules.user.dao.UserDao;
import com.zx.share.platform.console.api.modules.user.service.UserService;



@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserAttorneyDomainDao userAttorneyDomainDao;
	@Autowired
	private UserAttorneyDao userAttorneyDao;
	@Autowired
	private SysUserLoginDao sysUserLoginDao;
	
	@Override
	public ZxUser queryObject(Long userId){
		return userDao.queryObject(userId);
	}
	
	@Override
	public List<ZxUser> queryList(Map<String, Object> map){
		List<ZxUser> list = userDao.queryList(map);
		list.forEach(x->x.setUserLogin(sysUserLoginDao.queryUserType(x.getId(),2)));
		return list;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return userDao.queryTotal(map);
	}

	@Override
	public void save(ZxUser userEntity){
		userEntity.setPassword(DigestUtils.sha256Hex(userEntity.getPassword()));
		userEntity.setCreateTime(new Date());
		userDao.save(userEntity);
	}

	@Override
	public void save(String mobile, String password) {
		ZxUser userEntity = new ZxUser();
		userEntity.setMobile(mobile);
		userEntity.setPassword(password);
		userEntity.setPassword(DigestUtils.sha256Hex(userEntity.getPassword()));
		userEntity.setCreateTime(new Date());
		userDao.save(userEntity);
	}

	@Override
	public void update(ZxUser user){
		userDao.update(user);
	}
	
	@Override
	public void delete(Long userId){
		userDao.delete(userId);
	}
	
	@Override
	public void deleteBatch(Long[] userIds){
		userDao.deleteBatch(userIds);
	}

	@Override
	public void startUsing(Long[] userIds){
		userDao.startUsing(userIds);
	}

	@Override
	public ZxUser queryByMobile(String mobile) {
		return userDao.queryByMobile(mobile);
	}

	@Override
	public long login(String mobile, String password) {
		ZxUser user = queryByMobile(mobile);
		Assert.isNull(user, "用户不存在");

		//密码错误
		String userpassword = DigestUtils.sha256Hex(password);
		if(!user.getPassword().equals(userpassword)){
			throw new RRException("密码错误");
		}

		return user.getId();
	}

	@Override
	public List<String> domain(Long userId) {
		return userAttorneyDomainDao.queryDomainList(userId);
	}

	@Override
	public ZxUserAttorney attorney(Long userId) {
		return userAttorneyDao.queryObject(userId);
	}

	@Override
	public void check(ZxUser user) {
		userDao.checkUpdate(user);
	}

}
