package com.zx.share.platform.wechat.mapper.order;


import com.zx.share.platform.bean.zx.ZxOrderPay;
import org.springframework.stereotype.Repository;

import com.zx.share.platform.common.mapper.PlatFormMapper;

import java.util.List;


@Repository
public interface ZxOrderPayMapper extends PlatFormMapper<ZxOrderPay> {

    List<ZxOrderPay> findByPayCode(String payCode);

    List<ZxOrderPay> findByOrderCode(String orderCode);
}