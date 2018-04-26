package com.zx.share.platform.console.api.modules.apply.service.impl;

import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.bean.zx.ZxUserAttorney;
import com.zx.share.platform.bean.zx.ZxUserPrinterApply;
import com.zx.share.platform.console.api.modules.apply.dao.ApplyDao;
import com.zx.share.platform.console.api.modules.apply.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
