package com.zx.share.platform.wechat.api.pay.service;

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
}
