package com.zx.share.platform.wechat.api.pay.service.impl;

import com.lorne.core.framework.exception.ServiceException;
import com.lorne.core.framework.utils.KidUtils;
import com.zx.share.platform.wechat.api.pay.payapi.AccountPay;
import com.zx.share.platform.wechat.api.pay.payapi.CreditCardPay;
import com.zx.share.platform.wechat.api.pay.service.WeCharPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by fenggang on 18/2/27.
 *
 * @author fenggang
 * @date 18/2/27
 */
@Service
public class WeCharPayServiceImpl implements WeCharPayService {

    @Autowired
    private CreditCardPay creditCardPay;

    @Autowired
    private AccountPay accountPay;

    /**
     * 刷卡支付
     * @param
     * @return
     */
    @Override
    public Map<String, Object> microPay(String authCode ,String outTradeNo ) {
        String  deviceInfo ="001";
        String  body ="商品描述";
        int  totalFee = 1;
        Map<String ,Object> map = creditCardPay.payMicropay(authCode ,deviceInfo ,body ,outTradeNo , totalFee );
        return map;
    }


    @Override
    public Map<String, Object> queryOrder(String outTradeNo) {
        return creditCardPay.getOrderQuery(outTradeNo);
    }

    @Override
    public boolean refundOrder(String outTradeNo, int money) {
        return creditCardPay.refundOrder(outTradeNo, KidUtils.getKid(),money,money);
    }


    @Override
    public boolean closeOrder(String outTradeNo) {
        return creditCardPay.closeOrder(outTradeNo);
    }


    @Override
    public Map<String, Object> transfers(String openid, int amount) {
        String partner_trade_no = KidUtils.getKid();
        return creditCardPay.transfers(partner_trade_no,openid,"NO_CHECK","",amount,"奖金","192.168.2.1");
    }



    @Override
    public Map<String, Object> accountPay(int amount, String openId) {
        String tradeNo = KidUtils.getKid();
        return accountPay.createPay(tradeNo,"小走","契约金",amount,openId);
    }

    @Override
    public Map<String, Object> getOpenId(String code) {
        try {
            return accountPay.getOpendIdAndSessionKey(code);
        } catch (ServiceException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<String, Object> payUnifiedorder(String body, String detail, int total_fee, String ip, String out_trade_no, String openid, String trade_type) {
        out_trade_no = out_trade_no.replaceAll("wechat","");
        return creditCardPay.payUnifiedorder(body,detail,total_fee,ip,out_trade_no,openid,trade_type);
    }
}
