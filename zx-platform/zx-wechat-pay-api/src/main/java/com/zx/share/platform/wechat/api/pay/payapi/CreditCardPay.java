package com.zx.share.platform.wechat.api.pay.payapi;


import com.zx.share.platform.wechat.api.pay.model.WxConfig;
import com.zx.share.platform.wechat.api.pay.util.WeixinUtils;

import java.util.Map;

public class CreditCardPay extends AbstractWxPay{

    public CreditCardPay() {
    }

    public CreditCardPay(WxConfig wxConfig) {
        super(wxConfig);
    }

    /**
     * 提交刷卡支付
     * @param authCode    支付码
     * @param deviceInfo  终端设备号(商户自定义，如门店编号)
     * @param body         商品描述
     * @param outTradeNo  商户订单号
     * @param totalFee    订单金额
     * @return  支付请求结果
     */
    public  Map<String , Object>  payMicropay (String authCode ,String deviceInfo , String body , String outTradeNo , int totalFee ){

        // 调用微信支付API的机器IP
        String ip = "127.0.0.1";
        /**
         * 提交刷卡支付
         */
        return WeixinUtils.payMicropay(wxConfig , authCode , deviceInfo , body, outTradeNo ,ip , totalFee );
    }



}
