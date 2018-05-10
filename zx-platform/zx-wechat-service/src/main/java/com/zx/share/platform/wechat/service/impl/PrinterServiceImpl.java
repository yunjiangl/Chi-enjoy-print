package com.zx.share.platform.wechat.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zx.share.platform.bean.zx.ZxPrinterManager;
import com.zx.share.platform.common.service.MemcachedService;
import com.zx.share.platform.constants.OCSKeys;
import com.zx.share.platform.util.response.PageResponseBean;
import com.zx.share.platform.vo.wechat.request.PrinterQueryBean;
import com.zx.share.platform.vo.wechat.response.PrinterResultBean;
import com.zx.share.platform.vo.wechat.response.UserDetailsBean;
import com.zx.share.platform.wechat.mapper.PrinterMapper;
import com.zx.share.platform.wechat.service.PrinterService;

/**
 * Created by fenggang on 18/3/19.
 *
 * @author fenggang
 * @date 18/3/19
 */
@Service
public class PrinterServiceImpl implements PrinterService {

    @Autowired
    private PrinterMapper printerMapper;
    @Autowired
    private MemcachedService memcachedService;

    @Override
    public List<PrinterResultBean> all() {
        return printerMapper.all();
    }

    @Override
    public PageResponseBean<PrinterResultBean> page(PrinterQueryBean queryBean) {

        Integer count = printerMapper.pageCount(queryBean);
        List<PrinterResultBean> resultBeans = printerMapper.page(queryBean);
        PageResponseBean<PrinterResultBean> pageResponseBean = new PageResponseBean<>(queryBean,count);
        pageResponseBean.setContent(resultBeans);
        return pageResponseBean;
    }

    @Override
    public List<PrinterResultBean> nearby(PrinterQueryBean queryBean) {
        return printerMapper.nearby(queryBean);
    }

    @Override
    public PageResponseBean<PrinterResultBean> query(PrinterQueryBean queryBean) {
        Integer count = printerMapper.pageCount(queryBean);
        List<PrinterResultBean> resultBeans = printerMapper.page(queryBean);
        PageResponseBean<PrinterResultBean> pageResponseBean = new PageResponseBean<>(queryBean,count);
        pageResponseBean.setContent(resultBeans);
        return pageResponseBean;
    }

    @Override
    public PageResponseBean<PrinterResultBean> my(PrinterQueryBean queryBean) {
        Integer count = printerMapper.pageCount(queryBean);
        List<PrinterResultBean> resultBeans = printerMapper.page(queryBean);

        //将查询出来的数据根据设备物主名进行分组
        //List<PrinterResultBean> dataList = printerService.all();//查询出来的所有数据
        PrinterResultBean dataItem; // 数据库中查询到的每条记录
        Map<String, List<PrinterResultBean>> resultMap= new HashMap<String, List<PrinterResultBean>>(); // 最终要的结果
        for(int i=0;i<resultBeans.size();i++){
            dataItem = resultBeans.get(i);
            if(resultMap.containsKey(dataItem.getCreateId())){
                resultMap.get(dataItem.getCreateId()).add(dataItem);
            }else{
                List<PrinterResultBean> list = new ArrayList<PrinterResultBean>();
                list.add(dataItem);
                resultMap.put(dataItem.getCreateId(),list);
            }
        }
        //map集合转List集合，将map的value存入List
        List<List<PrinterResultBean>> mapValuesList = new ArrayList<List<PrinterResultBean>>(resultMap.values());

        PageResponseBean<PrinterResultBean> pageResponseBean = new PageResponseBean<>(queryBean,count);
        pageResponseBean.setDataPacket(mapValuesList);
        return pageResponseBean;
    }

    @Override
    public PageResponseBean<UserDetailsBean> attorneyPage(PrinterQueryBean queryBean) {
        List<String> userList = printerMapper.attorneyPage(queryBean);
        Integer count = printerMapper.attorneyPageCount(queryBean);
        PageResponseBean<UserDetailsBean> pageResponseBean = new PageResponseBean<>(queryBean,count);
        List<UserDetailsBean> resultBeans = new ArrayList<>();
        if(userList!=null && !userList.isEmpty()){
            for (String userCode:userList) {
                String key = OCSKeys.ZX_USER_DETAILS_CACHE_KEY+userCode;
                UserDetailsBean resultBean = (UserDetailsBean)memcachedService.getAndTouch(key,OCSKeys.ZX_USER_DETAILS_CACHE_KEY_EXP_KEY);
                resultBeans.add(resultBean);
            }
        }
        pageResponseBean.setContent(resultBeans);
        return pageResponseBean;
    }

	@Override
	public ZxPrinterManager prinerInfo(String code) {
		ZxPrinterManager record = new ZxPrinterManager();
		record.setPrinterCode(code);
		
		return printerMapper.selectOne(record);
	}

    /**
     * 根据设备物主查询打印机设备
     *
     * @param createId
     * @return
     */
    @Override
    public List<PrinterResultBean> findByName(Long createId) {
        return printerMapper.findByName(createId);
    }
}