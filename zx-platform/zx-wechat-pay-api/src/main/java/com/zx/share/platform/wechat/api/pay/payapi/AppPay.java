package com.zx.share.platform.wechat.api.pay.payapi;

import com.zx.share.platform.wechat.api.pay.model.WxConfig;
import com.zx.share.platform.wechat.api.pay.util.WeixinApiUtils;

import java.util.Map;

/**
 * app 支付
 */
public class AppPay extends AbstractWxPay {

    public AppPay() {
    }

    public AppPay(WxConfig wxConfig) {
        super(wxConfig);
    }

    /**
     * 发起APP支付
     * @param tradeNo   交易订单号
     * @param subJect   标题
     * @param body      内容
     * @param price     价格（单位：分）
     * @param openId    weixin openId
     * @return
     */
    public Map<String, Object> createPay(String tradeNo,String subJect,String body,int price,String openId) {
        return WeixinApiUtils.createOrder(wxConfig,tradeNo, subJect, body, price, openId, APP);
    }



}
