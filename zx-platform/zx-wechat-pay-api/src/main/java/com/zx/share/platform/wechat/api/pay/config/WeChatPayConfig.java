package com.zx.share.platform.wechat.api.pay.config;

import com.lorne.core.framework.utils.config.ConfigHelper;
import com.zx.share.platform.wechat.api.pay.model.WxConfig;
import com.zx.share.platform.wechat.api.pay.payapi.AccountPay;
import com.zx.share.platform.wechat.api.pay.payapi.CreditCardPay;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by fenggang on 18/2/27.
 *
 * @author fenggang
 * @date 18/2/27
 */
@Configuration
//@PropertySource(value = {"classpath:/application.properties"}, ignoreResourceNotFound = true, encoding = "utf-8")
public class WeChatPayConfig {

    @Bean
    public CreditCardPay creditCardPay(){
        WxConfig config = new WxConfig();

        ConfigHelper helper = new ConfigHelper("weixin.properties");
        config.setAppId(helper.getStringValue("appId"));
        config.setMchId(helper.getStringValue("mchId"));
        config.setAppSecret(helper.getStringValue("appSecret"));
        config.setCertLocalPath(helper.getStringValue("certPath"));
        config.setKey(helper.getStringValue("key"));
        config.setNotifyUrl(helper.getStringValue("notifyUrl"));
        config.setCertPassword(helper.getStringValue("certPassword"));
        CreditCardPay creditCardPay = new CreditCardPay(config);
        return creditCardPay;
    }


    @Bean
    public AccountPay accountPay(){
        WxConfig config = new WxConfig();

        ConfigHelper helper = new ConfigHelper("weixin.properties");
        config.setAppId(helper.getStringValue("appId"));
        config.setMchId(helper.getStringValue("mchId"));
        config.setAppSecret(helper.getStringValue("appSecret"));
        config.setCertLocalPath(helper.getStringValue("certPath"));
        config.setKey(helper.getStringValue("key"));
        config.setNotifyUrl(helper.getStringValue("notifyUrl"));
        config.setCertPassword(helper.getStringValue("certPassword"));
        AccountPay accountPay = new AccountPay(config);
        return accountPay;
    }
}
