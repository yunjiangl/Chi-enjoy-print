package com.zx.share.platform.console.api.modules.printer.service.impl;

import com.zx.share.platform.bean.zx.ZxPrinterManager;
import com.zx.share.platform.console.api.modules.printer.dao.PrinterDao;
import com.zx.share.platform.console.api.modules.printer.service.PrinterService;
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

    @Override
    public List<ZxPrinterManager> queryList(Map<String, Object> map) {
        return null;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return 0;
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
