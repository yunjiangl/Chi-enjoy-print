package com.zx.share.platform.wechat.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.zx.share.platform.util.email.SendMail;
import com.zx.share.platform.util.email.StoreMail;
import com.zx.share.platform.vo.wechat.response.OrderFileBean;
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

/**
 * @author fenggang
 */
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
	public Map<String, Object> payUnifiedorder(String orderCode,String body,String openId,String ip) {
		ZxOrder zxOrder = zxOrderMapper.findByOrderCode(orderCode);
		if (zxOrder != null) {
			Date date = new Date();
			Map<String, Object> payMap = weCharPayService.payUnifiedorder(body, JSON.toJSONString(zxOrder), zxOrder.getOrderAmount().intValue(),
					ip, orderCode, openId, "JSAPI");

			ZxOrderPay orderPay = new ZxOrderPay();
			orderPay.setCreateTime(date);
			orderPay.setPayTime(date);
			orderPay.setPayStatus(PayStatusEnum.ZX_PAY_STATUS_USERPAYING.code);
			orderPay.setCreateId(zxOrder.getOrderUserId());
			orderPay.setOrderId(zxOrder.getId());
			orderPay.setOrderCode(zxOrder.getOrderCode());
			orderPay.setPayCode(payMap.get("prepay_id")+"");
			zxOrderPayMapper.insert(orderPay);

			zxOrder.setPayCode(orderPay.getPayCode());
			zxOrder.setPayType("wechat");
			zxOrder.setPayTime(orderPay.getPayTime());
			zxOrder.setStatus(OrderStatusEnum.ZX_ORDER_STATUS_USERPAYING.code);
			zxOrder.setUpdateId(zxOrder.getOrderUserId());
			zxOrder.setUpdateTime(date);

			zxOrderMapper.updateByPrimaryKeySelective(zxOrder);

			return payMap;

		}
		return new HashMap<>();
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

		// 获取打印价格倍数
		SysDictionary paperType = dictionaryMapper.selectByPrimaryKey(orderSaveBean.getPaperType());
		SysDictionary paperColcor = dictionaryMapper.selectByPrimaryKey(orderSaveBean.getPaperColcor());
		SysDictionary paperUsage = dictionaryMapper.selectByPrimaryKey(orderSaveBean.getPaperUsage());

		// 下面是文件的操作
		String fileCode = orderSaveBean.getFileCodes();
		if (StringUtil.isNotBlank(fileCode)) {

			String[] fileCodes = fileCode.split(",");

			List<ZxOrder> orderRecordList = new ArrayList<ZxOrder>();
			List<ZxOrderPrinterFile> orderPrinterFileRecordList = new ArrayList<ZxOrderPrinterFile>();
			Map<String, ZxOrderPrinterFile> orderPrinterFileRecordMap = new HashMap<String, ZxOrderPrinterFile>();
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
				zxOrderSaveBean.setPrinterAmount(ZxOrderPrinterFileSaveBean.getFilePaper().doubleValue()
						* Double.parseDouble(paperType.getValue()) * Double.parseDouble(paperColcor.getValue())
						* Double.parseDouble(paperUsage.getValue()));
				zxOrderSaveBean.setOrderAmount(zxOrderSaveBean.getServiceAmount() + zxOrderSaveBean.getPrinterAmount());
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
		return zxOrderMapper.updateOrderStatus(orderCode,null,null, OrderStatusEnum.ZX_ORDER_STATUS_CLOSE.code);
	}

	@Override
	public PageResponseBean<OrderResultBean> page(OrderQueryBean queryBean) {
		Integer count = zxOrderMapper.pageCount(queryBean);
		List<OrderResultBean> resultBeans = zxOrderMapper.page(queryBean);
		if(resultBeans!=null && !resultBeans.isEmpty()){
			for (OrderResultBean bean:resultBeans) {
				ZxPrinterManager printerManager = new ZxPrinterManager();
				printerManager.setPrinterCode(bean.getPrinterCode());
				ZxPrinterManager zxPrinterManager = printerMapper.selectOne(printerManager);
				if(zxPrinterManager!=null){
					bean.setPrinterAddress(zxPrinterManager.getAddress());
				}
				//订单状态
				bean.setStatusName(OrderStatusEnum.getLabel(bean.getStatus()));

				//文件信息
				OrderFileBean orderFileBean = this.getOrderFileBean(bean.getOrderCode());
				bean.setFile(orderFileBean);
			}
		}
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

	@Override
	public synchronized void orderCallBack() {
		try {
			//获取带确认打印成功的订单code
			List<Map<String,Object>> list = StoreMail.emailInbox();

			if(list!=null && !list.isEmpty()){
				for (Map<String,Object> map :list) {

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public synchronized boolean printer(String code) {

		//TODO 判断打印订单状态集合是否有该订单

		String fileTypeAB = "4";//ab类文件
		String fileTypeCDE = "5";//cde类文件
		OrderResultBean orderResultBean = zxOrderMapper.getOrderCode(code);
		List<ZxOrderPrinterFile> list = zxOrderPrinterFileMapper.getOrderFile(code);
		if(list!=null && !list.isEmpty()){
			for (ZxOrderPrinterFile file:list) {
				FileResultBean bean = null;
				if(fileTypeAB.equals(file.getFileType())){
					bean = zxFileManagerABMapper.detailsab(file.getFileCode());
				}else if(fileTypeCDE.equals(file.getFileType())){
					bean = zxFileManagerABMapper.detailscde(file.getFileCode());
				}

				String path = this.getFilePath(bean);
				if(StringUtil.isBlank(path)){
					return false;
				}

				File fileEntity = new File(path);
				if(!fileEntity.isFile()){
					return false;
				}
				if(SendMail.sendEmail(path)){
					//TODO 写入打印订单状态集合


					return true;
				}else{
					return false;
				}
			}
		}
		return false;
	}

	@Override
	public void manualCallback(String orderCode, String payCode, Integer status,String error) {
		ZxOrder zxOrder = zxOrderMapper.findByOrderCode(orderCode);
		if (zxOrder != null) {
			ZxOrderPay orderPay = new ZxOrderPay();
			orderPay.setCreateTime(new Date());
			orderPay.setPayTime(orderPay.getCreateTime());
			orderPay.setPayStatus(status);
			orderPay.setCreateId(zxOrder.getOrderUserId());
			orderPay.setOrderId(zxOrder.getId());
			orderPay.setOrderCode(zxOrder.getOrderCode());
			orderPay.setPayCode(payCode);
			orderPay.setError(error);

			zxOrderPayMapper.insert(orderPay);
			zxOrder.setPayCode(orderPay.getPayCode());
			zxOrder.setPayTime(orderPay.getPayTime());
			zxOrder.setStatus(status);
			zxOrder.setPayType("wechat");
			zxOrder.setUpdateId(zxOrder.getOrderUserId());
			zxOrder.setUpdateTime(orderPay.getCreateTime());

			zxOrderMapper.updateByPrimaryKeySelective(zxOrder);
		}
	}

	private String getFilePath(FileResultBean bean){
		if(bean==null){
			return null;
		}
		String filePath = bean.getFileUrl();
		if(StringUtil.isBlank(filePath)){
			return null;
		}
		return filePath;
	}

	private OrderFileBean getOrderFileBean(String code){
		OrderFileBean orderFileBean = new OrderFileBean();

		String fileTypeAB = "4";//ab类文件
		String fileTypeCDE = "5";//cde类文件
		List<ZxOrderPrinterFile> list = zxOrderPrinterFileMapper.getOrderFile(code);
		if(list!=null && !list.isEmpty()){
			for (ZxOrderPrinterFile file:list) {
				FileResultBean bean = null;
				if(fileTypeAB.equals(file.getFileType())){
					bean = zxFileManagerABMapper.detailsab(file.getFileCode());
				}else if(fileTypeCDE.equals(file.getFileType())){
					bean = zxFileManagerABMapper.detailscde(file.getFileCode());
				}

				if(bean!=null){
					orderFileBean.setFileName(bean.getFileName());
					orderFileBean.setFilePaper(bean.getFileNum()+"");
					orderFileBean.setPrinterNum(file.getPrinterNum()+"");
					orderFileBean.setPaperColcor(dictionaryMapper.selectByPrimaryKey(file.getPaperColcor()).getName());
					orderFileBean.setPaperType(dictionaryMapper.selectByPrimaryKey(file.getPaperType()).getName());
					orderFileBean.setPaperUsage(dictionaryMapper.selectByPrimaryKey(file.getPaperUsage()).getName());
					return orderFileBean;
				}
			}
		}
		return orderFileBean;
	}

}