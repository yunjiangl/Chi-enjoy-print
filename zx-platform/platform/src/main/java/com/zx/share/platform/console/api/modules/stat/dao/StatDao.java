package com.zx.share.platform.console.api.modules.stat.dao;

import com.zx.share.platform.bean.zx.ZxOrderPay;
import com.zx.share.platform.console.api.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import javax.xml.parsers.DocumentBuilder;
import java.util.List;
import java.util.Map;

/**
 * Created by fenggang on 18/5/3.
 *
 * @author fenggang
 * @date 18/5/3
 */
@Mapper
public interface StatDao extends BaseDao<ZxOrderPay> {

    /**
     * 获取总金额
     * @param query
     * @return
     */
    Double account(Map<String,Object> query);

    /**
     * 获取A类文件总金额
     * @param query
     * @return
     */
    Double typeGroup_a(Map<String, Object> query);

    /**
     * 获取B类文件总金额
     * @param query
     * @return
     */
    Double typeGroup_b(Map<String, Object> query);

    /**
     * 获取C类文件总金额
     * @param query
     * @return
     */
    Double typeGroup_c(Map<String, Object> query);

    /**
     * 获取D类文件总金额
     * @param query
     * @return
     */
    Double typeGroup_d(Map<String, Object> query);

    /**
     * 获取E类文件总金额
     * @param query
     * @return
     */
    Double typeGroup_e(Map<String, Object> query);


    /**
     * 根据添加获取收益金额
     * @param query
     * @return
     */
    Double earnings(Map<String, Object> query);

}
