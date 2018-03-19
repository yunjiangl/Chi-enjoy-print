package com.zx.share.platform.wechat.api.pay.service;

import com.zx.share.platform.wechat.api.pay.model.WxConfig;

import java.util.Map;

/**
 * Created by fenggang on 18/2/27.
 *
 * @author fenggang
 * @date 18/2/27
 */
public interface WeCharPayService {

    Map<String,Object> microPay(String authCode , String outTradeNo );


    Map<String, Object> queryOrder(String outTradeNo) ;


    boolean refundOrder(String outTradeNo,int money);

    boolean closeOrder(String outTradeNo);


    Map<String,Object> transfers( String openid, int amount);

    Map<String,Object> accountPay(int amount, String openId);

    Map<String,Object> getOpenId(String code);

    /**
     * 统一下单
     * @param body
     * @param detail
     * @param total_fee
     * @param ip
     * @param out_trade_no
     * @param openid
     * @param trade_type
     * @return
     */
    public Map<String, Object> payUnifiedorder(String body, String detail, int total_fee, String ip, String out_trade_no, String openid, String trade_type);
}
