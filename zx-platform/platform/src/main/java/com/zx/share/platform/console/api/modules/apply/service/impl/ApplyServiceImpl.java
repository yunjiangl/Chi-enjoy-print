package com.zx.share.platform.console.api.modules.apply.service.impl;

import com.zx.share.platform.bean.zx.*;
import com.zx.share.platform.console.api.modules.apply.dao.ApplyDao;
import com.zx.share.platform.console.api.modules.apply.service.ApplyService;
import com.zx.share.platform.console.api.modules.printer.service.PrinterService;
import com.zx.share.platform.console.api.modules.user.service.UserService;
import com.zx.share.platform.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.PrinterMakeAndModel;
import java.util.List;
import java.util.Map;

/**
 * Created by fenggang on 18/4/26.
 *
 * @author fenggang
 * @date 18/4/26
 */
@Service
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    private ApplyDao applyDao;
    @Autowired
    private PrinterService printerService;
    @Autowired
    private UserService userService;

    @Override
    public ZxUserPrinterApply queryObject(Long userId) {
        return applyDao.queryObject(userId);
    }

    @Override
    public List<ZxUserPrinterApply> queryList(Map<String, Object> map) {
        return applyDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return applyDao.queryTotal(map);
    }

    @Override
    public void deleteBatch(Long[] userIds) {

    }

    @Override
    public void startUsing(Long[] userIds) {

    }

    @Override
    public List<String> domain(Long userId) {
        return null;
    }

    @Override
    public ZxUserAttorney attorney(Long userId) {
        return null;
    }

    @Override
    public void check(ZxUser user) {

    }

    @Override
    public void updateStatus(ZxUserPrinter bean) {
        ZxUserPrinterApply entity = new ZxUserPrinterApply();
        entity.setId(bean.getId());
        entity.setStatus(bean.getStatus());
        entity.setCheckId(bean.getCheckId());
        applyDao.updateStatus(entity);
        if(StringUtil.isNotBlank(bean.getStatus())&& bean.getStatus()==1){
            ZxUserPrinterApply apply = queryObject(bean.getId());
            BeanUtils.copyProperties(apply,bean);
            ZxPrinterManager printer = printerService.queryObject(bean.getPrinterId());
            if(printer!=null){
                bean.setPrinterCode(printer.getPrinterCode());
            }
            ZxUser user = userService.queryObject(bean.getUserId());
            if(user!=null){
                bean.setUserCode(user.getUserCode());
            }
            applyDao.saveApply(bean);
        }
    }
}
