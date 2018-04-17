package com.zx.share.platform.console.api.modules.printer.controller;

import com.zx.share.platform.bean.zx.ZxPrinterManager;
import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.console.api.common.utils.PageUtils;
import com.zx.share.platform.console.api.common.utils.Query;
import com.zx.share.platform.console.api.common.utils.R;
import com.zx.share.platform.console.api.modules.printer.service.PrinterService;
import com.zx.share.platform.console.api.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by fenggang on 18/4/17.
 *
 * @author fenggang
 * @date 18/4/17
 */
@RestController
@RequestMapping("/printer")
public class PrinterController {
    @Autowired
    private PrinterService printerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.isPaging(true);
        List<ZxPrinterManager> printerList = printerService.queryList(query);
        int total = printerService.queryTotal(query);
        PageUtils pageUtil = new PageUtils(printerList, total, query.getLimit(), query.getPage());
        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{printerId}")
    public R info(@PathVariable("printerId") Long printerId){
        ZxPrinterManager printer = printerService.queryObject(printerId);

        return R.ok().put("printer", printer);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZxPrinterManager printer){
        printerService.save(printer);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ZxPrinterManager printer){
        printerService.update(printer);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] printerIds){
        printerService.deleteBatch(printerIds);

        return R.ok();
    }
}
