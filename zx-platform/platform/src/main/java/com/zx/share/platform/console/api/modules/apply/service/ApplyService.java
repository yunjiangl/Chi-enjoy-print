package com.zx.share.platform.console.api.modules.apply.service;

import com.zx.share.platform.bean.zx.ZxUser;
import com.zx.share.platform.bean.zx.ZxUserAttorney;
import com.zx.share.platform.bean.zx.ZxUserPrinter;
import com.zx.share.platform.bean.zx.ZxUserPrinterApply;

import java.util.List;
import java.util.Map;

/**
 * Created by fenggang on 18/4/26.
 *
 * @author fenggang
 * @date 18/4/26
 */
public interface ApplyService {


    ZxUserPrinterApply queryObject(Long userId);

    List<ZxUserPrinterApply> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    /**
     * 删除，只修改用户状态
     * @param userIds
     */
    void deleteBatch(Long[] userIds);

    void startUsing(Long[] userIds);

    List<String> domain(Long userId);

    ZxUserAttorney attorney(Long userId);

    void check(ZxUser user);

    void updateStatus(ZxUserPrinter bean);
}
