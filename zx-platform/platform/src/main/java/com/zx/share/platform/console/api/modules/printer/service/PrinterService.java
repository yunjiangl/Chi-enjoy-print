package com.zx.share.platform.console.api.modules.printer.service;

import com.zx.share.platform.bean.zx.ZxPrinterManager;

import java.util.List;
import java.util.Map;

/**
 * Created by fenggang on 18/4/17.
 *
 * @author fenggang
 * @date 18/4/17
 */
public interface PrinterService {

    List<ZxPrinterManager> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(ZxPrinterManager printer);

    void update(ZxPrinterManager printer);

    void deleteBatch(Long[] printerIds);

    ZxPrinterManager queryObject(Long printerId);

    void startUsing(Long[] ids);
}
