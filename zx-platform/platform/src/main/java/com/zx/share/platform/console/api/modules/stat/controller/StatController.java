package com.zx.share.platform.console.api.modules.stat.controller;

import com.zx.share.platform.console.api.common.utils.Query;
import com.zx.share.platform.console.api.common.utils.R;
import com.zx.share.platform.console.api.modules.sys.controller.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by fenggang on 18/4/26.
 *
 * @author fenggang
 * @date 18/4/26
 */
@RestController
@RequestMapping("/stat")
public class StatController extends AbstractController {

    @RequestMapping("/account")
    public R stat(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.isPaging(true);

        return R.ok();
    }

    @RequestMapping("/type/group")
    public R typeGroup(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.isPaging(true);

        return R.ok();
    }

    @RequestMapping("/earnings")
    public R earnings(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.isPaging(true);

        return R.ok();
    }

}
