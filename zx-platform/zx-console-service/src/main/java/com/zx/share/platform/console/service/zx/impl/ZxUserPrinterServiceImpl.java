package com.zx.share.platform.console.service.zx.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zx.share.platform.bean.zx.ZxUserPrinter;
import com.zx.share.platform.console.mapper.zx.ZxUserPrinterMapper;
import com.zx.share.platform.console.service.zx.ZxUserPrinterService;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.response.DefaultResopnseBean;

/**
 * 
 * @ClassName: ZxUserPrinterServiceImpl
 * @Description: 设备线上管理员业务实习类
 * @author 芸江
 * @date 2018年2月1日 上午10:08:50
 *
 */
@Service
public class ZxUserPrinterServiceImpl implements ZxUserPrinterService {

	@Autowired
	private ZxUserPrinterMapper zxUserPrinterMapper;

	@Transactional
	@Override
	public DefaultResopnseBean<Object> update(ZxUserPrinter zxUP) {

		// 如果没有指定更新的主键
		if (zxUP.getId() == 0) {

			return new DefaultResopnseBean<Object>(ErrorsEnum.SYSTEM_REQUEST_PARAM_ERROR.label,
					ErrorsEnum.SYSTEM_REQUEST_PARAM_ERROR.code, null, "没有指定主键");
		}

		// 设置审核id
		// zxUP.setCheckId(checkId);

		// 审核时间
		zxUP.setCheckTime(new Date());

		// 操作成功
		if (zxUserPrinterMapper.updateByPrimaryKeySelective(zxUP) > 0) {

			return new DefaultResopnseBean<Object>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, null);
		}

		return new DefaultResopnseBean<Object>(ErrorsEnum.SYSTEM_UPDATE_ERROR.label,
				ErrorsEnum.SYSTEM_UPDATE_ERROR.code, null, "更新失败");

	}

	@Transactional
	@Override
	public DefaultResopnseBean<Object> add(ZxUserPrinter zxUP) {
		// 设置创建者id
		// zxUP.setCreateId(createId);
		zxUP.setCreateTime(new Date());

		if (zxUserPrinterMapper.insertSelective(zxUP) > 0) {
			return new DefaultResopnseBean<Object>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, null);
		}

		return new DefaultResopnseBean<Object>(ErrorsEnum.SYSTEM_UPDATE_ERROR.label,
				ErrorsEnum.SYSTEM_UPDATE_ERROR.code, null, "添加失败");
	}

	@Override
	public DefaultResopnseBean<Object> query(ZxUserPrinter record) {

		ZxUserPrinter data = zxUserPrinterMapper.selectOne(record);

		return new DefaultResopnseBean<Object>(ErrorsEnum.SUCCESS.label, ErrorsEnum.SUCCESS.code, data);
	}

}
