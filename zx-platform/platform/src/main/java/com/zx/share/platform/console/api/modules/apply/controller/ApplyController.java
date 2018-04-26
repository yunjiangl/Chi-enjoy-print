package com.zx.share.platform.console.api.modules.apply.controller;

import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.bean.zx.ZxUserAttorney;
import com.zx.share.platform.bean.zx.ZxUserPrinter;
import com.zx.share.platform.bean.zx.ZxUserPrinterApply;
import com.zx.share.platform.console.api.common.utils.PageUtils;
import com.zx.share.platform.console.api.common.utils.Query;
import com.zx.share.platform.console.api.common.utils.R;
import com.zx.share.platform.console.api.modules.apply.service.ApplyService;
import com.zx.share.platform.console.api.modules.sys.controller.AbstractController;
import com.zx.share.platform.console.api.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by fenggang on 18/4/26.
 *
 * @author fenggang
 * @date 18/4/26
 */
@RestController
@RequestMapping("/apply")
public class ApplyController extends AbstractController {

    @Autowired
    private ApplyService applyService;
    @Autowired
    private UserService userService;


    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.isPaging(true);
        List<ZxUserPrinterApply> userList = applyService.queryList(query);
        if(userList!=null){
            userList.forEach(x->x.setZxUser(userService.queryObject(x.getUserId())));
        }
        int total = applyService.queryTotal(query);
        PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());
        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/domain/{userId}")
    public R domain(@PathVariable("userId") Long userId){
        List<String> list = applyService.domain(userId);

        return R.ok().put("domains", list==null?new ArrayList<String>():list);
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    public R info(@PathVariable("userId") Long userId){
        ZxUserPrinterApply user = applyService.queryObject(userId);

        return R.ok().put("user", user);
    }
    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] userIds){
        applyService.deleteBatch(userIds);

        return R.ok();
    }

    @RequestMapping("/check")
    public R check(@RequestBody ZxUserPrinter user){
        user.setCheckId(getUserId());
        user.setCheckTime(new Date());
        applyService.updateStatus(user);
        return R.ok();
    }


}
