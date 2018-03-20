package com.zx.share.platform.wechat.service.impl;

import com.zx.share.platform.util.response.PageResponseBean;
import com.zx.share.platform.vo.wechat.request.PrinterQueryBean;
import com.zx.share.platform.vo.wechat.response.PrinterResultBean;
import com.zx.share.platform.wechat.mapper.PrinterMapper;
import com.zx.share.platform.wechat.service.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
        PageResponseBean<PrinterResultBean> pageResponseBean = new PageResponseBean<>(queryBean,count);
        pageResponseBean.setContent(resultBeans);
        return pageResponseBean;
    }
}