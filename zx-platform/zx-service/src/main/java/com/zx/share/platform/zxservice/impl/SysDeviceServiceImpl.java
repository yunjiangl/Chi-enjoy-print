package com.zx.share.platform.zxservice.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exqoo.dao.SysDeviceDao;
import com.exqoo.entity.SysDevice;
import com.exqoo.entity.SysUser;
import com.exqoo.entity.SysUserDev;
import com.exqoo.service.SysDeviceService;
import com.exqoo.service.SysUserDevService;
import com.exqoo.service.SysUserService;

/**
 * 
 * @ClassName: SysDeviceServiceImpl
 * @Description: 设备业务实现类
 * @author 芸江
 * @date 2018年1月16日 下午2:52:11
 *
 */
@Service
public class SysDeviceServiceImpl implements SysDeviceService {

	@Autowired
	private SysDeviceDao sysDeviceDao;

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private SysUserDevService sysUserDevService;

	@Transactional
	@Override
	public int add(SysDevice record, String nickName) {
		List<SysUser> users = sysUserService.selectNikeNameUser(nickName);

		/**
		 * 如果查找到多个用户,或者没有查询到用户
		 */
		if (users.size() > 1 || users.size() == 0) {
			return 0;
		}

		Long id = (long) (sysDeviceDao.selectAll().size() + 1);

		
		record.setCreateDate(new Date());

		sysDeviceDao.insertSelective(record);

		SysUserDev userDev = new SysUserDev();

		// 添加关系
		userDev.setUserId(users.get(0).getUserId());
		userDev.setDeviceId(id);

		sysUserDevService.add(userDev);

		return 1;
	}

	@Override
	public List<SysDevice> list(Map<String, Object> map) {
		return sysDeviceDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> params) {
		return sysDeviceDao.selectTotal(params);
	}

	@Override
	public SysDevice queryByDeviceHsot(String deviceHost) {
		return sysDeviceDao.selectByDeviceHsot(deviceHost);
	}

	@Override
	public SysDevice queryByDeviceId(Long deviceId) {
		return sysDeviceDao.selectBysysDeviceDao(deviceId);
	}

	
}
