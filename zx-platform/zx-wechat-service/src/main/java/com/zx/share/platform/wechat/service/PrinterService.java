package com.zx.share.platform.wechat.service;

import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;
import com.zx.share.platform.vo.user.UserResultBean;
import com.zx.share.platform.vo.wechat.request.PrinterQueryBean;
import com.zx.share.platform.vo.wechat.response.PrinterResultBean;
import com.zx.share.platform.vo.wechat.response.UserDetailsBean;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
}
