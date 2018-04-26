package com.zx.share.platform.wechat.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.zx.share.platform.bean.sys.SysDictionary;
import com.zx.share.platform.bean.zx.ZxFileManagerAB;
import com.zx.share.platform.bean.zx.ZxFileManagerCDE;
import com.zx.share.platform.bean.zx.ZxOrder;
import com.zx.share.platform.bean.zx.ZxOrderPay;
import com.zx.share.platform.bean.zx.ZxOrderPrinterFile;
import com.zx.share.platform.bean.zx.ZxPrinterManager;
import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.constants.OrderStatusEnum;
import com.zx.share.platform.constants.PayStatusEnum;
import com.zx.share.platform.util.CodeBuilderUtil;
import com.zx.share.platform.util.StringUtil;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;
import com.zx.share.platform.vo.wechat.request.OrderFileSaveBean;
import com.zx.share.platform.vo.wechat.request.OrderQueryBean;
import com.zx.share.platform.vo.wechat.request.OrderSaveBean;
import com.zx.share.platform.vo.wechat.response.FileResultBean;
import com.zx.share.platform.vo.wechat.response.OrderResultBean;
import com.zx.share.platform.wechat.api.pay.service.WeCharPayService;
import com.zx.share.platform.wechat.mapper.DictionaryMapper;
import com.zx.share.platform.wechat.mapper.FileManagerMapper;
import com.zx.share.platform.wechat.mapper.PrinterMapper;
import com.zx.share.platform.wechat.mapper.UserMapper;
import com.zx.share.platform.wechat.mapper.file.CDEFileMapper;
import com.zx.share.platform.wechat.mapper.order.ZxOrderMapper;
import com.zx.share.platform.wechat.mapper.order.ZxOrderPayMapper;
import com.zx.share.platform.wechat.mapper.order.ZxOrderPrinterFileMapper;
import com.zx.share.platform.wechat.service.ZxOrderService;

@Service
public class ZxOrderServiceImpl implements ZxOrderService {

	@Autowired
	private ZxOrderMapper zxOrderMapper;

	@Autowired
	private ZxOrderPayMapper zxOrderPayMapper;

	@Autowired
	private ZxOrderPrinterFileMapper zxOrderPrinterFileMapper;

	@Autowired
	private WeCharPayService weCharPayService;

	@Autowired
	private DictionaryMapper dictionaryMapper;

	@Autowired
	private FileManagerMapper zxFileManagerABMapper;

	@Autowired
	private CDEFileMapper zxFileManagerCDEMapper;

	@Autowired
	private PrinterMapper printerMapper;

	@Autowired
	private UserMapper userMapper;

	@Override
	public DefaultResopnseBean<PageResponseBean<ZxOrder>> list(Map<String, Object> params) {
		// TODO Auto-generated method stub
		Integer pageNum = params.get("pageNum") != null ? Integer.parseInt(params.get("pageNum").toString()) : 1;
		Integer pageSize = params.get("pageSize") != null ? Integer.parseInt(params.get("pageSize").toString()) : 10;
		PageHelper.startPage(pageNum, pageSize, true);
		List<ZxOrder> list = zxOrderMapper.queryList(params);
		return null;
	}

	@Transactional(readOnly = false)
	@Override
	public Map<String, Object> payUnifiedorder(String orderCode) {
		ZxOrder zxOrder = zxOrderMapper.findByOrderCode(orderCode);
		if (zxOrder != null) {
			Date date = new Date();
			Map<String, Object> payMap = weCharPayService.payUnifiedorder("", "", zxOrder.getOrderAmount().intValue(),
					"ip", orderCode, "openid", "JSAPI");

			ZxOrderPay orderPay = new ZxOrderPay();
			orderPay.setCreateTime(date);
			orderPay.setPayStatus(PayStatusEnum.ZX_PAY_STATUS_USERPAYING.code);
			orderPay.setCreateId(zxOrder.getOrderUserId());
			orderPay.setOrderId(zxOrder.getId());
			orderPay.setPayCode("");

			zxOrder.setPayCode(orderPay.getPayCode());
			zxOrder.setStatus(OrderStatusEnum.ZX_ORDER_STATUS_USERPAYING.code);
			zxOrder.setUpdateId(zxOrder.getOrderUserId());
			zxOrder.setUpdateTime(date);

		}
		return null;
	}

