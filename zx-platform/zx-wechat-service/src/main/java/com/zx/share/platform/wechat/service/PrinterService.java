package com.zx.share.platform.wechat.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zx.share.platform.bean.zx.ZxPrinterManager;
import com.zx.share.platform.util.response.PageResponseBean;
import com.zx.share.platform.vo.wechat.request.PrinterQueryBean;
import com.zx.share.platform.vo.wechat.response.PrinterResultBean;
import com.zx.share.platform.vo.wechat.response.UserDetailsBean;

/**
 * Created by fenggang on 18/3/19.
 *
 * @author fenggang
 * @date 18/3/19
 */
public interface PrinterService {

    List<PrinterResultBean> all();

    PageResponseBean<PrinterResultBean> page(PrinterQueryBean queryBean);

    List<PrinterResultBean> nearby(PrinterQueryBean queryBean);

    PageResponseBean<PrinterResultBean> query(PrinterQueryBean queryBean);

    PageResponseBean<PrinterResultBean> my(PrinterQueryBean queryBean);

    PageResponseBean<UserDetailsBean> attorneyPage(PrinterQueryBean queryBean);
    
    ZxPrinterManager prinerInfo(String code);
    
}
