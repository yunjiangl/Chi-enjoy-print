package com.zx.share.platform.console.api.modules.stat.service.impl;

import com.zx.share.platform.bean.sys.SysDictionary;
import com.zx.share.platform.console.api.modules.stat.dao.StatDao;
import com.zx.share.platform.console.api.modules.stat.service.StatService;
import com.zx.share.platform.console.api.modules.sys.dao.SysConfigDao;
import com.zx.share.platform.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fenggang on 18/5/3.
 *
 * @author fenggang
 * @date 18/5/3
 */
@Service
public class StatServiceImpl implements StatService {

    @Autowired
    private StatDao statDao;
    @Autowired
    private SysConfigDao sysConfigDao;

    @Override
    public List<Map<String, Object>> account(Map<String, Object> query) {
        //获取总收益
        Double account = statDao.account(query);
        //获取分层比例
        List<SysDictionary> dictionaries = this.getSysDictionary("zx_order_earnings");
        return null;
    }

    @Override
    public List<Map<String, Object>> typeGroup(Map<String, Object> query) {
        //获取分层比例
        List<SysDictionary> dictionaries = this.getSysDictionary("zx_order_earnings");

        //获取A类文件金额
        Double doubleA = statDao.typeGroup_a(query);
        //获取B类文件金额
        Double doubleB = statDao.typeGroup_a(query);
        //获取C类文件金额
        Double doubleC = statDao.typeGroup_a(query);
        //获取D类文件金额
        Double doubleD = statDao.typeGroup_a(query);
        //获取E类文件金额
        Double doubleE = statDao.typeGroup_a(query);

        return null;
    }

    @Override
    public List<Map<String, Object>> earnings(Map<String, Object> query) {
        //获取分层比例
        List<SysDictionary> dictionaries = this.getSysDictionary("zx_order_earnings");

        //获取上月收益

        //获取当月收益

        return null;
    }

    //获取分层比例
    private List<SysDictionary> getSysDictionary(String type){
        Map<String, Object> configQuery = new HashMap<>();
        configQuery.put("type",type);
        return sysConfigDao.queryList(configQuery);
    }

    //获取收益map
    private Map<String,Object> getEarnings(List<SysDictionary> dictionaries,String type,Double d){
        Map<String,Object> result = new HashMap<>();
        if(dictionaries!=null && !dictionaries.isEmpty()){
            for (SysDictionary dictionarie : dictionaries) {
                if(StringUtil.isNotBlank(dictionarie.getCode()) && "".equals(dictionarie.getCode())){
                    result.put("","");
                }else if(StringUtil.isNotBlank(dictionarie.getCode()) && "".equals(dictionarie.getCode())){
                    result.put("","");
                }
            }
        }
        return result;
    }
}