	@Override
	public Map<String, Object> paycallback_manual(Map<String, Object> map) {
		return null;
	}

	@Override
	public Map<String, Object> paycallback_automation(Map<String, Object> map) {
		return null;
	}

	@Override
	public int saveOrder(OrderSaveBean orderSaveBean) {
		int result = 0;
		if (StringUtil.isBlank(orderSaveBean.getOrderCode())) {
			result = this.save(orderSaveBean);
		} else {
			result = this.update(orderSaveBean);
		}
		return result;
	}

	/**
	 * 
	 * @Title: save
	 * @Description: 保存订单
	 */
	@Transactional
	private int save(OrderSaveBean orderSaveBean) {

		// 获取打印机信息
		ZxPrinterManager printerRecord = new ZxPrinterManager();
		ZxPrinterManager printeResultBean = new ZxPrinterManager();
		printerRecord.setPrinterCode(orderSaveBean.getPrinterCode());
		printeResultBean = printerMapper.selectOne(printerRecord);

		// 获取用户信息
		ZxUser customerRecord = new ZxUser();
		ZxUser customerResultBean = new ZxUser();
		customerRecord.setUserCode(orderSaveBean.getCustomerCode());
		customerResultBean = userMapper.selectOne(customerRecord);

		// 获取律师信息
		ZxUser attorneyRecord = new ZxUser();
		ZxUser attorneyResultBean = new ZxUser();
		attorneyRecord.setUserCode(orderSaveBean.getAttorneyCode());
		attorneyResultBean = userMapper.selectOne(attorneyRecord);

		// 下面是文件的操作
		String fileCode = orderSaveBean.getFileCodes();
		if (StringUtil.isNotBlank(fileCode)) {

			String[] fileCodes = fileCode.split(",");
			
			List<ZxOrder> orderRecordList = new ArrayList<ZxOrder>();
			List<ZxOrderPrinterFile> orderPrinterFileRecordList = new ArrayList<ZxOrderPrinterFile>();
			Map<String, ZxOrderPrinterFile> orderPrinterFileRecordMap =   new HashMap<String, ZxOrderPrinterFile>();
			List<String> orderCodes = new ArrayList<String>();
			
			for (int i = 0; i < fileCodes.length; i++) {

				ZxOrder zxOrderSaveBean = new ZxOrder();
				ZxOrderPrinterFile ZxOrderPrinterFileSaveBean = new ZxOrderPrinterFile();
				
				// 首先生成一个订单code，这里先把订单num设置为何code一致
				String orderCode = CodeBuilderUtil.orderCOde(orderSaveBean.getAttorneyCode());
				String orderNum = orderCode;
				orderCodes.add(orderCode);

				FileResultBean abResultBean = null;
				FileResultBean cdeResultBean = null;

				if (orderSaveBean.getFileType().longValue() == 4L) {
					// ab类型的文件

					abResultBean = zxFileManagerABMapper.detailsab(fileCodes[i]);

					zxOrderSaveBean.setFileUrl(abResultBean.getFileUrl());
					ZxOrderPrinterFileSaveBean.setFileType("4");
					ZxOrderPrinterFileSaveBean.setFileId(abResultBean.getId());
					ZxOrderPrinterFileSaveBean.setFilePaper(abResultBean.getFileNum() * orderSaveBean.getPrinterNum());
				} else if (orderSaveBean.getFileType().longValue() == 5L) {
					// cde类型文件
					ZxFileManagerCDE cdeRecord = new ZxFileManagerCDE();
					cdeRecord.setFileCode(fileCodes[i]);
					cdeResultBean = zxFileManagerABMapper.detailscde(fileCodes[i]);

					zxOrderSaveBean.setFileUrl(cdeResultBean.getFileUrl());
					ZxOrderPrinterFileSaveBean.setFileType("5");
					ZxOrderPrinterFileSaveBean.setFileId(cdeResultBean.getId());
					ZxOrderPrinterFileSaveBean.setFilePaper(cdeResultBean.getFileNum() * orderSaveBean.getPrinterNum());
				}

				zxOrderSaveBean.setAttorneyCode(attorneyResultBean.getUserCode());
				zxOrderSaveBean.setAttorneyId(attorneyResultBean.getId());
				zxOrderSaveBean.setCreateId(attorneyResultBean.getId());
				zxOrderSaveBean.setCreateTime(new Date());
				zxOrderSaveBean.setOrderCode(orderCode);
				zxOrderSaveBean.setOrderNum(orderNum);
				zxOrderSaveBean.setOrderUserCode(customerResultBean.getUserCode());
				zxOrderSaveBean.setOrderUserId(customerResultBean.getId());
				// zxOrderSaveBean.setPrinterAmount(printerAmount);打印费用，不知道一张纸多少钱
				zxOrderSaveBean.setPrinterCode(printeResultBean.getPrinterCode());
				zxOrderSaveBean.setPrinterId(printeResultBean.getId());
				zxOrderSaveBean.setServiceAmount(orderSaveBean.getServiceAmout());
				zxOrderSaveBean.setStatus(0); // 0这个状态应该是未支付

				orderRecordList.add(zxOrderSaveBean);

				ZxOrderPrinterFileSaveBean.setFileCode(fileCodes[i]);
				ZxOrderPrinterFileSaveBean.setCreateId(attorneyResultBean.getId());
				ZxOrderPrinterFileSaveBean.setCreateTime(new Date());
				ZxOrderPrinterFileSaveBean.setOrderCode(orderCode);
				ZxOrderPrinterFileSaveBean.setPaperColcor(orderSaveBean.getPaperColcor());
				ZxOrderPrinterFileSaveBean.setPaperType(orderSaveBean.getPaperType());
				ZxOrderPrinterFileSaveBean.setPaperUsage(orderSaveBean.getPaperUsage());
				ZxOrderPrinterFileSaveBean.setPrinterNum(orderSaveBean.getPrinterNum());

				orderPrinterFileRecordMap.put(orderCode, ZxOrderPrinterFileSaveBean);

			}

			zxOrderMapper.insertList(orderRecordList);

			for (ZxOrder orderRecord : orderRecordList) {
				ZxOrder record = new ZxOrder();
				record.setOrderCode(orderRecord.getOrderCode());
				orderPrinterFileRecordMap.get(orderRecord.getOrderCode())
						.setOrderId(zxOrderMapper.selectOne(record).getId());
			}
			orderPrinterFileRecordList.addAll(orderPrinterFileRecordMap.values());
			zxOrderPrinterFileMapper.insertList(orderPrinterFileRecordList);
			return 1;
		}

		return 0;
	}

