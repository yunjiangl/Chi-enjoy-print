package com.zx.share.platform.wechat.api.pay.payapi;

import com.zx.share.platform.wechat.api.pay.model.WxConfig;
import com.zx.share.platform.wechat.api.pay.util.WeixinApiUtils;

import java.util.Map;

/**
 * 二维码支付
 */
public class InstantArrivalPay extends AbstractWxPay {

    public InstantArrivalPay() {
    }

    public InstantArrivalPay(WxConfig wxConfig) {
        super(wxConfig);
    }

    /**
     * 发起二维码支付
     * @param tradeNo   交易订单号
     * @param subJect   标题
     * @param body      内容
     * @param price     价格（单位：分）
     * @return
     */
    public Map<String, Object> createPay(String tradeNo,String subJect,String body,int price) {
        return WeixinApiUtils.createOrder(wxConfig,tradeNo, subJect, body, price, "", NATIVE);
    }




}
