package com.zx.share.platform.console.api.modules.order.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zx.share.platform.bean.sys.SysDictionary;
import com.zx.share.platform.bean.zx.ZxFileManagerAB;
import com.zx.share.platform.bean.zx.ZxFileManagerCDE;
import com.zx.share.platform.bean.zx.ZxOrder;
import com.zx.share.platform.console.api.modules.file.dao.ZxFileManagerABMapper;
import com.zx.share.platform.console.api.modules.file.dao.ZxFileManagerCDEMapper;
import com.zx.share.platform.console.api.modules.order.dao.ZxOrderMapper;
import com.zx.share.platform.console.api.modules.order.service.ZxOrderService;
import com.zx.share.platform.console.api.modules.sys.dao.SysDictionaryMapper;
import com.zx.share.platform.constants.ErrorsEnum;
import com.zx.share.platform.util.StringUtil;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;

/**
 * 
 * @ClassName: ZxOrderServiceImpl
 * @author: 刘芸江
 * @date: 2018年3月27日 下午3:59:02
 */
@Service
public class ZxOrderServiceImpl implements ZxOrderService {

	@Autowired
	private ZxOrderMapper zxOrderMapper;

	@Autowired
	private SysDictionaryMapper dictionaryMapper;

	@Autowired
	private ZxFileManagerABMapper zxFileManagerABMapper;

	@Autowired
	private ZxFileManagerCDEMapper zxFileManagerCDEMapper;

	@Override
	public DefaultResopnseBean<PageResponseBean<ZxOrder>> list(Map<String, Object> param) {
		Integer pageNum = param.get("page") != null ? Integer.parseInt(param.get("page").toString()) : 1;
		Integer pageSize = param.get("limit") != null ? Integer.parseInt(param.get("limit").toString()) : 10;
		PageHelper.startPage(pageNum, pageSize, true);
		List<ZxOrder> list = zxOrderMapper.queryList(param);

		PageInfo pageInfo = new PageInfo(list);

		PageResponseBean<ZxOrder> data = new PageResponseBean<ZxOrder>();

		data.setFirst(pageInfo.isIsFirstPage());
		data.setLast(pageInfo.isIsLastPage());
		data.setNumber(pageInfo.getPageNum());
		data.setNumberOfElements(pageInfo.getPageSize());
		data.setSize(pageInfo.getSize());
		data.setTotalPages(pageInfo.getPages());
		data.setTotalElements(pageInfo.getTotal());
		data.setContent(pageInfo.getList());

		DefaultResopnseBean<PageResponseBean<ZxOrder>> resopnseBean = new DefaultResopnseBean<PageResponseBean<ZxOrder>>();

		resopnseBean.setData(data);
		resopnseBean.setCode(ErrorsEnum.SUCCESS.code);
		resopnseBean.setMessage(ErrorsEnum.SUCCESS.label);

		return resopnseBean;
	}

	@Override
	public ZxOrder orderInfo(Long id) {
		ZxOrder zxOrder = zxOrderMapper.queryByOrderId(id);
		SysDictionary record = new SysDictionary();

		if (StringUtil.isNotBlank(zxOrder)) {
			record.setId(Long.valueOf(zxOrder.getZxOrderPrinterFile().getFileType()));
		}

		SysDictionary sysDictionary = dictionaryMapper.selectByPrimaryKey(record);

		// 判断订单文件
		if (StringUtil.isNotBlank(sysDictionary) && "fileAB".equals(sysDictionary.getCode())) {

			ZxFileManagerAB ab = new ZxFileManagerAB();
			ab.setId(zxOrder.getZxOrderPrinterFile().getFileId());
			zxOrder.setZxFileManagerAB(zxFileManagerABMapper.selectByPrimaryKey(ab));

		} else if (StringUtil.isNotBlank(sysDictionary) && "fileCDE".equals(sysDictionary.getCode())) {

			ZxFileManagerCDE cde = new ZxFileManagerCDE();
			cde.setId(zxOrder.getZxOrderPrinterFile().getFileId());
			zxOrder.setZxFileManagerCDE(zxFileManagerCDEMapper.selectByPrimaryKey(cde));
		}
		return zxOrder;
	}

	@Override
	public Integer selectCount() {
		// TODO Auto-generated method stub
		ZxOrder zxOrder=new ZxOrder();
		return zxOrderMapper.selectCount(zxOrder);
	}

	@Override
	public Integer selectSum() {
		// TODO Auto-generated method stub
		return zxOrderMapper.selectSum();
	}

}