	private int update(OrderSaveBean orderSaveBean) {
		// 获取历史订单

		return 0;
	}

	@Override
	public int updateOrderFile(OrderFileSaveBean fileSaveBean) {
		return 0;
	}

	@Override
	public OrderResultBean findByOrderCode(String orderCode) {
		return zxOrderMapper.getOrderCode(orderCode);
	}

	@Override
	public int cancel(String orderCode) {
		return zxOrderMapper.updateOrderStatus(orderCode, OrderStatusEnum.ZX_ORDER_STATUS_CLOSE.code);
	}

	@Override
	public PageResponseBean<OrderResultBean> page(OrderQueryBean queryBean) {
		Integer count = zxOrderMapper.pageCount(queryBean);
		List<OrderResultBean> resultBeans = zxOrderMapper.page(queryBean);
		PageResponseBean<OrderResultBean> pageResponseBean = new PageResponseBean<>(queryBean, count);
		pageResponseBean.setContent(resultBeans);
		return pageResponseBean;
	}

	@Override
	public List<ZxOrder> attorney(Map<String, Object> param) {
		Date date = (Date) param.get("time");
		if (date != null) {
			SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateTime = time.format(date);
			StringUtils.substringBeforeLast(dateTime, "-");
			param.put("time", dateTime);
		}
		return zxOrderMapper.attorney(param);
	}

	@Override
	public ZxOrder orderInfo(String code) {
		ZxOrder zxOrder = zxOrderMapper.selectByCode(code);

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

}
