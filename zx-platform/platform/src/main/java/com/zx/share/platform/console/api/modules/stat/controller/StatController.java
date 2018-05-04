package com.zx.share.platform.console.api.modules.stat.controller;

import com.zx.share.platform.bean.sys.SysUser;
import com.zx.share.platform.console.api.common.utils.Query;
import com.zx.share.platform.console.api.common.utils.R;
import com.zx.share.platform.console.api.modules.stat.service.StatService;
import com.zx.share.platform.console.api.modules.sys.controller.AbstractController;
import com.zx.share.platform.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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

    @Autowired
    private StatService statService;

    //账号中资产
    @RequestMapping("/account/all")
    public R stat(@RequestParam Map<String, Object> params){
        // 判断用户角色  组装查询条件
        this.checkParams(params);
        //查询列表数据
        Query query = new Query(params);
        query.isPaging(true);

        List<Map<String,Object>> list =statService.account(query);
        return R.ok().put("list",list);
    }

    /**
     * abcde类文件分组收益
     * @param params
     * @return
     */
    @RequestMapping("/type/group")
    public R typeGroup(@RequestParam Map<String, Object> params){
        // 判断用户角色  组装查询条件
        this.checkParams(params);
        //查询列表数据
        Query query = new Query(params);
        query.isPaging(true);
        List<Map<String,Object>> list =statService.typeGroup(query);
        return R.ok().put("list",list);
    }

    //上月跟本月收益
    @RequestMapping("/earnings")
    public R earnings(@RequestParam Map<String, Object> params){
        // 判断用户角色  组装查询条件
        this.checkParams(params);
        //查询列表数据
        Query query = new Query(params);
        query.isPaging(true);
        List<Map<String,Object>> list =statService.earnings(query);
        return R.ok().put("list",list);
    }

    private void checkParams(Map<String, Object> params){
        SysUser user = super.getUser();
        if(StringUtil.isNotBlank(user)){
            if(StringUtil.isNotBlank(user.getUserType()) && user.getUserType()==1){
                params.put("sysUserId",user.getUserId());
            }else if(StringUtil.isNotBlank(user.getUserType()) && user.getUserType()==2){
                params.put("ownerUserId",user.getUserId());
            }
        }
    }


}
