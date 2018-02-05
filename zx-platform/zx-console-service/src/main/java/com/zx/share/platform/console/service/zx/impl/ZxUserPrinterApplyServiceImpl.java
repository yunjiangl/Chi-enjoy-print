package com.zx.share.platform.console.service.zx.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zx.share.platform.bean.zx.ZxUserPrinterApply;
import com.zx.share.platform.console.mapper.zx.ZxUserPrinterApplyMapper;
import com.zx.share.platform.console.service.zx.ZxUserPrinterApplyService;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.response.DefaultResopnseBean;

/**
 * 
 * @ClassName: ZxUserPrinterApplyServiceImpl
 * @Description: 设备线上管理员申请业务实现类
 * @author 芸江
 * @date 2018年2月3日 上午10:48:07
 *
 */
@Service
public class ZxUserPrinterApplyServiceImpl implements ZxUserPrinterApplyService {

	@Autowired
	private ZxUserPrinterApplyMapper zxUserPrinterApplyMapper;

	@Transactional
	@Override
	public DefaultResopnseBean<Object> add(ZxUserPrinterApply zxUPA) {
		zxUPA.setCreateTime(new Date());
		// 设置创建者id
		// zxUPA.setCreateId(createId);

		zxUserPrinterApplyMapper.insertSelective(zxUPA);
		return new DefaultResopnseBean<Object>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, null);
	}

	@Transactional
	@Override
	public DefaultResopnseBean<Object> update(ZxUserPrinterApply zxUPA) {

		// 如果没有指定更新的主键
		if (zxUPA.getId() == 0) {

			return new DefaultResopnseBean<Object>(ErrorsEnum.SYSTEM_REQUEST_PARAM_ERROR.label,
					ErrorsEnum.SYSTEM_REQUEST_PARAM_ERROR.code, null, "没有指定主键");
		}

		zxUPA.setCheckTime(new Date());
		// 设置审核id
		// zxUPA.setCheckId(checkId);

		// 操作成功
		if (zxUserPrinterApplyMapper.updateByPrimaryKeySelective(zxUPA) > 0) {

			return new DefaultResopnseBean<Object>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, null);
		}

		return new DefaultResopnseBean<Object>(ErrorsEnum.SYSTEM_UPDATE_ERROR.label,
				ErrorsEnum.SYSTEM_UPDATE_ERROR.code, null, "更新失败");

	}

	@Override
	public DefaultResopnseBean<Object> query(ZxUserPrinterApply zxUPA) {
		ZxUserPrinterApply data = zxUserPrinterApplyMapper.selectOne(zxUPA);

		return new DefaultResopnseBean<Object>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, data);
	}

}
