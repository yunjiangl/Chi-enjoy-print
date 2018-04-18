package com.zx.share.platform.console.api.modules.printer.service.impl;

import com.zx.share.platform.bean.zx.ZxPrinterManager;
import com.zx.share.platform.console.api.modules.printer.dao.PrinterDao;
import com.zx.share.platform.console.api.modules.printer.service.PrinterService;
import com.zx.share.platform.console.api.modules.sys.dao.SysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by fenggang on 18/4/17.
 *
 * @author fenggang
 * @date 18/4/17
 */
@Service
public class PrinterServiceImpl implements PrinterService {

    @Autowired
    private PrinterDao printerDao;
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public List<ZxPrinterManager> queryList(Map<String, Object> map) {
        List<ZxPrinterManager> printerList = printerDao.queryList(map);

        printerList.forEach(x->x.setSysUser(sysUserDao.queryObject(x.getCreateId())));
        return printerList;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return printerDao.queryTotal(map);
    }

    @Override
    public void save(ZxPrinterManager printer) {
        printerDao.save(printer);
    }

    @Override
    public void update(ZxPrinterManager printer) {
        printerDao.update(printer);
    }

    @Override
    public void deleteBatch(Long[] printerIds) {
        printerDao.deleteBatch(printerIds);
    }

    @Override
    public ZxPrinterManager queryObject(Long printerId) {
        return printerDao.queryObject(printerId);
    }
}
